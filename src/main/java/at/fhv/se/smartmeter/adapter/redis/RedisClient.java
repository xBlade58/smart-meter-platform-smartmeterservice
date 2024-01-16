package at.fhv.se.smartmeter.adapter.redis;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.stream.MapRecord;
import org.springframework.data.redis.connection.stream.StreamOffset;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.stream.StreamListener;
import org.springframework.data.redis.stream.StreamMessageListenerContainer;
import org.springframework.data.redis.stream.Subscription;
import org.springframework.data.redis.stream.StreamMessageListenerContainer.StreamMessageListenerContainerOptions;
import org.springframework.stereotype.Service;

import at.fhv.se.smartmeter.adapter.redis.events.HouseholdEvent;

@Service
public class RedisClient {
    
    @Autowired
    private RedisTemplate<String, HouseholdEvent> redisTemplate;

    private Subscription subscription;


    public void startListening(String streamName) {
        StreamListener<String, MapRecord<String, String, String>> streamListener = new EventStreamListener();
        StreamMessageListenerContainerOptions<String, MapRecord<String, String, String>> containerOptions = StreamMessageListenerContainerOptions
                    .builder().pollTimeout(Duration.ofMillis(100)).build();

        StreamMessageListenerContainer<String, MapRecord<String, String, String>> container = StreamMessageListenerContainer.create(redisTemplate.getConnectionFactory(),
                        containerOptions);
        container.start();

        this.subscription = container.receive(StreamOffset.fromStart(streamName), streamListener);
        System.out.println("Started listening...");    
        System.out.println("Subscription active?: " + this.subscription.isActive());
    }
}
