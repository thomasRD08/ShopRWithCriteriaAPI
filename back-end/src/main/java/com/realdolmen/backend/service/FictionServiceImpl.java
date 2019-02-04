package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Fiction;
import com.realdolmen.backend.repository.FictionRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FictionServiceImpl extends CrudServiceImpl<Fiction, Long> implements FictionService {
    private final FictionRepository fictionRepository;

    @Override
    protected JpaRepository<Fiction, Long> getRepository() {
        return fictionRepository;
    }
}
