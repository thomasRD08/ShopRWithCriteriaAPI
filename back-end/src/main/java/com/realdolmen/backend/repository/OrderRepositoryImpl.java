package com.realdolmen.backend.repository;

import com.realdolmen.backend.domain.*;
import com.realdolmen.backend.domain.Order;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderCustomMethods {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Order> testCriteriaQuery(User user) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Order> cq = cb.createQuery(Order.class);
		Root<Order> order = cq.from(Order.class);
		cq.select(order);
		Predicate isUser = cb.equal(order.get(Order_.USER),user);
		cq.where(isUser);
		TypedQuery<Order> query = em.createQuery(cq);
		List<Order> results = query.getResultList();
		return results;
	}

	@Override
	public List<Order> findOrdersWhichContainProduct(long productId) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Order> cq = cb.createQuery(Order.class);
		Root<Order> orderRoot = cq.from(Order.class);
		Path<OrderLine> orderLinePath = orderRoot.join(Order_.ORDER_LINES);
		Path<Product> productPath = orderLinePath.get(OrderLine_.PRODUCT);
		cq.select(orderRoot);
		Predicate isUser = cb.equal(productPath.get(Product_.ID),productId);
		cq.where(isUser);
		TypedQuery<Order> query = em.createQuery(cq);
		List<Order> results = query.getResultList();
		return results;
	}

	@Override
	public List<Order> findOrdersWithTotalPriceHigherThen(BigDecimal price) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Order> cq = cb.createQuery(Order.class);
		Root<Order> orderRoot = cq.from(Order.class);
		Join<Order, OrderLine> orderLineJoin = orderRoot.join(Order_.ORDER_LINES);
		Join<OrderLine, Product> productJoin = orderLineJoin.join(OrderLine_.PRODUCT);

		cq.multiselect(orderRoot);

		cq.groupBy(orderRoot);
		cq.having(cb.ge(cb.sum(cb.prod(orderLineJoin.get(OrderLine_.AMOUNT),productJoin.get(Product_.PRICE))),price));

		TypedQuery<Order> query = em.createQuery(cq);
		List<Order> list = new ArrayList<>();
		query.getResultList().forEach(x ->{ System.out.println(x.getId()); list.add((Order)x);});

		return list;
	}
}
