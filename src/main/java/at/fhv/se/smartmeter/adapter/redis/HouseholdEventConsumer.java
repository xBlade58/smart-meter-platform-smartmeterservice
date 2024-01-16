package at.fhv.se.smartmeter.adapter.redis;

import java.time.Duration;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.stream.Consumer;
import org.springframework.data.redis.connection.stream.MapRecord;
import org.springframework.data.redis.connection.stream.ReadOffset;
import org.springframework.data.redis.connection.stream.StreamOffset;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.stream.StreamListener;
import org.springframework.data.redis.stream.StreamMessageListenerContainer;
import org.springframework.data.redis.stream.StreamMessageListenerContainer.StreamMessageListenerContainerOptions;
import org.springframework.data.redis.stream.Subscription;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;

import at.fhv.se.smartmeter.adapter.redis.events.HouseholdEvent;
import io.lettuce.core.api.async.RedisAsyncCommands;
import io.lettuce.core.codec.StringCodec;
import io.lettuce.core.output.StatusOutput;
import io.lettuce.core.protocol.CommandArgs;
import io.lettuce.core.protocol.CommandKeyword;
import io.lettuce.core.protocol.CommandType;

@Component
@EnableScheduling
public class HouseholdEventConsumer implements StreamListener<String, MapRecord<String, String, String>>, 
    InitializingBean, DisposableBean {

    @Autowired
    private RedisTemplate<String, HouseholdEvent> redisTemplate;

    @Autowired
    private HouseholdEventHandler eventHanlder;

    @Value("${redis.consumer-name}")
    private String consumerName = "test";

    @Value("${redis.consumer-group-name}")
    private String consumerGroupName;
    
    @Value("${redis.stream-name}")
    private String streamName;

    private StreamMessageListenerContainer<String, MapRecord<String, String, String>> listenerContainer;
    private Subscription subscription;

    @Override
    public void onMessage(MapRecord<String, String, String> message) {
        
        try {
            eventHanlder.handle(message.getValue());
        } catch (JsonProcessingException | IllegalArgumentException e) {
           // e.printStackTrace();
            System.out.println("Could not parse to HouseholdEvent. Skipping message with id: " + message.getId());
        }
        redisTemplate.opsForStream().acknowledge(consumerGroupName, message);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        try {
            //create consumer group for the stream
            // if stream does not exist it will create stream first then create consumer group
            if (!redisTemplate.hasKey(streamName)) {
                System.out.println(streamName + " does not exist. Creating stream along with the consumer group");
                RedisAsyncCommands commands = (RedisAsyncCommands) redisTemplate.getConnectionFactory()
                        .getConnection().getNativeConnection();
                CommandArgs<String, String> args = new CommandArgs<>(StringCodec.UTF8)
                        .add(CommandKeyword.CREATE)
                        .add(streamName)
                        .add(consumerGroupName)
                        .add("0")
                        .add("MKSTREAM");
                commands.dispatch(CommandType.XGROUP, new StatusOutput<>(StringCodec.UTF8), args);
            } else {
                //creating consumer group
                redisTemplate.opsForStream().createGroup(streamName, ReadOffset.from("0"), consumerGroupName);
            }
        } catch (Exception ex) {
            System.out.println("Consumer group already present for stream name: " + streamName);
        }

        StreamMessageListenerContainerOptions<String, MapRecord<String, String, String>> containerOptions = StreamMessageListenerContainerOptions
                    .builder().pollTimeout(Duration.ofMillis(100)).build();
        this.listenerContainer = StreamMessageListenerContainer.create(redisTemplate.getConnectionFactory(), containerOptions);

        this.subscription = listenerContainer.receive(
                Consumer.from(consumerGroupName, consumerName),
                StreamOffset.create(streamName, ReadOffset.lastConsumed()),
                this);

        subscription.await(Duration.ofSeconds(2));
        listenerContainer.start();
    }

    @Override
    public void destroy() throws Exception {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'destroy'");
    }
    
}
