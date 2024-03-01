package com.dk0124.devwiki_core;


import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@Configuration
@ActiveProfiles("local")
@TestPropertySource(properties = "spring.config.name=application-core")
@SpringBootTest(classes = DevwikiCoreConfiguration.class)
public class IntegrationTest {
}
