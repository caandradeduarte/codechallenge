package com.caioduarte.brasilct.codechallenge.dataloaders.csv;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

import au.com.bytecode.opencsv.CSVReader;

import com.caioduarte.brasilct.codechallenge.models.Route;

public class RouteCsvLoaderTest {

	private RouteCsvLoader loader = new RouteCsvLoader();

	CSVReader routesCsvFile;

	@Before
	public void readFile() {
		routesCsvFile = loader.readFile(RouteCsvLoader.ROUTES_CSV);
	}

	@Test
	public void must_find_routes_file() {
		assertNotNull(routesCsvFile);
	}

	@Test
	public void must_ignore_first_line() throws IOException {
		assertNotEquals("line", routesCsvFile.readNext()[0]);
	}

	@Test
	public void must_load_the_lines_of_the_file() {
		assertFalse(CollectionUtils.isEmpty(loader.loadLines(routesCsvFile)));
	}

	@Test
	public void must_populate_a_list_of_routes() {
		List<String[]> lines = loader.loadLines(routesCsvFile);
		List<Route> populatedRoutes = loader.populate(lines);
		assertFalse(CollectionUtils.isEmpty(populatedRoutes));
		assertNotNull(populatedRoutes.get(0).getLine());
	}

}
