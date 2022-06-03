package com.example.documentmanager.service.impl;

import com.example.documentmanager.entity.FolderEntity;
import com.example.documentmanager.model.FolderDTO;
import com.example.documentmanager.repository.FolderRepository;
import com.example.documentmanager.repository.DocumentRepository;
import com.example.documentmanager.entity.DocumentEntity;
import com.example.documentmanager.error.EntityNotFoundException;
import com.example.documentmanager.model.DocumentDTO;
import com.example.documentmanager.service.DocumentService;
import com.example.documentmanager.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FolderServiceImpl implements FolderService {

    @Autowired
    private FolderRepository repository;



    @Override
    public List<FolderDTO> findAll() {
        List<FolderDTO> list = new ArrayList<>();
        List<FolderEntity> entityList = repository.findAll();
        entityList.forEach(entity -> {
            FolderDTO dto = new FolderDTO();
            dto.setId(entity.getId());
            dto.setDescription(entity.getDescription());
            dto.setName(entity.getName());
            dto.setColor(entity.getColor());
            if (entity.getFolder() != null) {
                dto.setDocumentId(entity.getFolder().getId());
            }
            list.add(dto);
        });
        return list;
    }

    @Override
    public FolderDTO save(FolderDTO dto)  {
        FolderEntity entity = new FolderEntity();
        entity.setDescription(dto.getDescription());
        entity.setName(dto.getName());
        entity.setColor(dto.getColor());
        repository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    @Override
    public FolderDTO update(FolderDTO dto) throws EntityNotFoundException {
        FolderEntity entity = repository.findById(dto.getId());
        entity.setDescription(dto.getDescription());
        entity.setName(dto.getName());
        entity.setColor(dto.getColor());
        repository.update(entity);
        return dto;
    }

    @Override
    public void delete(Long id) throws EntityNotFoundException {
        repository.delete(id);
    }
}
