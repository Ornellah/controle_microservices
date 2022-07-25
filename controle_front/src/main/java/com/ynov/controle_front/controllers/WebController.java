package com.ynov.controle_front.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
class WebController {
    @GetMapping(path = "/")
    public String home() {
        return "home";
    }

    @GetMapping(path = "/ajoutMessage")
    public String ajoutMessage() {
        return "ajoutMessage";
    }

    @GetMapping(path = "/lookMessage")
    public String lookMessage() {
        return "lookMessage";
    }

    @GetMapping(path = "/users")
    public String customers(Principal principal, Model model) {
        model.addAttribute("username", principal.getName());
        return "user";
    }
}
