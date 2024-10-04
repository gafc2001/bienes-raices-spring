package com.example.demo.controller;

import com.example.demo.model.Contacto;
import com.example.demo.repository.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contacto")
public class ContactoController {

    @Autowired
    private ContactoRepository contactoRepository;

    // Mostrar lista de contactos
    @GetMapping("/list")
    public String listarContactos(Model model) {
        model.addAttribute("contactos", contactoRepository.findAll());
        return "contactos/list";
    }

    // Formulario para nuevo contacto
    @GetMapping("/new")
    public String nuevoContactoForm(Model model) {
        model.addAttribute("contacto", new Contacto());
        return "contactos/form";
    }

    // Guardar contacto
    @PostMapping("/save")
    public String guardarContacto(@ModelAttribute("contacto") Contacto contacto) {
        contactoRepository.save(contacto);
        return "redirect:/contacto/list";
    }

    // Editar contacto
    @GetMapping("/edit/{id}")
    public String editarContacto(@PathVariable("id") Long id, Model model) {
        Contacto contacto = contactoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id no válido: " + id));
        model.addAttribute("contacto", contacto);
        return "contactos/form";
    }

    // Eliminar contacto
    @GetMapping("/delete/{id}")
    public String eliminarContacto(@PathVariable("id") Long id) {
        contactoRepository.deleteById(id);
        return "redirect:/contacto/list";
    }
}