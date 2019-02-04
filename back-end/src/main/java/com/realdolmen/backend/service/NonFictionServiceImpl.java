package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.NonFiction;
import com.realdolmen.backend.repository.NonFictionRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NonFictionServiceImpl extends CrudServiceImpl<NonFiction, Long> implements NonFictionService {
    private final NonFictionRepository nonFictionRepository;

    @Override
    protected JpaRepository<NonFiction, Long> getRepository() {
        return nonFictionRepository;
    }
}
