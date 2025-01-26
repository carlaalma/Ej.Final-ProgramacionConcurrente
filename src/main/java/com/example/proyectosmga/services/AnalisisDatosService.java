package com.example.proyectosmga.services;

import org.springframework.stereotype.Service;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class AnalisisDatosService {

    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public void procesarDatos(String datos) {
        executorService.submit(() -> {
            System.out.println("Procesando: " + datos + " en " + Thread.currentThread().getName());
            // Simular procesamiento intensivo
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }

    public void shutdown() {
        executorService.shutdown();
    }
}
