package com.nedyalkoboydev.autoserviceplatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AutoServicePlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutoServicePlatformApplication.class, args);
    }

}
