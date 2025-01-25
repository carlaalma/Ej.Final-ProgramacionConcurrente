package com.example.proyectosmga;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HechizoControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testCastSpell() {
        webTestClient.get()
                .uri(uriBuilder -> uriBuilder.path("/hechizos")
                        .queryParam("spell", "Lumos")
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .isEqualTo("El hechizo Lumos ha sido ejecutado con éxito.");
    }

    @Test
    public void testFallbackSpell() {
        webTestClient.get()
                .uri(uriBuilder -> uriBuilder.path("/hechizos")
                        .queryParam("spell", "SpellNotAvailable")
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .isEqualTo("El hechizo SpellNotAvailable no está disponible en este momento.");
    }
}
