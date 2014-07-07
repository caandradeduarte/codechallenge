package com.caioduarte.brasilct.codechallenge.dao.hsql;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.caioduarte.brasilct.codechallenge.dao.RouteDao;
import com.caioduarte.brasilct.codechallenge.models.Route;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:daoContextTest.xml")
@Transactional
@TransactionConfiguration(defaultRollback=true)
public class RouteDaoHsqlTest {

	@Autowired
	private RouteDao dao;
	
	private Route generateRoute(int line) {
		return new Route(line, "name", "color");
	}

	@Test
	public void must_persist_all_elements_of_list_and_then_return_the_same_nuber_of_elements() {
		List<Route> routes = Arrays.asList(generateRoute(1), generateRoute(2));
		
		dao.saveAll(routes);
		
		assertEquals(2, dao.list().size());
	}
	
}
