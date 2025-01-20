package com.example.proyectosmga.controllers;

import com.example.proyectosmga.services.MarteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/marte")
public class MarteController {

    @Autowired
    private MarteService marteService;

    @GetMapping("/procesar")
    public ResponseEntity<String> procesarDatos() {
        marteService.processData();
        return ResponseEntity.ok("Datos procesados correctamente.");
    }
}
