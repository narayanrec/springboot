package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class StackControllerTest {

    @Autowired
    private MockMvc mvc;

    @BeforeEach
    void setUp() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/api/stack/push/1").accept(MediaType.APPLICATION_JSON));
        mvc.perform(MockMvcRequestBuilders.post("/api/stack/push/2").accept(MediaType.APPLICATION_JSON));
        mvc.perform(MockMvcRequestBuilders.post("/api/stack/push/3").accept(MediaType.APPLICATION_JSON));
        mvc.perform(MockMvcRequestBuilders.post("/api/stack/push/4").accept(MediaType.APPLICATION_JSON));
        mvc.perform(MockMvcRequestBuilders.post("/api/stack/push/5").accept(MediaType.APPLICATION_JSON));
    }

    @Test
    void push() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/api/stack/push/6").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                ;
    }

    @Test
    void pop() throws Exception {
        mvc.perform(MockMvcRequestBuilders.delete("/api/stack/pop").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("5")))
                ;
    }

    @Test
    void get() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/stack/get").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("5")));
    }


}