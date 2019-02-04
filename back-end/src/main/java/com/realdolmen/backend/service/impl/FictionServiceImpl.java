package com.realdolmen.backend.service.impl;

import com.realdolmen.backend.domain.Fiction;
import com.realdolmen.backend.repository.FictionRepository;
import com.realdolmen.backend.service.FictionService;
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
