package com.caioduarte.brasilct.codechallenge.resources.dto;

import java.time.Duration;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.caioduarte.brasilct.codechallenge.resources.adapters.DurationAdapter;

@XmlRootElement(name = "path")
public class PathDTO {

	public static class StationDTO {

		private String name;
		private Integer line;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getLine() {
			return line;
		}

		public void setLine(Integer line) {
			this.line = line;
		}

	}

	private List<StationDTO> stations;
	private Duration travelTime;

	public List<StationDTO> getStations() {
		return stations;
	}

	public void setStations(List<StationDTO> stations) {
		this.stations = stations;
	}

	@XmlJavaTypeAdapter(DurationAdapter.class)
	public Duration getTravelTime() {
		return travelTime;
	}

	public void setTravelTime(Duration travelTime) {
		this.travelTime = travelTime;
	}

}
