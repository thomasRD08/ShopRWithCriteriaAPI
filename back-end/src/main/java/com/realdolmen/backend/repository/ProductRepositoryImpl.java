package com.realdolmen.backend.repository;

import com.realdolmen.backend.domain.*;
import com.realdolmen.backend.domain.Order;
import com.realdolmen.backend.repository.helper.ProductAmount;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;


@Repository
public class ProductRepositoryImpl  implements ProductRepositoryCustom{

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<ProductAmount> getMostSoldProductsInformation() {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<ProductAmount> cq = cb.createQuery(ProductAmount.class);
		Root<Order> orderRoot = cq.from(Order.class);
		Path<OrderLine> orderLinePath = orderRoot.join(Order_.ORDER_LINES);
		Path<Product> productPath = orderLinePath.get(OrderLine_.PRODUCT);
		cq.multiselect(productPath,cb.sum(orderLinePath.get(OrderLine_.AMOUNT))).groupBy(productPath.get(Product_.ID));

		TypedQuery<ProductAmount> query = em.createQuery(cq);
		List<ProductAmount> results = query.getResultList();
		results.forEach(x-> {
			System.out.println(x.getAmount() + " amount");
			System.out.println(x.getProduct().getId() + "productId");
		});

		return results;
	}
}
