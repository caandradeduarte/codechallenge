package com.caioduarte.brasilct.codechallenge.resources.converters;

import com.caioduarte.brasilct.codechallenge.models.Path;
import com.caioduarte.brasilct.codechallenge.models.Station;
import com.caioduarte.brasilct.codechallenge.resources.dto.PathDTO;

public class Path2PathDtoConverter {
	
	private static Path PATH;
	
	public Path2PathDtoConverter(Path path) {
		PATH = path;
	}
	
	public PathDTO convert() {
		PathDTO dto = new PathDTO();
		dto.setTravelTime(PATH.travelTime());
		
		for(Station s : PATH.stations()) {
			dto.getStations().add(s.getName());
		}
		
		return dto;
	}

}
