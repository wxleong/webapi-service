package com.woke.webapi.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

import static com.woke.webapi.Constant.WEBAPI_V1_PING;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestApiControllerTests {
    @LocalServerPort
    private int serverPort;
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void v1Ping() {
        String result = webTestClient
                .get().uri("http://localhost:" + serverPort + WEBAPI_V1_PING)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .returnResult()
                .getResponseBody();
        Assertions.assertEquals(result, "pong");
    }
}
