package com.pfm.Spring_Backend.controller;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@WebMvcTest
class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getHello() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/user/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().json("{\"value\" : \"Hello User\"}"));
    }

}