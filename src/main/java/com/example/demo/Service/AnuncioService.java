package com.example.demo.Service;

import com.example.demo.dto.AnuncioBodyRequest;
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

    public Anuncio crearAnuncio(AnuncioBodyRequest anuncioBodyRequest){
        Anuncio anuncio = anuncioBodyRequest.buildAnuncio();
        return anuncioRepository.save(anuncio);
    }
    public Anuncio editarAnuncio(AnuncioBodyRequest anuncioBodyRequest,Long id){
        Anuncio anuncio = anuncioRepository.findById(id).get();
        anuncio.setTitle(anuncioBodyRequest.getTitle());
        anuncio.setDescripcionCorta(anuncioBodyRequest.getDescripcionCorta());
        anuncio.setDescripcionLarga(anuncioBodyRequest.getDescripcionLarga());
        anuncio.setPrecio(anuncioBodyRequest.getPrecio());
        anuncio.setCantidadBanios(anuncioBodyRequest.getCantidadBanios());
        anuncio.setCantidadCochera(anuncioBodyRequest.getCantidadCochera());
        anuncio.setCantidadCuartos(anuncioBodyRequest.getCantidadCuartos());
        return  anuncioRepository.save(anuncio);
    }

    public void eliminarAnuncio(Long id){
        anuncioRepository.deleteById(id);
    }
}
