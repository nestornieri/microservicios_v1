package com.example.demoMicro;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    //tema 11 - conectarse al tema 10 sin seguridad
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build(); // Este es el RestTemplate sin autenticación
    }

    //tema 12 - conectarse al tema 10 con auth basica
    @Bean
    @LoadBalanced
    public RestTemplate authRestTemplate(RestTemplateBuilder builder) {
        return builder
                .basicAuthentication("admin", "adminpassword") // Configura las credenciales de autenticación
                .build();
    }
}
