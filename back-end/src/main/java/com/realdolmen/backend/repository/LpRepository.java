package com.realdolmen.backend.repository;

import com.realdolmen.backend.domain.Lp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LpRepository extends JpaRepository<Lp, Long> {
}
