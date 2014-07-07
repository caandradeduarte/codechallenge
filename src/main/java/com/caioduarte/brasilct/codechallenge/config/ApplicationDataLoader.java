package com.caioduarte.brasilct.codechallenge.config;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.caioduarte.brasilct.codechallenge.dao.StationDao;
import com.caioduarte.brasilct.codechallenge.dataloaders.StationLoader;
import com.caioduarte.brasilct.codechallenge.models.Station;

@Component
public class ApplicationDataLoader implements InitializingBean {
	
	static Logger logger = Logger.getGlobal();

	@Autowired
	private StationLoader stationLoader;
	
	@Autowired
	private StationDao stationDao;

	@Override
	public void afterPropertiesSet() throws Exception {
		loadStationData();
	}

	protected void loadStationData() {
		List<Station> stations = stationLoader.load();
		
		stationDao.saveAll(stations);
		
		logger.info("Stations load successfully complete");
	}
	
}
