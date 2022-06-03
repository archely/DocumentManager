package com.example.documentmanager.repository.impl;

import com.example.documentmanager.entity.FolderEntity;
import com.example.documentmanager.repository.FolderRepository;
import org.springframework.stereotype.Repository;

//DAO Data Access Object or Repository
@Repository
public class FolderRepositoryImpl extends CoreRepositoryImpl<FolderEntity> implements FolderRepository {

    public FolderRepositoryImpl() {
    }


    /*
    This is the not generic way, maybe more readable

    public List<ProjectEntity> findAll() {
        return entityManager.createQuery("select n from ProjectEntity n", ProjectEntity.class).getResultList();
    }
    */

    /*
    This is the not generic way, maybe more readable

    private ProjectEntity findById(Long id) throws EntityNotFoundException {

        ProjectEntity entity = entityManager.find(ProjectEntity.class, id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        return entity;
    }
    */

    @Override
    protected Class<FolderEntity> getManagedClass() {
        return FolderEntity.class;
    }
}
