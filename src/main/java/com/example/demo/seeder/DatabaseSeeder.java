package com.example.demo.seeder;

import com.example.demo.model.Anuncio;
import com.example.demo.repository.AnuncioRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Configuration
@RequiredArgsConstructor
public class DatabaseSeeder implements ApplicationRunner {
    private final AnuncioRepository anuncioRepository;

    private static final Logger log = LoggerFactory.getLogger(DatabaseSeeder.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if(args.getOptionValues("seeder") != null){
            List<String> seeder = Arrays.asList(args.getOptionValues("seeder").get(0).split(","));
            if(seeder.contains("anuncio")) {
                seedAnuncios();
                log.info("Success run anuncio seeder");
            }
        }else{
            log.info("anuncio seeder skipped");
        }
    }

    private void seedAnuncios(){
        List<Anuncio> anuncios = new ArrayList<Anuncio>();

        Anuncio a1 = new Anuncio();
        a1.setTitle("Casa de Lujo en el Lago");
        a1.setDescripcionCorta("Casa en el lago con excelente vista,acabados de lujo a un excenlente precio");
        a1.setDescripcionLarga("Casa en el lago con excelente vista,acabados de lujo a un excenlente precio");
        a1.setCantidadBanios(3);
        a1.setCantidadCochera(3);
        a1.setCantidadCuartos(3);
        a1.setPrecio(3000000.0);
        a1.setRutaImage("/img/anuncio1.jpg");

        Anuncio a2 = new Anuncio();
        a2.setTitle("Casa terminado de Lujo");
        a2.setDescripcionCorta("Casa con diseño moderno, asi como tecnología inteliginte y amueblada");
        a2.setDescripcionLarga("Casa con diseño moderno, asi como tecnología inteliginte y amueblada");
        a2.setCantidadBanios(3);
        a2.setCantidadCochera(3);
        a2.setCantidadCuartos(3);
        a2.setPrecio(3000000.0);
        a2.setRutaImage("/img/anuncio2.jpg");

        Anuncio a3 = new Anuncio();
        a3.setTitle("Casa con Alberca");
        a3.setDescripcionCorta("Casa con alberca y acabados de Lujo en la ciudad,excelente oportunidad");
        a3.setDescripcionLarga("Casa con alberca y acabados de Lujo en la ciudad,excelente oportunidad");
        a3.setCantidadBanios(3);
        a3.setCantidadCochera(3);
        a3.setCantidadCuartos(3);
        a3.setPrecio(3000000.0);
        a3.setRutaImage("/img/anuncio3.jpg");

        Anuncio a4 = new Anuncio();
        a4.setTitle("Casa de Lujo en el Lago");
        a4.setDescripcionCorta("Casa en el lago con excelente vista,acabados de lujo a un excenlente precio");
        a4.setDescripcionLarga("Casa en el lago con excelente vista,acabados de lujo a un excenlente precio");
        a4.setCantidadBanios(3);
        a4.setCantidadCochera(3);
        a4.setCantidadCuartos(3);
        a4.setPrecio(3000000.0);
        a4.setRutaImage("/img/anuncio1.jpg");

        Anuncio a5 = new Anuncio();
        a5.setTitle("Casa terminado de Lujo");
        a5.setDescripcionCorta("Casa con diseño moderno, asi como tecnología inteliginte y amueblada");
        a5.setDescripcionLarga("Casa con diseño moderno, asi como tecnología inteliginte y amueblada");
        a5.setCantidadBanios(3);
        a5.setCantidadCochera(3);
        a5.setCantidadCuartos(3);
        a5.setPrecio(3000000.0);
        a5.setRutaImage("/img/anuncio2.jpg");

        Anuncio a6 = new Anuncio();
        a6.setTitle("Casa con Alberca");
        a6.setDescripcionCorta("Casa con alberca y acabados de Lujo en la ciudad,excelente oportunidad");
        a6.setDescripcionLarga("Casa con alberca y acabados de Lujo en la ciudad,excelente oportunidad");
        a6.setCantidadBanios(3);
        a6.setCantidadCochera(3);
        a6.setCantidadCuartos(3);
        a6.setPrecio(3000000.0);
        a6.setRutaImage("/img/anuncio3.jpg");

        anuncios.add(a1);
        anuncios.add(a2);
        anuncios.add(a3);
        anuncios.add(a4);
        anuncios.add(a5);
        anuncios.add(a6);

        var index = 0;
        for (var anuncio : anuncios ) {

            this.anuncioRepository.save(anuncio);

            log.info("Success run Anuncio Seeder {}",index);

            index++;
        }
    }
}
