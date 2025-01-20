package com.example.proyectosmga.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue pedidosQueue() {
        return new Queue("pedidos.queue", true);
    }

    @Bean
    public Queue dinosauriosQueue() {
        return new Queue("dinosaurios.queue", true);
    }

    @Bean
    public Queue marteQueue() {
        return new Queue("marte.queue", true);
    }

    @Bean
    public Queue hechizosQueue() {
        return new Queue("hechizos.queue", true);
    }
}
