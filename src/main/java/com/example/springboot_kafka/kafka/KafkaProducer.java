package com.example.springboot_kafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    // Instance of KafkaTemplate
    private static KafkaTemplate<String, String> kafkaTemplate;

    // Constructor injection of KafkaTemplate
    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    // Send a message to Kafka topic
    public static void sendMessage(String message) {
        LOGGER.info(String.format("Message sent: %s", message));
        // Use the instance of kafkaTemplate to send the message
        kafkaTemplate.send("kafkatopic", message);
    }
}
