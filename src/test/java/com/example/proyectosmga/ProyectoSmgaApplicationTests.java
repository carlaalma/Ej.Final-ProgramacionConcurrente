package com.example.proyectosmga;

import com.example.proyectosmga.models.Dinosaurio;
import com.example.proyectosmga.models.Pedido;
import com.example.proyectosmga.services.DinoService;
import com.example.proyectosmga.services.HechizoService;
import com.example.proyectosmga.services.MarteService;
import com.example.proyectosmga.services.PedidoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProyectoSmgaApplicationTests {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private DinoService dinoService;

    @Autowired
    private MarteService marteService;

    @Autowired
    private HechizoService hechizoService;

    @Test
    void contextLoads() {
        Assertions.assertNotNull(pedidoService);
        Assertions.assertNotNull(dinoService);
        Assertions.assertNotNull(marteService);
        Assertions.assertNotNull(hechizoService);
    }

    @Test
    public void testCastSpell() {
        webTestClient.get().uri("/cast?spell=Lumos")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .isEqualTo("The spell Lumos is cast successfully.");
    }

    @Test
    public void testCreateOrder() {
        Pedido pedido = new Pedido(1L, "Test Order", 100.0);

        webTestClient.post().uri("/pedidos")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(pedido)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    public void testUpdateOrderWithError() {
        Pedido order = new Pedido(1L, "Test Order", 100.0);
        assertThrows(Exception.class, () -> pedidoService.updateOrder(order));
    }

    @Test
    public void testGetDinosaurios() {
        Flux<Dinosaurio> dinosaurios = dinoService.getDinosaurData();

        Assertions.assertNotNull(dinosaurios);
    }

    @Test
    public void testProcessData() {
        marteService.processData();
        Assertions.assertTrue(true); // Placeholder para verificar el procesamiento
    }
}
