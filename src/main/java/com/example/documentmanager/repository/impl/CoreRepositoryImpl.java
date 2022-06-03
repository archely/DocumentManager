package com.example.documentmanager.repository.impl;

import com.example.documentmanager.entity.CoreEntity;
import com.example.documentmanager.error.EntityNotFoundException;
import com.example.documentmanager.repository.CoreRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

public abstract class CoreRepositoryImpl<T extends CoreEntity> implements CoreRepository<T> {

    @PersistenceContext
    protected EntityManager entityManager;


    public List<T> findAll() {
        return entityManager.createQuery("select n from " + getManagedClass().getSimpleName() + " n", getManagedClass()).getResultList();
    }

    @Transactional
    @Override
    public T save(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Transactional
    @Override
    public T update(T entity) throws EntityNotFoundException {

        entityManager.merge(entity);
        return entity;
    }

    @Transactional
    @Override
    public void delete(Long id) throws EntityNotFoundException {
        T storedEntity = findById(id);
        entityManager.remove(storedEntity);
    }

    @Override
    public T findById(Long id) throws EntityNotFoundException {

        T entity = entityManager.find(getManagedClass(), id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        return entity;
    }

    protected abstract Class<T> getManagedClass();
}
