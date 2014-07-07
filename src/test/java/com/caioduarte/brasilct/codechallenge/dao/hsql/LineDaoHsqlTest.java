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

import com.caioduarte.brasilct.codechallenge.dao.LineDao;
import com.caioduarte.brasilct.codechallenge.dao.RouteDao;
import com.caioduarte.brasilct.codechallenge.dao.StationDao;
import com.caioduarte.brasilct.codechallenge.models.Line;
import com.caioduarte.brasilct.codechallenge.models.Route;
import com.caioduarte.brasilct.codechallenge.models.Station;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:daoContextTest.xml")
@Transactional
@TransactionConfiguration(defaultRollback=true)
public class LineDaoHsqlTest {

	@Autowired
	private LineDao dao;
	
	@Autowired
	private RouteDao routeDao;
	
	@Autowired
	private StationDao stationDao;
	
	private Line generateLine(Integer sourceId, Integer targetId, Integer routeLine) {
		return new Line(sourceId, targetId, routeLine);
	}
	
	private void persistAuxRoutes(Route... routes){
		routeDao.saveAll(Arrays.asList(routes));
	}
	
	private void persistAuxStations(Station... stations) {
		stationDao.saveAll(Arrays.asList(stations));
	}

	@Test
	public void must_persist_all_elements_of_list_and_then_return_the_same_nuber_of_elements() {
		Line line1 = generateLine(11, 22, 11);
		Line line2 = generateLine(11, 32, 11);
		
		persistAuxRoutes(line1.getRoute());
		persistAuxStations(line1.getSource());
		persistAuxStations(line1.getTarget());
		persistAuxStations(line2.getTarget());
		
		List<Line> lines = Arrays.asList(line1, line2);
		
		dao.saveAll(lines);
		
		assertEquals(2, dao.list().size());
	}
	
}
