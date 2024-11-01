package com.example.demo.dto;

import com.example.demo.model.Anuncio;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AnuncioBodyRequest {

    @NotNull(message = "El title es requerido")
    private String title;

    @NotNull
    private String descripcionCorta;

    @NotNull
    private String descripcionLarga;

    @NotNull
    private Double precio;

    @NotNull
    private Integer cantidadBanios;

    @NotNull
    private Integer cantidadCochera;

    @NotNull
    private Integer cantidadCuartos;

    public Anuncio buildAnuncio(){
        Anuncio anuncio = new Anuncio();
        anuncio.setTitle(this.title);
        anuncio.setDescripcionCorta(this.descripcionCorta);
        anuncio.setDescripcionLarga(this.descripcionLarga);
        anuncio.setPrecio(this.precio);
        anuncio.setCantidadBanios(this.cantidadBanios);
        anuncio.setCantidadCochera(this.cantidadCochera);
        anuncio.setCantidadCuartos(this.cantidadCuartos);
        return anuncio;
    }
}
