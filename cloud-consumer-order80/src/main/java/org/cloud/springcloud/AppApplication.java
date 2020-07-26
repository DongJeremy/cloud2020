package org.cloud.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class AppApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(AppApplication.class);
        application.run(args);
        log.info("============= SpringBoot Start Success =============");
    }
}
