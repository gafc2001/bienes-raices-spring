package com.example.demo.controller.admin;

import com.example.demo.dto.AnuncioDTO;
import com.example.demo.model.Anuncio;
import com.example.demo.service.AnuncioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;
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

    @GetMapping("/{id}")
    public String editar(Model model, @PathVariable("id") Long id){
        Anuncio anuncio = anuncioService.obtenerAnuncioPorId(id);
        AnuncioDTO anuncioDTO = new AnuncioDTO(anuncio);
        model.addAttribute("anuncio",anuncioDTO);
        return "admin/anuncios/editar";
    }
    @PostMapping("/editar/{id}")
    public String actualizar(
            @ModelAttribute("anuncio") AnuncioDTO anuncioDTO,
            Model model,
            @PathVariable("id") Long id,
            @RequestParam("imagenFile") MultipartFile file
    ){


        try{
            String carpeta = "src/main/resources/static/img/";
            Path uploadPath = Paths.get(carpeta);
            if(!Files.exists(uploadPath)){
                Files.createDirectories(uploadPath);
            }
            if(!file.isEmpty()){
                String hashName = generateFileHash(file);
                Path path = Paths.get(carpeta + hashName);
                Files.write(path, file.getBytes());
                String filePath = "/img/" + hashName;
                anuncioDTO.setRutaImage(filePath);
            }


            this.anuncioService.editarAnuncio(anuncioDTO, anuncioDTO.getId());

            model.addAttribute("success","El anuncio se guardo de manera correcta");
            return "redirect:/admin/anuncios?success="+"El anuncio se guardo";
        }catch (Exception e){
            model.addAttribute("error","Error al guardar el anuncio:" + e.getMessage());
            System.out.println(e.getMessage());
            return "redirect:/admin/anuncios/" + id;
        }

    }
    private String generateFileHash(MultipartFile file) throws NoSuchAlgorithmException, IOException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(file.getBytes());
        return HexFormat.of().formatHex(hashBytes) + getFileExtension(file.getOriginalFilename());
    }

    private String getFileExtension(String filename) {
        int lastIndexOfDot = filename.lastIndexOf(".");
        return lastIndexOfDot != -1 ? filename.substring(lastIndexOfDot) : "";
    }
}
