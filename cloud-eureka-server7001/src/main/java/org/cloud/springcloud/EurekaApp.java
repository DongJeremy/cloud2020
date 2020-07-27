package org.cloud.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
@EnableEurekaServer
public class EurekaApp {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(EurekaApp.class);
        application.run(args);
        log.info("============= SpringBoot Start Success =============");
    }
}
