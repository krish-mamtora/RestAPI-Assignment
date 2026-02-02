package com.example.RestAPI2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hii")
public class Hello {
    @GetMapping
    public String hii(){
        return "hello";
    }
}
