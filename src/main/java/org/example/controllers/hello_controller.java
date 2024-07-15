package org.example.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first")
public class hello_controller {

    @GetMapping("/hello")
    public String helloPage() {
        return "hello!";
    }
}
