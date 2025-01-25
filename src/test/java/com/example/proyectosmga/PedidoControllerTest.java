package com.example.proyectosmga;


import com.example.proyectosmga.models.Pedido;
import com.example.proyectosmga.repositories.PedidoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PedidoControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private PedidoRepository pedidoRepository;

    @BeforeEach
    public void setup() {
        pedidoRepository.deleteAll();
    }

    @Test
    public void testCrearPedido() {
        Pedido pedido = new Pedido();
        pedido.setDescripcion("Laptop");
        pedido.setTotal(3);

        webTestClient.post().uri("/pedidos")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(pedido)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .isEqualTo("Pedido creado y evento enviado.");

        Assertions.assertEquals(1, pedidoRepository.findAll().size());
    }
}

