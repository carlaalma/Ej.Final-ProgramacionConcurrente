package com.example.proyectosmga.controllers;

import com.example.proyectosmga.services.HechizoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hechizos")
public class HechizoController {

    @Autowired
    private HechizoService hechizoService;


    @GetMapping("/{spell}")
    public ResponseEntity<String> castSpell(@PathVariable String spell) {
        return ResponseEntity.ok(hechizoService.castSpell(spell));
    }
}