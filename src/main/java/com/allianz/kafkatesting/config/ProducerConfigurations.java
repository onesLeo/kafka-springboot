package com.allianz.kafkatesting.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ProducerConfigurations {
    @Bean
    public ProducerFactory<Integer,String> producerFactory(){
        DefaultKafkaProducerFactory<Integer,String> defaultFactory = new DefaultKafkaProducerFactory<>(producerConfigs());
        return defaultFactory;
    }

    @Bean
    public Map<String, Object> producerConfigs(){
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092, localhost:9093, localhost:9094");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
        props.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, "snappy");
        props.put(ProducerConfig.RETRIES_CONFIG,10);
        props.put(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION,1);
        props.put(ProducerConfig.ACKS_CONFIG,"all");
        return props;
    }

    @Bean
    public KafkaTemplate<Integer,String> kafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }
}
