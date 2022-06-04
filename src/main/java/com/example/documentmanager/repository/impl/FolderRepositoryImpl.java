package com.example.documentmanager.repository.impl;

import com.example.documentmanager.entity.FolderEntity;
import com.example.documentmanager.repository.FolderRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;

//DAO Data Access Object or Repository
@Repository
public class FolderRepositoryImpl extends CoreRepositoryImpl<FolderEntity> implements FolderRepository {

    public FolderRepositoryImpl() {
    }


    @Override
    public Long countFolderForDocument(Long documentId) {
        TypedQuery<Long> query = entityManager.createQuery(" select count(n) from DocumentEntity n where n.document.id=:documentId ", Long.class);
        query.setParameter("documentId", documentId);
        return query.getSingleResult();
    }




    @Override
    protected Class<FolderEntity> getManagedClass() {
        return FolderEntity.class;
    }
}
