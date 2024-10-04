package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LandingController {

    @GetMapping
    public String index(){
        return "index";
    }

    @GetMapping("nosotros")
    public String nosotros(){
        return "nosotros";
    }
    @GetMapping("anuncios")
    public String anuncios(){
        return "anuncios";
    }
    @GetMapping("blog")
    public String blog(){
        return "blog";
    }
    @GetMapping("contacto")
    public String contacto(){
        return "contacto";
    }
}
