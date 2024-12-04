package com.example.demo.service;

import com.example.demo.dto.AnuncioDTO;
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

    public Anuncio obtenerAnuncioPorId(Long id){
        return anuncioRepository.findById(id).get();
    }
    public Anuncio crearAnuncio(AnuncioDTO anuncioBodyRequest){
        Anuncio anuncio = anuncioBodyRequest.buildAnuncio();
        return anuncioRepository.save(anuncio);
    }
    public Anuncio editarAnuncio(AnuncioDTO anuncioBodyRequest,Long id){
        Anuncio anuncio = anuncioRepository.findById(id).get();
        anuncio.setTitle(anuncioBodyRequest.getTitle());
        anuncio.setDescripcionCorta(anuncioBodyRequest.getDescripcionCorta());
        anuncio.setDescripcionLarga(anuncioBodyRequest.getDescripcionLarga());
        anuncio.setPrecio(anuncioBodyRequest.getPrecio());
        anuncio.setCantidadBanios(anuncioBodyRequest.getCantidadBanios());
        anuncio.setCantidadCochera(anuncioBodyRequest.getCantidadCochera());
        anuncio.setCantidadCuartos(anuncioBodyRequest.getCantidadCuartos());
        anuncio.setRutaImage(anuncioBodyRequest.getRutaImage());
        return  anuncioRepository.save(anuncio);
    }

    public void eliminarAnuncio(Long id){
        anuncioRepository.deleteById(id);
    }
}
