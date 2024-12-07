/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.dto.UsuarioDTO;
import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jtorr
 */
@Service
public class UsuarioDTOImpl implements UsuarioDTOService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioDTO> getAllUsuariosDTO() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        List<Usuario> usuarios = usuarioRepository.findAll(); // Obtiene todas las entidades
        // Transforma las entidades en DTOs
        return usuarios.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private UsuarioDTO convertToDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setUsername(usuario.getUsername());
        return dto;
    }
    
    // Nuevo método: convertir de UsuarioDTO a Usuario
    public Usuario convertToEntity(UsuarioDTO usuarioDTO) {
        if (usuarioDTO == null || usuarioDTO.getUsername() == null) {
            throw new IllegalArgumentException("El UsuarioDTO o su username no puede ser nulo");
        }

        return usuarioRepository.findByUsername(usuarioDTO.getUsername())
                .orElseThrow(() -> new RuntimeException(
                        "No se encontró un usuario con el username: " + usuarioDTO.getUsername()));
    }

}
