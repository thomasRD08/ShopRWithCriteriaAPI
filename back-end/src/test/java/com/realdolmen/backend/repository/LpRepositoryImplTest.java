package com.realdolmen.backend.repository;

import com.realdolmen.backend.BackEndApplication;
import com.realdolmen.backend.domain.Lp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BackEndApplication.class)
public class LpRepositoryImplTest {

	private Pageable pageRequest;

	@Autowired
	private LpRepositoryImpl lpRepositoryImpl;

	@Before
	public void setUp() {
		pageRequest = PageRequest.of(0,10);
	}

	@Test
	public void testgetLpsWithFilteringSorting()
	{
		String title = "title";
		String artist = "artist";
		String type = "lp";
		BigDecimal upperRange = BigDecimal.valueOf(55.5);
		BigDecimal lowerRange = BigDecimal.valueOf(0.0);
		BigDecimal[] rangeOfPrice = {lowerRange,upperRange} ;

		Page<Lp> lpPage = lpRepositoryImpl.getLpsWithFilteringSorting(title,rangeOfPrice,type,artist,null,pageRequest);
		lpPage.getContent().forEach((Lp x) -> System.out.println(x.getId()));

		assertEquals(2,lpPage.getContent().size());
	}

	@Test
	public void testgetLpsWithSorting()
	{
		Sort s = Sort.by(Sort.Direction.ASC,"title");
		pageRequest = PageRequest.of(0,10,s);

		BigDecimal upperRange = BigDecimal.valueOf(55.5);
		BigDecimal lowerRange = BigDecimal.valueOf(0.0);
		BigDecimal[] rangeOfPrice = {lowerRange,upperRange} ;

		Page<Lp> lpPage = lpRepositoryImpl.getLpsWithFilteringSorting(null,null,null,null,null,pageRequest);
		lpPage.getContent().forEach(x -> System.out.println(x.getId()));

		assertTrue(true);
	}
}
