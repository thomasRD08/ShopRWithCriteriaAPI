package com.realdolmen.backend.repository;

import com.realdolmen.backend.domain.Order;
import com.realdolmen.backend.domain.User;

import java.math.BigDecimal;
import java.util.List;

public interface OrderCustomMethods {

	List<Order> testCriteriaQuery(User user);
	List<Order> findOrdersWhichContainProduct(long productId);
	List<Order> findOrdersWithTotalPriceHigherThen(BigDecimal price);
}
