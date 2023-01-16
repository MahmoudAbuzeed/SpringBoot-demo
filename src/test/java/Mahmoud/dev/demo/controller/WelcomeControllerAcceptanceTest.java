package Mahmoud.dev.demo.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.HttpStatus.OK;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class WelcomeControllerAcceptanceTest {

    @LocalServerPort
    int randomServerPort;

    private RestTemplate restTemplate;
    private String url;

    @BeforeEach
    void setup(){
        restTemplate = new RestTemplate();
        url = "http://localhost:" + randomServerPort + "/welcome";
    }
    @Test
    void shouldGetDefaultWelcomeMessage() throws Exception {
        ResponseEntity responseEntity = restTemplate.getForEntity(url, String.class);
        assertEquals(OK, responseEntity.getStatusCode());
        assertEquals("Welcome Stranger", responseEntity.getBody());
    }

    @Test
    void shouldGetCustomWelcomeMessage() throws Exception {
        ResponseEntity responseEntity = restTemplate.getForEntity(url + "?name=Mahmoud", String.class);
        assertEquals(OK, responseEntity.getStatusCode());
        assertEquals("Welcome Mahmoud", responseEntity.getBody());
    }

}