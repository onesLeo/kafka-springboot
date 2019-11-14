package com.allianz.kafkatesting.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {
    @Bean
    public KafkaAdmin admin(){
        Map<String,Object> configs= new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092,localhost:9093,localhost:9094");
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic topic1(){
        return TopicBuilder.name("testingkafka1").
                partitions(10).
                replicas(3).
                compact().
                build();
    }

    @Bean
    public NewTopic topic2(){
        return TopicBuilder.name("my-replicated-topics").
                partitions(10).
                replicas(3).
                compact().
                build();
    }

    @Bean
    public NewTopic topic3(){
        return TopicBuilder.name("replicated-topics").
                partitions(2).
                replicas(3).
                compact().
                build();
    }
}
