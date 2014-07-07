package com.caioduarte.brasilct.codechallenge.dataloaders.csv;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

import com.caioduarte.brasilct.codechallenge.models.Station;

import au.com.bytecode.opencsv.CSVReader;

public class StationCsvLoaderTest {
	
	private static final String STATIONS_CSV = "stations.csv";
	
	private StationCsvLoader loader = new StationCsvLoader();
	
	CSVReader stationsCsvFile;
	
	@Before
	public void readFile() {
		stationsCsvFile = loader.readFile(STATIONS_CSV);
	}
		
	@Test
	public void must_find_stations_file() {
		assertNotNull(stationsCsvFile);
	}
	
	@Test
	public void must_ignore_first_line() throws IOException {
		assertNotEquals("id", stationsCsvFile.readNext()[0]);
	}
	
	@Test
	public void must_load_the_lines_of_the_file() {
		assertFalse(CollectionUtils.isEmpty(loader.loadLines(stationsCsvFile)));
	}
	
	@Test
	public void must_populate_a_list_of_stations() {
		List<String[]> lines = loader.loadLines(stationsCsvFile);
		List<Station> populatedStations = loader.populateStations(lines);
		assertFalse(CollectionUtils.isEmpty(populatedStations));
		assertNotNull(populatedStations.get(0).getId());
	}

}
