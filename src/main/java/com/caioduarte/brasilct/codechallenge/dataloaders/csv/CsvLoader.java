package com.caioduarte.brasilct.codechallenge.dataloaders.csv;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public abstract class CsvLoader<T> {

	public CsvLoader() {
		super();
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
	
	protected abstract List<T> populate(List<String[]> lines);

}