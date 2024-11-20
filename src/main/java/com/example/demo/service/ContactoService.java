package com.example.demo.service;

import com.example.demo.model.Contacto;
import com.example.demo.repository.ContactoRepository;  // Importación necesaria
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactoService {

    @Autowired
    private ContactoRepository contactoRepository;

    public List<Contacto> getAllContactos() {
        return contactoRepository.findAll();
    }

    public ResponseEntity<Contacto> getContactoById(Long id) {
        Contacto contacto = contactoRepository.findById(id).orElse(null);
        if (contacto != null) {
            return ResponseEntity.ok(contacto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Contacto> createContacto(Contacto contacto) {
        Contacto newContacto = contactoRepository.save(contacto);
        return ResponseEntity.ok(newContacto);
    }

    public ResponseEntity<Contacto> updateContacto(Long id, Contacto contacto) {
        if (contactoRepository.existsById(id)) {
            contacto.setId(id);
            Contacto updatedContacto = contactoRepository.save(contacto);
            return ResponseEntity.ok(updatedContacto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Void> deleteContacto(Long id) {
        if (contactoRepository.existsById(id)) {
            contactoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
