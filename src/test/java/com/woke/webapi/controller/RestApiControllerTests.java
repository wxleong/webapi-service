package com.woke.webapi.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.woke.webapi.Constant.WEBAPI_V1_GET_TEST_DATA;
import static com.woke.webapi.Constant.WEBAPI_V1_PING;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestApiControllerTests {
    @LocalServerPort
    private int serverPort;
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void cors() {
        /* "Access-Control-Allow-Origin" is not set if "Origin" is not set */
        String result = webTestClient
                .get().uri("http://localhost:" + serverPort + WEBAPI_V1_PING)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType("text/plain;charset=UTF-8")
                .expectHeader().doesNotExist("Access-Control-Allow-Origin")
                .expectBody(String.class)
                .returnResult()
                .getResponseBody();
        Assertions.assertEquals(result, "pong");

        /* "Access-Control-Allow-Origin" is set if "Origin" is set */
        result = webTestClient
                .get().uri("http://localhost:" + serverPort + WEBAPI_V1_PING)
                .header("Origin", "http://somewhere")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType("text/plain;charset=UTF-8")
                .expectHeader().valueEquals("Access-Control-Allow-Origin", "*")
                .expectBody(String.class)
                .returnResult()
                .getResponseBody();
        Assertions.assertEquals(result, "pong");

        /* "Access-Control-Allow-Origin" is not set if "Origin" is set to server URI */
        result = webTestClient
                .get().uri("http://localhost:" + serverPort + WEBAPI_V1_PING)
                .header("Origin", "http://localhost:" + serverPort)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType("text/plain;charset=UTF-8")
                .expectHeader().doesNotExist("Access-Control-Allow-Origin")
                .expectBody(String.class)
                .returnResult()
                .getResponseBody();
        Assertions.assertEquals(result, "pong");
    }

    @Test
    void v1Ping() {
        String result = webTestClient
                .get().uri("http://localhost:" + serverPort + WEBAPI_V1_PING)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType("text/plain;charset=UTF-8")
                .expectHeader().doesNotExist("Access-Control-Allow-Origin")
                .expectBody(String.class)
                .returnResult()
                .getResponseBody();
        Assertions.assertEquals(result, "pong");
    }

    @Test
    void v1GetTestData() throws IOException {
        String fileName = "src/main/resources/test-data/db.json";
        String expectedOutput = new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8);
        String result = webTestClient
                .get().uri("http://localhost:" + serverPort + WEBAPI_V1_GET_TEST_DATA)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(String.class)
                .returnResult()
                .getResponseBody();
        Assertions.assertEquals(expectedOutput.trim(), result.trim());
    }
}
