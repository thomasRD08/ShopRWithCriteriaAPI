package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Lp;
import com.realdolmen.backend.repository.LpRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LpServiceImpl extends CrudServiceImpl<Lp, Long> implements LpService {
    private final LpRepository lpRepository;

    @Override
    protected JpaRepository<Lp, Long> getRepository() {
        return lpRepository;
    }
}
