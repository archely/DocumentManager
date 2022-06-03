package com.example.documentmanager.repository;

import com.example.documentmanager.entity.CoreEntity;
import com.example.documentmanager.error.EntityNotFoundException;

import java.util.List;

public interface CoreRepository<T extends CoreEntity> {

    List<T> findAll();

    T save(T entity);

    T update(T entity) throws EntityNotFoundException;

    void delete(Long id) throws EntityNotFoundException;

    T findById(Long id) throws EntityNotFoundException;
}
