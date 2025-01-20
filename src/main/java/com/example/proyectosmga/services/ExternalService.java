package com.example.proyectosmga.services;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

@Service
public class ExternalService {

    @CircuitBreaker(name = "externalService", fallbackMethod = "fallback")
    public String callExternalService() {
        // Simula una llamada que puede fallar
        throw new RuntimeException("Error en el servicio externo");
    }

    public String fallback(Throwable throwable) {
        return "Respuesta predeterminada debido a error: " + throwable.getMessage();
    }
}
