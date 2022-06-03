package com.example.documentmanager.service.impl;

import com.example.documentmanager.entity.DocumentEntity;
import com.example.documentmanager.model.DocumentDTO;
import com.example.documentmanager.repository.FolderRepository;
import com.example.documentmanager.repository.DocumentRepository;
import com.example.documentmanager.service.DocumentService;
import com.example.documentmanager.service.FolderService;
import com.example.documentmanager.entity.FolderEntity;
import com.example.documentmanager.error.EntityNotFoundException;
import com.example.documentmanager.model.FolderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentRepository repository;


    @Override
    public List<DocumentDTO> findAll() {
        List<DocumentDTO> list = new ArrayList<>();
        List<DocumentEntity> entityList = repository.findAll();
        entityList.forEach(documentEntity -> {
            DocumentDTO dto = new DocumentDTO();
            dto.setId(documentEntity.getId());
            dto.setDescription(documentEntity.getDescription());
            dto.setName(documentEntity.getName());
            documentEntity.setType(dto.getType());
            list.add(dto);
        });
        return list;
    }

    @Override
    public DocumentDTO save(DocumentDTO dto) {
        DocumentEntity documentEntity = new DocumentEntity();
        documentEntity.setDescription(dto.getDescription());
        documentEntity.setName(dto.getName());
        documentEntity.setType(dto.getType());
        repository.save(documentEntity);
        dto.setId(documentEntity.getId());
        return dto;
    }

    @Override
    public DocumentDTO update(DocumentDTO dto) throws EntityNotFoundException {
        DocumentEntity documentEntity = repository.findById(dto.getId());
        documentEntity.setDescription(dto.getDescription());
        documentEntity.setName(dto.getName());
        documentEntity.setType(dto.getType());
        repository.update(documentEntity);
        return dto;
    }

    @Override
    public void delete(Long id) throws EntityNotFoundException {
        repository.delete(id);
    }
}
