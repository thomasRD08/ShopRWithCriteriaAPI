package com.realdolmen.backend.repository;

import com.realdolmen.backend.domain.Lp;
import com.realdolmen.backend.domain.LpGenre;
import com.realdolmen.backend.domain.Lp_;
import org.hibernate.query.criteria.internal.OrderImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LpRepositoryImpl implements LpRepositoryCustom {
	private static final String LIKE_CHAR = "%";

	private CriteriaBuilder cb;

	@PersistenceContext
	private EntityManager entityManager;

	@PostConstruct
	public void init() {
		cb = entityManager.getCriteriaBuilder();
	}


	private Predicate getLikePredicate(Expression<String> x, String pattern) {
		return cb.like(cb.lower(x), LIKE_CHAR + pattern + LIKE_CHAR);
	}

	private Predicate getEqualsPredicate(Expression<String> x, String pattern) {
		return cb.equal(cb.lower(x), pattern);
	}

	@Override
	public Page<Lp> getLpsWithFilteringSorting(String title, BigDecimal[] price, String type, String artist, List<String> genre, Pageable pageable) {
		CriteriaQuery<Lp> query = cb.createQuery(Lp.class);
		CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);

		final Root<Lp> lp = query.from(Lp.class);
		final List<Predicate> predicates = new ArrayList<>();
		final List<Order> orders = new ArrayList<>();

		if(title != null) {
			System.out.println("title not null");
			predicates.add(getLikePredicate((lp.get(Lp_.title)), title.toLowerCase()));
		}
		if(price != null){
			System.out.println("price is not null	");
			predicates.add(cb.between(lp.get(Lp_.price),price[0],price[1]));}
		if(type != null){
			System.out.println("type not null");
			predicates.add(getEqualsPredicate(cb.lower(lp.get(Lp_.type)), type.toLowerCase()));}
		if(artist != null){
			System.out.println("artist not null");
			predicates.add(getLikePredicate((lp.get(Lp_.artist)), artist.toLowerCase()));}
			//implement later
		/*if(genre != null)
			predicates.add(cb.in()));*/
		query.select(lp).where(predicates.toArray(new Predicate[predicates.size()]));
		countQuery.select(cb.count(countQuery.from(Lp.class)));
		countQuery.where(predicates.toArray(new Predicate[predicates.size()]));

		if (pageable != null && pageable.getSort() != null) {
			System.out.println("pageable not null and has sort");
			System.out.println(pageable.getSort().toString());
			for (Sort.Order order : pageable.getSort()) {
				Order ord = null;
				boolean isAscending = order.getDirection().isAscending();

				switch (order.getProperty()) {
					case "title":
					case "type":
					case "artist":
					case "sector":
					case "price":
						ord = new OrderImpl(lp.get(order.getProperty()), isAscending);
						break;
					default:
						continue;
				}

				orders.add((ord));
			}
			query.orderBy(orders);
		}
		else
			System.out.println("pageable or sort is null");

		TypedQuery<Lp> typedQuery = entityManager.createQuery(query);
		typedQuery.setMaxResults(pageable.getPageSize());
		typedQuery.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());

		List<Lp> result = typedQuery.getResultList();
		int count = entityManager.createQuery(countQuery).getSingleResult().intValue();

		return new PageImpl<>(result, pageable, count);

	}
}
