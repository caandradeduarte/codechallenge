package com.caioduarte.brasilct.codechallenge.dao.hsql;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.caioduarte.brasilct.codechallenge.dao.StationDao;
import com.caioduarte.brasilct.codechallenge.models.Station;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:daoContextTest.xml")
@Transactional
@TransactionConfiguration(defaultRollback=true)
public class StationDaoHsqlTest {

	@Autowired
	private StationDao dao;

	private Station generateStation(int id) {
		return new Station.Builder().id(id).name("Nome")
				.coordinates(BigDecimal.ONE, BigDecimal.ONE)
				.zone(BigDecimal.ONE).totalLines(1).rail(1).build();
	}

	@Test
	public void must_persist_all_elements_of_list_and_then_return_the_same_nuber_of_elements() {
		List<Station> stations = Arrays.asList(generateStation(1), generateStation(2));
		
		dao.saveAll(stations);
		
		assertEquals(2, dao.list().size());
	}

}
