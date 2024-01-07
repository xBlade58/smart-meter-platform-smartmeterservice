package at.fhv.se.smartmeter.adapter.mqtt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

import com.fasterxml.jackson.core.JsonProcessingException;

import at.fhv.se.smartmeter.adapter.dto.MeterReadingDTO;
import at.fhv.se.smartmeter.domain.port.inbound.meterReading.CreateMeterReadingUseCase;

@Configuration
public class MqttAdapter {

    @Value("${mqtt.broker.url}")
    private String brokerUrl;

    @Value("${mqtt.client.id}")
    private String clientId;

    @Value("${mqtt.readings-topic}")
    private String topic;

    @Value("${mqtt.trust-store}")
    private String trustStore;

    @Value("${mqtt.trust-store-password}")
    private String trustStorePassword;

    @Autowired
    private CreateMeterReadingUseCase createMeterReadingUseCase;

    @Autowired
    private Parser parser;

    @Bean
    public MqttPahoClientFactory mqttClientFactory() {
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        String [] arr = new String[1];
        arr[0] = brokerUrl;
        factory.getConnectionOptions().setServerURIs(arr);
        //factory.getConnectionOptions().setSocketFactory(SocketFactoryUtil.createSocketFactory(trustStore, trustStorePassword));
        return factory;
    }
    
    @Bean
    public MessageChannel mqttInputChannel() {
        return new DirectChannel();
    }

    @Bean
    public MqttPahoMessageDrivenChannelAdapter inbound() {
        MqttPahoMessageDrivenChannelAdapter adapter =
            new MqttPahoMessageDrivenChannelAdapter(clientId, mqttClientFactory(), topic);
        adapter.setCompletionTimeout(5000);
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setQos(1);
        adapter.setOutputChannel(mqttInputChannel()); // throws exeception "outputChannel required" if not set
        return adapter;
    }


    @Bean
    @ServiceActivator(inputChannel = "mqttInputChannel")
    public MessageHandler handler() {
        return (message) -> {
            MeterReadingDTO dto;
            try {
                dto = parser.parse(message);
                createMeterReadingUseCase.createMeterReading(dto);
            } catch (JsonProcessingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                System.out.println("Skipping Message because of invalid format.");
            }
            
        };
    }
}
