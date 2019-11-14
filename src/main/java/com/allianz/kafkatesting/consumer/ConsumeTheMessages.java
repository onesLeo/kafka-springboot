package com.allianz.kafkatesting.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class ConsumeTheMessages {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumeTheMessages.class);

    @KafkaListener(topics = "testingkafka1",groupId = "testingKafka1GroupC")
    public void listen(String data){
            LOGGER.info("YOUR DATA in KAFKA {}",data);
    }

    @KafkaListener(topics = "my-replicated-topics",groupId = "testingKafka1GroupC")
    public void listenSecond(String data, Acknowledgment ack){
            LOGGER.info("YOUR DATA in KAFKA {}",data);
//            ack.acknowledge();
    }

    @KafkaListener(topics = "partitions-topic",groupId = "testingKafka1GroupC")
    public void listenthirdTopics(String data){
            LOGGER.info("YOUR DATA in KAFKA {}",data);
    }
}
