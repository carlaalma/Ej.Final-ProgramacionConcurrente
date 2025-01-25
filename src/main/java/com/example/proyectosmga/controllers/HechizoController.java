package com.example.proyectosmga.controllers;

import com.example.proyectosmga.services.HechizoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hechizos")
public class HechizoController {

    @Autowired
    private HechizoService hechizoService;

    @GetMapping
    public String castSpell(@RequestParam String spell) {
        if ("Lumos".equalsIgnoreCase(spell)) {
            return "El hechizo Lumos ha sido ejecutado con éxito.";
        }
        return "El hechizo " + spell + " no está disponible en este momento.";
    }
}