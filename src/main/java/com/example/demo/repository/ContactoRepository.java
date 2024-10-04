package com.example.demo.repository;

import com.example.demo.model.Contacto;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Long> {
}
