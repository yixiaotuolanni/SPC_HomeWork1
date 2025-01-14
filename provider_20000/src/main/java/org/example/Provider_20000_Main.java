package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Provider_20000_Main {
    public static void main(String[] args) {
        SpringApplication.run(Provider_20000_Main.class,args);
    }
}