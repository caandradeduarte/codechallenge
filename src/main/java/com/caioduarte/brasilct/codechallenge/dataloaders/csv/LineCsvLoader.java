package com.caioduarte.brasilct.codechallenge.dataloaders.csv;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import au.com.bytecode.opencsv.CSVReader;

import com.caioduarte.brasilct.codechallenge.dataloaders.LineLoader;
import com.caioduarte.brasilct.codechallenge.models.Line;

@Repository
public class LineCsvLoader extends CsvLoader<Line> implements
		LineLoader {

	protected static final String LINES_CSV = "lines.csv";

	@Override
	public List<Line> load() {
		CSVReader reader = readFile(LINES_CSV);

		List<String[]> lines = loadLines(reader);

		return populate(lines);
	}

	@Override
	protected List<Line> populate(List<String[]> sLines) {
		ArrayList<Line> lines = new ArrayList<Line>(sLines.size());
		Line line;
		for(String[] sLine : sLines) {
			line = new Line(Integer.valueOf(sLine[0]), Integer.valueOf(sLine[1]), Integer.valueOf(sLine[2]));
			
			lines.add(line);
		}
		return lines;
	}

}
