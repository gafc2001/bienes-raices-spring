/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller.admin;

import com.example.demo.model.Blog;
import com.example.demo.service.BlogService;
import com.example.demo.service.UsuarioDTOImpl;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author jtorr
 */
@RequestMapping("/admin/blog")
@Controller
public class BlogAdminController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private UsuarioDTOImpl usuarioDTOService;

    @GetMapping({"", "/"})
    public String anuncios(Model model) {

        try {
            List<Blog> listaBlogs = blogService.getBlogs();
            if (listaBlogs == null) {
                throw new IllegalStateException("La lista de blogs es nula");
            }
            model.addAttribute("listaBlogs", listaBlogs);
            return "admin/blog/index";
        } catch (Exception e) {
            // Loguea el error y muestra una página de error personalizada.
            e.printStackTrace();
            return "error/500"; // Asegúrate de tener esta plantilla creada.
        }

    }

    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable Long id) {
        blogService.deleteById(id);
        return "redirect:/admin/blog";
    }

    @PostMapping("/guardar")
    public String saveBlog(@ModelAttribute Blog blog, @RequestParam("image") MultipartFile file) {

        try {
            // Manejo de la imagen
            if (!file.isEmpty()) {
                String fileName = file.getOriginalFilename();
                String uploadDir = "uploads/images";
                Path uploadPath = Paths.get(uploadDir);

                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }

                Path filePath = uploadPath.resolve(fileName);
                Files.write(filePath, file.getBytes());
                blog.setImagePath(uploadDir + "/" + fileName);
            } else {
                blog.setImagePath("default-image.jpg");
            }

            // Guardar el blog con el usuario asignado
            blogService.save(blog);

            return "redirect:/admin/blog";
        } catch (IOException e) {
            e.printStackTrace();
            return "redirect:/admin/blog/error";
        }

    }

    @GetMapping("/crear")
    public String createBlogForm(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("usuarios", usuarioDTOService.getAllUsuariosDTO());
        return "admin/blog/crear";
    }

    // Mostrar formulario de edición
    @GetMapping("/editar/{id}")
    public String editarBlog(@PathVariable("id") Long id, Model model) {
        // Buscar el blog con el id
        Optional<Blog> blog = blogService.findBlogById(id);

        // Verificar si el blog existe
        if (blog != null) {
            model.addAttribute("blog", blog);  // Pasar el objeto blog al formulario
            model.addAttribute("usuarios", usuarioDTOService.getAllUsuariosDTO());
            return "admin/blog/editar";  // Nombre de la vista (editarBlog.html)
        } else {
            // Si no se encuentra el blog, redirigir a la lista de blogs
            return "redirect:/admin/blog";
        }
    }

    @PostMapping("/actualizar")
    public String actualizarBlog(@ModelAttribute Blog blog, @RequestParam("image") MultipartFile file) throws IOException {
//        // Si se ha subido una nueva imagen
//        if (!image.isEmpty()) {
//            // Guarda la imagen en el servidor y obtén la ruta
//            String imagePath = saveImage(image);
//            blog.setImagePath(imagePath);  // Establece la ruta de la nueva imagen
//        }
//
//        // Guarda los cambios del blog en la base de datos
//        blogService.save(blog);

        try {
            // Manejo de la imagen
            if (!file.isEmpty()) {
                String fileName = file.getOriginalFilename();
                String uploadDir = "uploads/images";
                Path uploadPath = Paths.get(uploadDir);

                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }

                Path filePath = uploadPath.resolve(fileName);
                Files.write(filePath, file.getBytes());
                blog.setImagePath(uploadDir + "/" + fileName);
            } else {
                blog.setImagePath("default-image.jpg");
            }

            // Guardar el blog con el usuario asignado
            blogService.save(blog);

            return "redirect:/admin/blog";
        } catch (IOException e) {
            e.printStackTrace();
            return "redirect:/admin/blog/error";
        }
        //return "redirect:/admin/blog";  // Redirige a la lista de blogs
    }

}
