package com.lee.config;

/**
 * kafka的生产者
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Value("${custom.kafka.topic}")
    private String topic;

    public void send(String sendMsg) {
        kafkaTemplate.send(this.topic, sendMsg);
    }
}
