package com.example.documentmanager.service;

import com.example.documentmanager.error.EntityNotFoundException;
import com.example.documentmanager.model.FolderDTO;

import java.util.List;

public interface FolderService {

    List<FolderDTO> findAll();

    FolderDTO save(FolderDTO dto);

    FolderDTO update(FolderDTO dto) throws EntityNotFoundException;

    void delete(Long id) throws EntityNotFoundException;
}
