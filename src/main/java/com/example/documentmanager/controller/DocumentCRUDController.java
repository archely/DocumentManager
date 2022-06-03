package com.example.documentmanager.controller;

import com.example.documentmanager.error.EntityNotFoundException;
import com.example.documentmanager.model.DocumentDTO;
import com.example.documentmanager.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DocumentCRUDController {

    @Autowired
    private DocumentService service;

    public DocumentCRUDController() {
    }

    @GetMapping("/api/document")
    public ResponseEntity<List<DocumentDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping("/api/document")
    public ResponseEntity save(@RequestBody DocumentDTO entity) {
        try {
            return ResponseEntity.ok(service.save(entity));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/api/document")
    public ResponseEntity update(@RequestBody DocumentDTO entity) {
        try {
            return ResponseEntity.ok(service.update(entity));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/api/document/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
