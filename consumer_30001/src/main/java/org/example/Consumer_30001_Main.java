package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Consumer_30001_Main {
    public static void main(String[] args) {
        SpringApplication.run(Consumer_30001_Main.class,args);
    }
}