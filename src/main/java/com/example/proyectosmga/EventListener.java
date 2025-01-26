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

    @RabbitListener(queues = "analisisQueue")
    public void handleAnalisisEvent(String datosProcesados) {
        System.out.println("Evento recibido del subsistema de análisis de datos: " + datosProcesados);
    }
    @RabbitListener(queues = "seguridadQueue")
    public void handleSeguridadEvent(String alerta) {
        System.out.println("Alerta recibida del subsistema de monitoreo de seguridad: " + alerta);
    }

    @RabbitListener(queues = "marteQueue")
    public void handleMarteEvent(String marteEvent) {
        System.out.println("Evento de Misión en Marte recibido: " + marteEvent);
     }

    @RabbitListener(queues = "hechizosQueue")
    public void handleHechizosEvent(String hechizoEvent) {
        System.out.println("Evento de Hechizos recibido: " + hechizoEvent);
     }
}
