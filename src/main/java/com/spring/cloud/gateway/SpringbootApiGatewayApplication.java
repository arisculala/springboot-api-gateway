package com.spring.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.spring.cloud.gateway")
public class SpringbootApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApiGatewayApplication.class, args);
    }

}
