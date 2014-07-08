package com.caioduarte.brasilct.codechallenge.resources.converters;

import java.util.ArrayList;

import com.caioduarte.brasilct.codechallenge.models.Line;
import com.caioduarte.brasilct.codechallenge.models.Path;
import com.caioduarte.brasilct.codechallenge.resources.dto.PathDTO;
import com.caioduarte.brasilct.codechallenge.resources.dto.PathDTO.StationDTO;

public class Path2PathDtoConverter {
	
	public PathDTO convert(Path path) {
		PathDTO dto = new PathDTO();
		dto.setTravelTime(path.travelTime());
		
		dto.setStations(new ArrayList<StationDTO>(path.legs().size()));
		
		path.legs().forEach(leg -> {
			dto.getStations().add(convertLeg2StationDto(leg));
		});
		
		return dto;
	}
	
	private StationDTO convertLeg2StationDto(Line leg) {
		StationDTO dto = new StationDTO();
		dto.setName(leg.getTarget().getName());
		dto.setLine(leg.getRoute().getLine());
		return dto;
	}

}
