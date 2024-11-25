package com.ikeraguero.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class RestDemoApplication {

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World!";
    }
}
