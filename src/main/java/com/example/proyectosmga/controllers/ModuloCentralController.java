package com.example.proyectosmga.controllers;

import com.example.proyectosmga.services.ModuloCentralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/modulo-central")
public class ModuloCentralController {

    @Autowired
    private ModuloCentralService moduloCentralService;

    @PostMapping("/procesar")
    public String procesarEvento(@RequestParam String origen, @RequestBody String evento) {
        moduloCentralService.procesarEventos(origen, evento);
        return "Evento procesado desde el subsistema: " + origen;
    }
}
