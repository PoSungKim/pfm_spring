package com.pfm.Spring_Backend.controller;

import com.pfm.Spring_Backend.dto.InputDto;
import com.pfm.Spring_Backend.repository.UserRepository;

import java.util.List;

import com.pfm.Spring_Backend.domain.User;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

class Hello {
    private String name;

    public Hello(final String name) {
        this.name = name;
    }

    public String getValue() {
        return this.name;
    }

    public void setValue(final String name) {
        this.name = name;
    }
}

@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class HelloController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public @ResponseBody List<User> getAllUsers() {

        return userRepository.findAll();
    }

    @GetMapping("/{userId}")
    public @ResponseBody Hello getHello(@PathVariable("userId") int id) {
        Hello test = new Hello("Hello User");
        System.out.println(id);
        return test;
    }

    @PostMapping("/")
    public @ResponseBody Hello postHello(@RequestBody InputDto inputDto) {
        Hello test = new Hello("Hello User");
        System.out.println(inputDto.toString());
        return test;
    }

    @DeleteMapping("/{id}")
    public void deleteHello(@PathVariable int id) {
        System.out.println(id);
    }

    @PutMapping("/{id}")
    public @ResponseBody ResponseEntity<Hello> putHello(@RequestBody InputDto inputDto, @PathVariable int id) {
        System.out.println(id);
        System.out.println(inputDto.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(new Hello("Hello User"));
    }

}