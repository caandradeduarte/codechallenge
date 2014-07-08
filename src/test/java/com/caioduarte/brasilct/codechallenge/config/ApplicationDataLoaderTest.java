package com.caioduarte.brasilct.codechallenge.config;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.caioduarte.brasilct.codechallenge.dao.LineDao;
import com.caioduarte.brasilct.codechallenge.dao.RouteDao;
import com.caioduarte.brasilct.codechallenge.dao.StationDao;
import com.caioduarte.brasilct.codechallenge.dataloaders.LineLoader;
import com.caioduarte.brasilct.codechallenge.dataloaders.RouteLoader;
import com.caioduarte.brasilct.codechallenge.dataloaders.StationLoader;
import com.caioduarte.brasilct.codechallenge.models.Line;
import com.caioduarte.brasilct.codechallenge.models.Route;
import com.caioduarte.brasilct.codechallenge.models.Station;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationDataLoaderTest {

	@Mock
	private StationLoader stationLoader;
	
	@Mock
	private StationDao stationDao;

	@Mock
	private RouteLoader routeLoader;
	
	@Mock
	private RouteDao routeDao;
	
	@Mock
	private LineLoader lineLoader;
	
	@Mock
	private LineDao lineDao;
	
	@InjectMocks
	private ApplicationDataLoader loader = new ApplicationDataLoader();
	
	@Test
	public void must_load_the_stations_and_persist_them() {
		ArrayList<Station> stationsLoaded = new ArrayList<Station>();
		
		when(stationLoader.load()).thenReturn(stationsLoaded);
		
		loader.loadStationData();
		
		verify(stationLoader).load();
		verify(stationDao).saveAll(eq(stationsLoaded));
	}
	
	@Test
	public void must_load_the_routes_and_persist_them() {
		ArrayList<Route> routesLoaded = new ArrayList<Route>();
		
		when(routeLoader.load()).thenReturn(routesLoaded);
		
		loader.loadRouteData();
		
		verify(routeLoader).load();
		verify(routeDao).saveAll(eq(routesLoaded));
	}
	
	@Test
	public void must_load_the_lines_and_persist_them() {
		ArrayList<Line> linesLoaded = new ArrayList<Line>();
		
		when(lineLoader.load()).thenReturn(linesLoaded);
		
		loader.loadLineData();
		
		verify(lineLoader).load();
		verify(lineDao).saveAll(eq(linesLoaded));
	}
	
}
