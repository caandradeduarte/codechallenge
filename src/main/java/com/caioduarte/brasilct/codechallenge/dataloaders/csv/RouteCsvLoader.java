package com.caioduarte.brasilct.codechallenge.dataloaders.csv;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import au.com.bytecode.opencsv.CSVReader;

import com.caioduarte.brasilct.codechallenge.dataloaders.RouteLoader;
import com.caioduarte.brasilct.codechallenge.models.Route;

@Repository
public class RouteCsvLoader extends CsvLoader<Route> implements RouteLoader {

	protected static final String ROUTES_CSV = "routes.csv";
	
	@Override
	@Transactional
	public List<Route> load() {
		CSVReader reader = readFile(ROUTES_CSV);
		
		List<String[]> lines = loadLines(reader);
		
		return populate(lines);
	}

	@Override
	protected List<Route> populate(List<String[]> lines) {
		ArrayList<Route> routes = new ArrayList<Route>(lines.size());
		Route route;
		for(String[] line : lines) {
			route = new Route(Integer.valueOf(line[0]), line[1], line[2], line[3]);
			
			routes.add(route);
		}
		return routes;
	}

}
