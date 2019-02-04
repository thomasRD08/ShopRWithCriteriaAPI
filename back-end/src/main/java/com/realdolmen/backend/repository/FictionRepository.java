package com.realdolmen.backend.repository;

import com.realdolmen.backend.domain.Fiction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FictionRepository extends JpaRepository<Fiction, Long> {
}
