package com.pfm.Spring_Backend.dto;

import org.junit.jupiter.api.Test;

public class InputDtoTest {
    @Test
    void test() {
        InputDto inputDto = InputDto.builder().value("testValue").build();

        System.out.println(inputDto.toString());
    }
}