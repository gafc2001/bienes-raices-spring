package com.example.demo.controller.api;


import com.example.demo.Service.AnuncioService;
import com.example.demo.dto.AnuncioBodyRequest;
import com.example.demo.model.Anuncio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/anuncios")
public class AnuncioController {

    @Autowired
    private AnuncioService anuncioService;

    @GetMapping
    public List<Anuncio> listarAnuncios(){
        return this.anuncioService.getAnuncios();
    }

    @PostMapping
    public Anuncio crearAnuncio(@RequestBody AnuncioBodyRequest anuncioBodyRequest){
        return this.anuncioService.crearAnuncio(anuncioBodyRequest);
    }

    @PutMapping("/{id}")
    public Anuncio editarAnuncio(@PathVariable Long id,@Valid @RequestBody AnuncioBodyRequest anuncioBodyRequest){
        return this.anuncioService.editarAnuncio(anuncioBodyRequest,id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,String>> eliminarAnuncio(@PathVariable Long id){
        this.anuncioService.eliminarAnuncio(id);
        Map<String, String> response = new HashMap<>();
        response.put("message","Se elimino el anuncio");

        return ResponseEntity.ok().body(response);
    }

}