package com.example.proyectosmga.controllers;

import com.example.proyectosmga.models.Dinosaurio;
import com.example.proyectosmga.services.DinoService;
import reactor.core.publisher.Flux;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dinosaurios")
public class DinoController {

    private final DinoService dinosaurioService;

    public DinoController(DinoService dinosaurioService) {
        this.dinosaurioService = dinosaurioService;
    }

    @GetMapping
    public Flux<Dinosaurio> getDinosaurios() {
        return dinosaurioService.getDinosaurData();
    }

}

