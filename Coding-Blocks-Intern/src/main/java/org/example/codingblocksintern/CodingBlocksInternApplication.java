package org.example.codingblocksintern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CodingBlocksInternApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodingBlocksInternApplication.class, args);
    }

}
