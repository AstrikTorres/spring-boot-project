package com.gestopago.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestopago.springboot.service.AddressService;

@RestController
@RequestMapping("/")
public class PagesController {

    private final AddressService addressService;

    public PagesController(AddressService addressService) {
        this.addressService = addressService;
    }

    @RequestMapping("/home")
    public String index() throws Exception {
        String serverAddress = addressService.getServerAddress();
        return "Gestopago Spring Boot - Home" + " \nFrom IP address: " + serverAddress;
    }

    @RequestMapping("/admin")
    public String admin() throws Exception {
        String serverAddress = addressService.getServerAddress();
        return "Gestopago Spring Boot - Admin" + " \nFrom IP address: " + serverAddress;
    }
}
