package com.gestopago.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PagesController {

    @RequestMapping("/home")
    public String index() {
        return "Gestopago Spring Boot - Home";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "Gestopago Spring Boot - Admin";
    }
}
