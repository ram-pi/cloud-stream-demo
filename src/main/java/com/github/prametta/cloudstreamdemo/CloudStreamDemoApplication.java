package com.github.prametta.cloudstreamdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.util.function.Consumer;
import java.util.function.Supplier;

@SpringBootApplication
public class CloudStreamDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudStreamDemoApplication.class, args);
    }

    @Bean
    public Supplier<Message<String>> sampleSupplier() {
        return () -> {
            Message<String> m = MessageBuilder
                    .withPayload("test")
//                    .setHeader(KafkaHeaders.KEY, "test")
                    .build();
            System.out.println("Sending message: " + m);
            return m;
        };
    }

    @Bean
    public Consumer<String> sink() {
        return System.out::println;
    }
}

