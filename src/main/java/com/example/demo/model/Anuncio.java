package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Data
public class Anuncio {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String title;
    private String descripcionCorta;
    private String descripcionLarga;
    private Double precio;
    private Integer cantidadBanios;
    private Integer cantidadCochera;
    private Integer cantidadCuartos;
    @ManyToOne
    @JoinColumn(
            name="usuario_id",
            referencedColumnName = "id"
    )
    private Usuario createdBy;
    private String rutaImage;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
