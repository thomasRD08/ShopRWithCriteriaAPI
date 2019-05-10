package com.realdolmen.backend.repository;

import com.realdolmen.backend.BackEndApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BackEndApplication.class)
@TestPropertySource(locations="classpath:application-integration-test.properties")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductRepositoryImplTestIT {

	@Autowired
	private ProductRepositoryImpl productRepositoryImpl;

	@Test
	public void testGetMostSoldProductsInformation()
	{
		productRepositoryImpl.getMostSoldProductsInformation();
	}
}
