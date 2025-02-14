package com.example.demoMicro;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build(); // Este es el RestTemplate sin autenticación
    }

    @Bean
    public RestTemplate authRestTemplate(RestTemplateBuilder builder) {
        return builder
                .basicAuthentication("admin", "adminpassword") // Configura las credenciales de autenticación
                .build();
    }
}
