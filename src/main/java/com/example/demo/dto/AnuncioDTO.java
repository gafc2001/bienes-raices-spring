package com.example.demo.dto;

import com.example.demo.model.Anuncio;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@RequiredArgsConstructor
public class AnuncioDTO {

    private Long id;

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

    private String rutaImage;

    private MultipartFile imagen;

    public Anuncio buildAnuncio(){
        Anuncio anuncio = new Anuncio();
        anuncio.setId(this.id);
        anuncio.setTitle(this.title);
        anuncio.setDescripcionCorta(this.descripcionCorta);
        anuncio.setDescripcionLarga(this.descripcionLarga);
        anuncio.setPrecio(this.precio);
        anuncio.setCantidadBanios(this.cantidadBanios);
        anuncio.setCantidadCochera(this.cantidadCochera);
        anuncio.setCantidadCuartos(this.cantidadCuartos);
        anuncio.setRutaImage(this.rutaImage);
        return anuncio;
    }
    public AnuncioDTO(Anuncio anuncio){
        this.id = anuncio.getId();
        this.title = anuncio.getTitle();
        this.descripcionCorta = anuncio.getDescripcionCorta();
        this.descripcionLarga = anuncio.getDescripcionLarga();
        this.precio = anuncio.getPrecio();
        this.cantidadBanios = anuncio.getCantidadBanios();
        this.cantidadCochera = anuncio.getCantidadCochera();
        this.cantidadCuartos = anuncio.getCantidadCuartos();
        this.rutaImage = anuncio.getRutaImage();
    }
}
