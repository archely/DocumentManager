package com.example.documentmanager.repository.impl;

import com.example.documentmanager.repository.DocumentRepository;
import com.example.documentmanager.entity.DocumentEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;

//DAO Data Access Object or Repository
@Repository
public class DocumentRepositoryImpl extends CoreRepositoryImpl<DocumentEntity> implements DocumentRepository {

    public DocumentRepositoryImpl() {

    }

    @Override
    protected Class<DocumentEntity> getManagedClass() {
        return DocumentEntity.class;
    }

    @Override
    public Long countDocumentForFolder(Long folderId) {
        TypedQuery<Long> query = entityManager.createQuery(" select count(n) from DocumentEntity n where n.folder.id=:folderId ", Long.class);
        query.setParameter("folderId", folderId);
        return query.getSingleResult();
    }
}
