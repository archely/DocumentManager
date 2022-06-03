package com.example.documentmanager.service;

import com.example.documentmanager.error.EntityNotFoundException;
import com.example.documentmanager.model.DocumentDTO;

import java.util.List;

public interface DocumentService {
    List<DocumentDTO> findAll();

    DocumentDTO save(DocumentDTO entity) throws EntityNotFoundException;

    DocumentDTO update(DocumentDTO entity) throws EntityNotFoundException;

    void delete(Long id) throws EntityNotFoundException;
}
