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
    public Pedido createOrder(@RequestBody Pedido pedido) {
        System.out.println("Descripción: " + pedido.getDescripcion());
        System.out.println("Cantidad: " + pedido.getTotal());
        return pedidoService.createPedido(pedido);
    }

    @GetMapping
    public Iterable<Pedido> getAllOrders() {
        return pedidoService.findAllOrders();
    }
}
