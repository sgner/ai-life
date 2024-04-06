package com.life.ai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@EnableWebSocket
@SpringBootApplication
public class AiLifeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AiLifeServiceApplication.class, args);
    }

}
