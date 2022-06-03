package com.example.documentmanager.repository;

import com.example.documentmanager.entity.DocumentEntity;

public interface DocumentRepository extends CoreRepository<DocumentEntity> {

    Long countTasksForProject(Long projectId);
}
