/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dto;

import java.io.Serializable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author jtorr
 */

@Getter
@Setter
@EqualsAndHashCode
public class BlogDTO implements Serializable{
    private String title;
    private String texto;
    private String imagePath;
    private UsuarioDTO usuario; // Incluye solo el username
}
