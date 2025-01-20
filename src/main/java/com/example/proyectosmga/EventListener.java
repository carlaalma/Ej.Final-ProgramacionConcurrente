package com.example.proyectosmga;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EventListener {

    @RabbitListener(queues = "pedidos.queue")
    public void handlePedidos(String message) {
        System.out.println("Mensaje recibido en Pedidos: " + message);
    }

    @RabbitListener(queues = "dinosaurios.queue")
    public void handleDinosaurios(String message) {
        System.out.println("Mensaje recibido en Dinosaurios: " + message);
    }
}
