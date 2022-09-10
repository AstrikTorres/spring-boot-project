package com.gestopago.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gestopago.springboot.service.AddressService;

@Controller
public class PagesController {

    private AddressService addressService;

    public PagesController(AddressService addressService) {
        super();
        this.addressService = addressService;
    }

    @RequestMapping("/")
    public String viewHome(Model model) throws Exception {
        model.addAttribute(
            "serverAddress",
            addressService.getServerAddress()
        );
        return "home";
    }

    @RequestMapping("/admin")
    public String viewAdmin(Model model) throws Exception {
        model.addAttribute(
                "serverAddress",
                addressService.getServerAddress());
        return "admin";
    }

    @RequestMapping("/user")
    public String viewUser(Model model) throws Exception {
        model.addAttribute(
                "serverAddress",
                addressService.getServerAddress());
        return "user";
    }
}
