package org.example.practice.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @EnableFeignClients(defaultConfiguration = FeignConfiguration.class) 全局配置，优先级低于@FeignClient.configuration
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ServerConsumer {
    public static void main(String[] args) {
        SpringApplication.run(ServerConsumer.class, args);
    }
}
