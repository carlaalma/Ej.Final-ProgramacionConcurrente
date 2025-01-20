package com.example.proyectosmga.services;

import com.example.proyectosmga.models.Dinosaurio;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;


@Service
public class DinoService {
    public Flux<Dinosaurio> getDinosaurData() {
        return Flux.just(
                new Dinosaurio(1L, "Tyrannosaurus Rex"),
                new Dinosaurio(2L, "Velociraptor")
        );
    }
}
