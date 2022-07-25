package com.ynov.controle_front;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ControleFrontApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControleFrontApplication.class, args);
    }

}
