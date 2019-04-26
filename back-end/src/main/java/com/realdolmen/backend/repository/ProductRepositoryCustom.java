package com.realdolmen.backend.repository;

import com.realdolmen.backend.repository.helper.ProductAmount;

import java.util.List;

public interface ProductRepositoryCustom {

	List<ProductAmount> getMostSoldProductsInformation();
}
