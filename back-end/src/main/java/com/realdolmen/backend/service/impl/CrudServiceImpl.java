package com.realdolmen.backend.service.impl;

import com.realdolmen.backend.advice.exception.NotFoundException;
import com.realdolmen.backend.service.CrudService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class CrudServiceImpl<T, PK> implements CrudService<T, PK> {
    private final Class<T> entityClass;

    @SuppressWarnings("unchecked")
    public CrudServiceImpl() {
        entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    abstract protected JpaRepository<T, PK> getRepository();

    @Override
    public T save(T entity) {
        return getRepository().save(entity);
    }

    @Override
    public T findById(PK primaryKey) {
        return getRepository().findById(primaryKey)
                .orElseThrow(() -> new NotFoundException("Primary key not found for " + entityClass.getSimpleName() + ": " + primaryKey));
    }

    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    public void delete(T entity) {
        getRepository().delete(entity);
    }
}
