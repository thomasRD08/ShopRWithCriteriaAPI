package com.realdolmen.backend.repository;

import com.realdolmen.backend.domain.NonFiction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NonFictionRepository extends JpaRepository<NonFiction, Long> {
}
