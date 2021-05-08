package com.pfm.Spring_Backend.repository;

import com.pfm.Spring_Backend.domain.User;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void crud() {
        userRepository.save(new User());

        for (User user : userRepository.findAll()) {
            System.out.println(user);
        }
    }
}