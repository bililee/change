package com.lee.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * kafka的消费者
 */
@Component
public class KafkaConsumer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Value("${custom.kafka.topic}")
    public String topic;


    @KafkaListener(topics = "tp4spring",groupId = "test-consumer-group")
    public void consumer(String msg) {
        Optional<String> kafkaMessage = Optional.ofNullable(msg);
        if (kafkaMessage.isPresent()) {
            System.out.println("got msg from kafka:" + kafkaMessage);
        }

    }

}
