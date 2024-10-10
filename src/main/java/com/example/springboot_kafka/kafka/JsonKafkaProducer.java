package com.example.springboot_kafka.kafka;

import com.example.springboot_kafka.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

    public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    private KafkaTemplate<String, User> kafkaTemplate;
     public void sendMessage(User data){

         LOGGER.info(String.format("Message sent -> %s", data.toString()));
         Message<User> message = MessageBuilder
                 .withPayload(data)
                 .setHeader(KafkaHeaders.TOPIC, "kafkatopic")
                 .build();
         kafkaTemplate.send(message);
     }
}
