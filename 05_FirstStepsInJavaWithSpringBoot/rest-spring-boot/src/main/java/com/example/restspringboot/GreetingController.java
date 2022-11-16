package com.example.restspringboot;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    //Mapeia uma requisicao para um metodo e torna isso um endereco HTTP
    @RequestMapping("/greeting")
    public Greeting greeting(
        @RequestParam(value = "name", defaultValue = "World") 
        String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
    
}
