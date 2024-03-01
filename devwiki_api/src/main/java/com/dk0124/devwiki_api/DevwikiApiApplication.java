package com.dk0124.devwiki_api;

import com.dk0124.devwiki_core.DevwikiCoreConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@Import(DevwikiCoreConfiguration.class)
@SpringBootApplication
public class DevwikiApiApplication {
    public static void main(String[] args) {
        System.setProperty("spring.config.name", "application-core, application-api");
        SpringApplication.run(DevwikiApiApplication.class, args);
    }

}
