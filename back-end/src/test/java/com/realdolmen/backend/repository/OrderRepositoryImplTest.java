package com.realdolmen.backend.repository;


import com.realdolmen.backend.BackEndApplication;
import com.realdolmen.backend.domain.Order;
import com.realdolmen.backend.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = BackEndApplication.class)
public class OrderRepositoryImplTest {
	@Autowired
	private OrderRepositoryImpl orderRepositoryImpl;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private UserRepository userRepository;

	@Test
	public void testFindOrdersByUser()
	{
		Optional<User> u = userRepository.findById(1l);
		if(u.isPresent())
		{
			User user = u.get();
			System.out.println("user " + user.getUsername());
			List<Order> list = orderRepositoryImpl.testCriteriaQuery(u.get());
			assertEquals(3, list.size());
		}
		else
			{
				assertTrue(false);
			}
	}

	@Test
	public void testFindOrdersByUserButUserDoesNotExist()
	{
		Optional<User> u = userRepository.findById(11l);
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
		long id = 6l;
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
//		System.out.println(list.size() + "list size");
	}
}
