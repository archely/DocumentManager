package com.example.documentmanager.repository.impl;

import com.example.documentmanager.entity.FolderEntity;
import com.example.documentmanager.repository.FolderRepository;
import org.springframework.stereotype.Repository;

//DAO Data Access Object
@Repository
public class FolderRepositoryImpl extends CoreRepositoryImpl<FolderEntity> implements FolderRepository {

    public FolderRepositoryImpl() {
    }


    @Override
    protected Class<FolderEntity> getManagedClass() {
        return FolderEntity.class;
    }
}
