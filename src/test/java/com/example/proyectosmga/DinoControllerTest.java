package com.example.proyectosmga;

import com.example.proyectosmga.models.Dinosaurio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DinoControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testGetDinosaurios() {
        webTestClient.get().uri("/dinosaurios")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Dinosaurio.class)
                .hasSize(2)
                .contains(new Dinosaurio(1L, "Tyrannosaurus Rex"),
                        new Dinosaurio(2L, "Velociraptor"));
    }
}
