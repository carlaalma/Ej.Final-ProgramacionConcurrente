package com.example.proyectosmga.controllers;


import com.example.proyectosmga.models.Pedido;
import com.example.proyectosmga.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<String> crearPedido(@RequestBody Pedido pedido) {
        pedidoService.createPedido(pedido);
        return ResponseEntity.ok("Pedido creado y evento enviado.");
    }

    @GetMapping
    public Iterable<Pedido> getAllOrders() {
        return pedidoService.findAllOrders();
    }
}
