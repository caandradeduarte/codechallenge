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

import com.caioduarte.brasilct.codechallenge.dao.StationDao;
import com.caioduarte.brasilct.codechallenge.dataloaders.StationLoader;
import com.caioduarte.brasilct.codechallenge.models.Station;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationDataLoaderTest {

	@Mock
	private StationLoader stationLoader;
	
	@Mock
	private StationDao stationDao;
	
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
	
}
