package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Contacto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombres;
    private String email;
    private String telefono;
    private String mensaje;
    private String accion;
    private Double presupuesto;

    @Column(name = "type_contact")
    private String typeContact;

    @Column(name = "date_contact")
    private LocalDate dateContact;  // Cambiado a LocalDate para manejar fechas correctamente

    private Timestamp timeContact;

    @CreatedDate
    private Timestamp createdAt;

    @LastModifiedDate
    private Timestamp updatedAt;
}
