package com.realdolmen.backend.service;

import java.util.List;

public interface CrudService<E, PK> {
    E save(E entity);
    E findById(PK primaryKey);
    List<E> findAll();
    void delete(E entity);
}
