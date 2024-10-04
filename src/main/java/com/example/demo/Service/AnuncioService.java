package com.example.demo.Service;

import com.example.demo.model.Anuncio;
import com.example.demo.repository.AnuncioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnuncioService {

    @Autowired
    private AnuncioRepository anuncioRepository;
    public List<Anuncio> getAnuncios() {
        return anuncioRepository.findAll();
    }
}
