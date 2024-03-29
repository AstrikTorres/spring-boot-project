package com.gestopago.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gestopago.springboot.service.AddressService;
import com.gestopago.springboot.service.UserService;

@Controller
@RequestMapping(method = RequestMethod.GET)
public class PagesController {

    private AddressService addressService;
    private UserService userService;

    public PagesController(AddressService addressService, UserService userService) {
        super();
        this.addressService = addressService;
        this.userService = userService;
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
                "users",
                userService.getAllUsers());
        return "admin";
    }

    @RequestMapping("/user")
    public String viewUser(Model model) throws Exception {
        model.addAttribute(
                "serverAddress",
                addressService.getServerAddress());
        return "user";
    }

    @RequestMapping("/login")
    public String viewLogin(Model model) throws Exception {
        return "login";
    }

    @RequestMapping("/signup")
    public String viewRegister(Model model) throws Exception {
        return "signup";
    }

    @RequestMapping("/p1")
    public String viewP1(Model model) throws Exception {
        return "pantalla1";
    }

    @RequestMapping("/p2")
    public String viewP2(Model model) throws Exception {
        return "pantalla2";
    }

    @RequestMapping("/p3")
    public String viewP3(Model model) throws Exception {
        return "pantalla3";
    }
}
