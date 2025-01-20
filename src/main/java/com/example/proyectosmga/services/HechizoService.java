package com.example.proyectosmga.services;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

@Service
public class HechizoService {

    @CircuitBreaker(name = "hechizosService", fallbackMethod = "defaultSpell")
    public String castSpell(String spellName) {
        // Simulación de llamada a un microservicio que podría fallar
        if ("Expelliarmus".equals(spellName)) {
            return "El hechizo " + spellName + " ha sido ejecutado con éxito.";
        } else {
            throw new RuntimeException("Error al ejecutar el hechizo");
        }
    }

    public String defaultSpell(String spellName, Throwable throwable) {
        return "El hechizo " + spellName + " no está disponible en este momento.";
    }
}
