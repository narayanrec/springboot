package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StackControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        restTemplate.postForEntity("/api/stack/push/1", null, null);
        restTemplate.postForEntity("/api/stack/push/2", null, null);
        restTemplate.postForEntity("/api/stack/push/3", null, null);
        restTemplate.postForEntity("/api/stack/push/4", null, null);
        restTemplate.postForEntity("/api/stack/push/5", null, null);
    }

    @Test
    public void testStackPush() {
        ResponseEntity responseEntity = restTemplate.postForEntity("/api/stack/push/6", null, null);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.resolve(200));
    }

    @Test
    public void testStackPop() {
        ResponseEntity<Integer> responseEntity = restTemplate.exchange("/api/stack/pop", HttpMethod.DELETE, null, Integer.class);
        assertEquals(5, responseEntity.getBody());
        assertEquals(responseEntity.getStatusCode(), HttpStatus.resolve(200));
    }

    @Test
    public void testStackGet() {
        ResponseEntity<Integer> responseEntity = restTemplate.getForEntity("/api/stack/get", Integer.class);
        assertEquals(5, responseEntity.getBody());
        assertEquals(responseEntity.getStatusCode(), HttpStatus.resolve(200));
    }
}
