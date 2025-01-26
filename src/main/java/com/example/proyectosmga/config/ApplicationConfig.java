package com.example.proyectosmga.config;

import com.example.proyectosmga.EventPublisher;
import com.example.proyectosmga.services.ModuloCentralService;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class ApplicationConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    @Bean
    public ModuloCentralService moduloCentralService() {
        return new ModuloCentralService();
    }
}
