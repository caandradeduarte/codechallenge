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

import com.caioduarte.brasilct.codechallenge.models.Line;

public class LineCsvLoaderTest {

	private LineCsvLoader loader = new LineCsvLoader();

	CSVReader linesCsvFile;

	@Before
	public void readFile() {
		linesCsvFile = loader.readFile(LineCsvLoader.LINES_CSV);
	}

	@Test
	public void must_find_lines_file() {
		assertNotNull(linesCsvFile);
	}

	@Test
	public void must_ignore_first_line() throws IOException {
		assertNotEquals("station1", linesCsvFile.readNext()[0]);
	}

	@Test
	public void must_load_the_lines_of_the_file() {
		assertFalse(CollectionUtils.isEmpty(loader.loadLines(linesCsvFile)));
	}

	@Test
	public void must_populate_a_list_of_lines() {
		List<String[]> lines = loader.loadLines(linesCsvFile);
		List<Line> populatedRoutes = loader.populate(lines);
		assertFalse(CollectionUtils.isEmpty(populatedRoutes));
		assertNotNull(populatedRoutes.get(0).getRoute());
	}
	
}
