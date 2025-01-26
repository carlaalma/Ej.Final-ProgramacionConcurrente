package com.example.proyectosmga.services;

import com.example.proyectosmga.EventPublisher;

public class ModuloCentralServices {

    private final EventPublisher publisher;

    public ModuloCentralServices(EventPublisher publisher) {
        this.publisher = publisher;
    }

    public void procesarEventos(String subsistemaOrigen, String evento) {
        switch (subsistemaOrigen) {
            case "pedidos":
                System.out.println("Procesando evento de pedidos: " + evento);
                break;

            case "dinosaurios":
                System.out.println("Procesando evento de dinosaurios: " + evento);
                break;

            case "seguridad":
                System.out.println("Procesando evento de seguridad: " + evento);
                break;

            default:
                System.out.println("Evento de origen desconocido: " + evento);
        }
    }
}

