package com.example.demo.controller;

import com.example.demo.service.AnuncioService;
import com.example.demo.service.BlogService;
import com.example.demo.model.Anuncio;
import com.example.demo.model.Blog;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LandingController {

    @Autowired
    private AnuncioService anuncioService;

    @Autowired
    private BlogService blogService;
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
    public String blog(Model model){
        List<Blog> blogs = blogService.getBlogs();
        model.addAttribute("blogs",blogs);
        return "blog";
    }
    @GetMapping("contacto")
    public String contacto(){
        return "contacto";
    }




}
