package com.realdolmen.backend.repository;

import com.realdolmen.backend.BackEndApplication;
import com.realdolmen.backend.domain.Lp;
import com.realdolmen.backend.domain.LpGenre;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BackEndApplication.class)
@TestPropertySource(locations="classpath:application-integration-test.properties")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class LpRepositoryImplTestIT {

	private Pageable pageRequest;

	@Autowired
	private LpRepositoryImpl lpRepositoryImpl;

	@Autowired
	private LpRepository lpRepository;

	@Before
	public void setUp() {
		lpRepository.deleteAll();

		pageRequest = PageRequest.of(0,10);
		Lp lp1 = new Lp("title1",BigDecimal.TEN,"lp","artist", LpGenre.HIPHOP);
		Lp lp2 = new Lp("title2",BigDecimal.TEN,"lp","artist", LpGenre.HIPHOP);
		Lp lp3 = new Lp("title3",BigDecimal.valueOf(56L),"lp","artist", LpGenre.HIPHOP);
		Lp lp4 = new Lp("title4",BigDecimal.valueOf(56L),"lp","artist", LpGenre.HIPHOP);
		Lp lp5 = new Lp("title5",BigDecimal.valueOf(56L),"lp","artist", LpGenre.HIPHOP);

		lpRepository.save(lp1);
		lpRepository.save(lp2);
		lpRepository.save(lp3);
		lpRepository.save(lp4);
		lpRepository.save(lp5);

	}

	@Test
	public void testgetLpsWithFilteringSorting()
	{
		String artist = "artist";
		String type = "lp";
		BigDecimal upperRange = BigDecimal.valueOf(55.5);
		BigDecimal lowerRange = BigDecimal.valueOf(0.0);
		BigDecimal[] rangeOfPrice = {lowerRange,upperRange} ;

		Page<Lp> lpPage = lpRepositoryImpl.getLpsWithFilteringSorting(null,rangeOfPrice,type,artist,null,pageRequest);
		lpPage.getContent().forEach((Lp x) -> System.out.println(x.getId()));

		assertEquals(2,lpPage.getContent().size());
	}

	@Test
	public void testgetLpsWithSorting()
	{
		Sort s = Sort.by(Sort.Direction.ASC,"title");
		pageRequest = PageRequest.of(0,10,s);

		Page<Lp> lpPage = lpRepositoryImpl.getLpsWithFilteringSorting(null,null,null,null,null,pageRequest);
		lpPage.getContent().forEach(x -> System.out.println(x.getId()));

		assertEquals(5,lpPage.getContent().size());
		assertEquals("title1", lpPage.getContent().get(0).getTitle());
		assertEquals("title2", lpPage.getContent().get(1).getTitle());
		assertEquals("title3", lpPage.getContent().get(2).getTitle());
		assertEquals("title4", lpPage.getContent().get(3).getTitle());
		assertEquals("title5", lpPage.getContent().get(4).getTitle());

	}
}
