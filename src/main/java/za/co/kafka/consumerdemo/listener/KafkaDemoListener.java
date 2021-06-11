package za.co.kafka.consumerdemo.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaDemoListener {

    @KafkaListener(topics = "message-test", containerFactory = "kafkaListenerContainerFactory")
    public void subscribe(@Payload Message message) {
        System.out.println("Message received successfully...!!!");
        System.out.println(message);
    }
}
