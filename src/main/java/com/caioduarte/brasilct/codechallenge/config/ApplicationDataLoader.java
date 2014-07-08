package com.caioduarte.brasilct.codechallenge.config;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.caioduarte.brasilct.codechallenge.dao.LineDao;
import com.caioduarte.brasilct.codechallenge.dao.RouteDao;
import com.caioduarte.brasilct.codechallenge.dao.StationDao;
import com.caioduarte.brasilct.codechallenge.dataloaders.LineLoader;
import com.caioduarte.brasilct.codechallenge.dataloaders.RouteLoader;
import com.caioduarte.brasilct.codechallenge.dataloaders.StationLoader;
import com.caioduarte.brasilct.codechallenge.models.Line;
import com.caioduarte.brasilct.codechallenge.models.Route;
import com.caioduarte.brasilct.codechallenge.models.Station;

@Component
public class ApplicationDataLoader implements InitializingBean {
	
	static Logger logger = Logger.getGlobal();

	@Autowired
	private StationLoader stationLoader;
	
	@Autowired
	private StationDao stationDao;
	
	@Autowired
	private RouteLoader routeLoader;
	
	@Autowired
	private RouteDao routeDao;
	
	@Autowired
	private LineLoader lineLoader;
	
	@Autowired
	private LineDao lineDao;

	@Override
	public void afterPropertiesSet() throws Exception {
		loadStationData();
		
		loadRouteData();
		
		loadLineData();
	}
	
	protected void loadStationData() {
		List<Station> stations = stationLoader.load();
		
		stationDao.saveAll(stations);
		
		logger.info("Stations load successfully complete");
	}

	protected void loadRouteData() {
		List<Route> routes = routeLoader.load();
		
		routeDao.saveAll(routes);
		
		logger.info("Routes load successfully complete");
	}
	
	protected void loadLineData() {
		List<Line> lines = lineLoader.load();
		
		lineDao.saveAll(lines);
		
		logger.info("Lines load successfully complete");
	}
	
}
