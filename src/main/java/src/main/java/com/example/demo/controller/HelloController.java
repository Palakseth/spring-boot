package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World! Welcome to Spring Boot!";
    }

    @GetMapping("/")
    public String home() {
        return "Spring Boot Application is running successfully!";
    }
}
