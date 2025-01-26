package com.example.proyectosmga;

import com.example.proyectosmga.models.Dinosaurio;
import com.example.proyectosmga.models.Pedido;
import com.example.proyectosmga.services.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
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
    @Autowired
    private AnalisisDatosService analisisDatosService;


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

    @Test
    public void testAspectExecution() {
        webTestClient.get().uri("/perform?task=aspectTest")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    public void testConcurrentRequests() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {
                webTestClient.get().uri("/perform?task=concurrentTest")
                        .exchange()
                        .expectStatus().isOk();
            });
        }

        executor.shutdown();
        if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
            throw new InterruptedException("Timeout while waiting for threads to finish.");
        }
    }

    @Test
    void testProcesarDatos() {
        analisisDatosService.procesarDatos("Datos de prueba");
        analisisDatosService.shutdown();
    }

    @Test
    public void testProcesarAlerta() {
        SecurityService seguridadService = new SecurityService();
        seguridadService.performTask("Alerta de seguridad");
    }


}
