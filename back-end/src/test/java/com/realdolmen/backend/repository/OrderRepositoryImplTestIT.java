package com.realdolmen.backend.repository;


import com.realdolmen.backend.BackEndApplication;
import com.realdolmen.backend.domain.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BackEndApplication.class)
@TestPropertySource(locations="classpath:application-integration-test.properties")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class OrderRepositoryImplTestIT {
	@Autowired
	private OrderRepositoryImpl orderRepositoryImpl;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private UserRepository userRepository;

	private Long id;


	@Before
	public void setUp()
	{
		orderRepository.deleteAll();
		userRepository.deleteAll();
		productRepository.deleteAll();

		User user = new User("user1");
		userRepository.save(user);

		Order order1 = new Order();
		order1.setTimeStamp(new Date());
		order1.setUser(user);

		Order order2 = new Order();
		order2.setTimeStamp(new Date());
		order2.setUser(user);

		Lp lp = new Lp("lp1",BigDecimal.valueOf(50L),"Lp","artist1",LpGenre.HIPHOP);
		Game g = new Game("game1",BigDecimal.valueOf(63L),"Game","publisher1",GameMinAge.EIGHTEEN,GameGenre.RTS);
		Fiction b = new Fiction("fictionTitle1",BigDecimal.valueOf(35L),"Fiction","author2","9789027439642","356",FictionGenre.SCIFI,"very good book");
		Lp lp2 = new Lp("lp2",BigDecimal.valueOf(50L),"Lp","artist2",LpGenre.HIPHOP);
		productRepository.save(lp);
		productRepository.save(g);
		productRepository.save(b);
		productRepository.save(lp2);

		System.out.println("lp2 id = " + lp2.getId());

		id = lp2.getId();

		List<OrderLine> orderlines = new ArrayList<>();
		OrderLine orderline1 = new OrderLine(5,lp);
		OrderLine orderline2 = new OrderLine(1,g);
		OrderLine orderline3 = new OrderLine(3,b);
		orderlines.add(orderline1);
		orderlines.add(orderline2);
		orderlines.add(orderline3);

		order1.setOrderLines(orderlines);


		orderRepository.save(order1);
		orderlines= new ArrayList<>();
		OrderLine orderline4 = new OrderLine(1,lp);
		OrderLine orderline5 = new OrderLine(1,g);
		OrderLine orderline6 = new OrderLine(4,b);
		OrderLine orderline7 = new OrderLine(1,lp2);
		orderlines.add(orderline4);
		orderlines.add(orderline5);
		orderlines.add(orderline6);
		orderlines.add(orderline7);
		order2.setOrderLines(orderlines);
		orderRepository.save(order2);
	}

	@Test
	public void testFindOrdersByUser()
	{
		Optional<User> u = userRepository.findByUsername("user1");
		if(u.isPresent())
		{
			User user = u.get();
			List<Order> list = orderRepositoryImpl.testCriteriaQuery(u.get());
			assertEquals(2, list.size());
		}
		else
			{
				assertTrue(false);
			}
	}

	@Test
	public void testFindOrdersByUserButUserDoesNotExist()
	{
		Optional<User> u = userRepository.findByUsername("doesNotExist");
		if(u.isPresent())
		{
			User user = u.get();
			System.out.println("user " + user.getUsername());
			List<Order> list = orderRepositoryImpl.testCriteriaQuery(u.get());
			assertEquals(1, list.size());
		}
		else
		{
			assertTrue(true);
		}
	}

	@Test
	public void testFindOrdersWhichContainProductWithOneResult()
	{
		List<Order> list = orderRepositoryImpl.findOrdersWhichContainProduct(id);
		assertEquals(1,list.size());
	}

	@Test
	public void testFindOrdersWhichContainProductWithNoResult()
	{
		long id = 7l;
		List<Order> list = orderRepositoryImpl.findOrdersWhichContainProduct(id);
		assertEquals(0,list.size());
	}

	@Test
	public void testFindOrdersWithTotalPriceHigherThen()
	{
		BigDecimal price = BigDecimal.valueOf(1.0);
		List<Order> list = orderRepositoryImpl.findOrdersWithTotalPriceHigherThen(price);

		System.out.println(list.size() + "list size");
		assertEquals(2,list.size());
	}
}
