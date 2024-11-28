package com.example.demo.controller.admin;

import com.example.demo.model.Anuncio;
import com.example.demo.service.AnuncioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/admin/anuncios")
@Controller
public class AnuncioAdminController {

    @Autowired
    private AnuncioService anuncioService;

    @GetMapping({"","/"})
    public String anuncios(Model model){
        List<Anuncio> anuncios = anuncioService.getAnuncios();
        model.addAttribute("anuncios",anuncios);
        return "admin/anuncios/index";
    }

    @GetMapping("editar/{id}")
    public String editar(Model model, @PathVariable("id") Long id){
        Anuncio anuncio = anuncioService.obtenerAnuncioPorId(id);
        model.addAttribute("anuncio",anuncio);
        return "admin/anuncios/editar";
    }
    @PutMapping("editar/{id}")
    public String actualizar(){
        
    }
}
