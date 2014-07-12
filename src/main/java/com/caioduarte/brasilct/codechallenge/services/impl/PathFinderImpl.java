package com.caioduarte.brasilct.codechallenge.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caioduarte.brasilct.codechallenge.dao.LineDao;
import com.caioduarte.brasilct.codechallenge.dao.RouteDao;
import com.caioduarte.brasilct.codechallenge.dao.StationDao;
import com.caioduarte.brasilct.codechallenge.models.Path;
import com.caioduarte.brasilct.codechallenge.models.Station;
import com.caioduarte.brasilct.codechallenge.services.PathFinder;

@Service
public class PathFinderImpl implements PathFinder {
	
	@Autowired
	private StationDao stationDao;
	
	@Autowired
	private RouteDao routeDao;
	
	@Autowired
	private LineDao lineDao;

	@Override
	public Path anyPath(Station source, Station target) {
		return new Path(stationDao.list(), routeDao.list(), lineDao.list(), source.getId(), target.getId(), false);
	}

	@Override
	public Path shortestPath(Station source, Station target) {
		return new Path(stationDao.list(), routeDao.list(), lineDao.list(), source.getId(), target.getId(), true);
	}

}
