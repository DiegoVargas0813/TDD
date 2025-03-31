package com.example.demo.controller;

import com.example.demo.model.greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class greetingController {
    
    private static final String template = "Hello, %s!";

    @GetMapping("/greeting")
    public greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new greeting(String.format(template, name));
    }
}
