package com.example.demo.controller;

import com.example.demo.Service.AnuncioService;
import com.example.demo.model.Anuncio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class LandingController {

    @Autowired
    private AnuncioService anuncioService;
    @GetMapping
    public String index(){
        return "index";
    }

    @GetMapping("nosotros")
    public String nosotros(){
        return "nosotros";
    }
    @GetMapping("anuncios")
    public String anuncios(Model model){
        List<Anuncio> anuncios = anuncioService.getAnuncios();
        model.addAttribute("anuncios",anuncios);
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
