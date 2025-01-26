package com.example.proyectosmga;


import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.core.RabbitTemplate;


@Component
public class EventPublisher {


    private final RabbitTemplate rabbitTemplate;

    public EventPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    public void publishEvent(String exchange, String routingKey, String message) {
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
        System.out.println("Evento publicado: " + message);
    }
}
