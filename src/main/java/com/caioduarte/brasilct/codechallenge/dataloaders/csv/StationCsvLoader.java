package com.caioduarte.brasilct.codechallenge.dataloaders.csv;

import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import au.com.bytecode.opencsv.CSVReader;

import com.caioduarte.brasilct.codechallenge.dataloaders.StationLoader;
import com.caioduarte.brasilct.codechallenge.models.Station;

@Repository
public class StationCsvLoader implements StationLoader {

	@Override
	public List<Station> load() {
		CSVReader reader = readFile("stations.csv");
		
		List<String[]> lines = loadLines(reader);
		
		return populateStations(lines);
	}

	protected List<Station> populateStations(List<String[]> lines) {
		ArrayList<Station> stations = new ArrayList<Station>(lines.size());
		Station station;
		for(String[] line : lines) {
			station = new Station.Builder()
				.id(Integer.valueOf(line[0]))
				.name(line[3])
				.coordinates(new BigDecimal(line[1]), new BigDecimal(line[2]))
				.zone(new BigDecimal(line[5]))
				.totalLines(Integer.valueOf(line[6]))
				.rail(Integer.valueOf(line[7]))
				.displayName(line[4])
				.build();
			
			stations.add(station);
		}
		return stations;
	}

	protected List<String[]> loadLines(CSVReader reader) {
		try {
			return reader.readAll();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	protected CSVReader readFile(String fileName) {
		InputStreamReader reader = new InputStreamReader(this.getClass().getResourceAsStream("/data/" + fileName));
		return new CSVReader(reader, ',', '"', 1);
	}

}
