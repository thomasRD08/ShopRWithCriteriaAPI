package com.realdolmen.backend.repository;

import com.realdolmen.backend.domain.Lp;
import com.realdolmen.backend.domain.LpGenre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;

public interface LpRepositoryCustom {
	Page<Lp> getLpsWithFilteringSorting(String title, BigDecimal[] price, String type, String artist, List<String> genre, Pageable pageable);
}
