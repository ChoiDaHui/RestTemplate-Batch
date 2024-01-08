package com.testapibatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class TestapiBatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestapiBatchApplication.class, args);
    }

}
