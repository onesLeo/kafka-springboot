package com.allianz.kafkatesting.producer;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendingMessage {
    private KafkaTemplate kafkaTemplate;
    private static final Logger LOGGER = LoggerFactory.getLogger(SendingMessage.class);

    public SendingMessage(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/sending-message")
    public String sendingMessageToTopics(@RequestParam("message") String yourmessage, @RequestParam("topic") String topic) {
        LOGGER.info("YOU'RE ABOUT TO SENDING MESSAGE TO KAFKA");
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, yourmessage);

        ListenableFuture<SendResult<Integer, String>> future = kafkaTemplate.send(record);
        future.addCallback(new MyCallBackImpl());

        return "SUCCESSFULLY SENDING YOUR MESSAGE";
    }
}
