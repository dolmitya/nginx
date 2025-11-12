package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/")
    public String home() {
        // сначала пробуем конкретную переменную INSTANCE (установим её в docker-compose),
        // иначе возвращаем HOSTNAME (container id)
        String instance = System.getenv("INSTANCE");
        if (instance == null || instance.isBlank()) {
            instance = System.getenv("HOSTNAME");
            if (instance == null) instance = "unknown";
        }
        return "Hello from instance=" + instance;
    }
}
