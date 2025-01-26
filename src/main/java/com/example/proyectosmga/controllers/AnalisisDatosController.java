package com.example.proyectosmga.controllers;

import com.example.proyectosmga.services.AnalisisDatosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/analisis")
public class AnalisisDatosController {

    @Autowired
    private AnalisisDatosService analisisDatosService;

    @PostMapping
    public String analizarDatos(@RequestBody String datos) {
        analisisDatosService.procesarDatos(datos);
        return "Datos en procesamiento: " + datos;
    }
}
