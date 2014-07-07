package com.caioduarte.brasilct.codechallenge.dataloaders.csv;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import au.com.bytecode.opencsv.CSVReader;

import com.caioduarte.brasilct.codechallenge.dataloaders.StationLoader;
import com.caioduarte.brasilct.codechallenge.models.Station;

@Repository
public class StationCsvLoader extends CsvLoader<Station> implements StationLoader {

	protected static final String STATIONS_CSV = "stations.csv";
	
	@Override
	@Transactional
	public List<Station> load() {
		CSVReader reader = readFile(STATIONS_CSV);
		
		List<String[]> lines = loadLines(reader);
		
		return populate(lines);
	}

	@Override
	protected List<Station> populate(List<String[]> lines) {
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

}
