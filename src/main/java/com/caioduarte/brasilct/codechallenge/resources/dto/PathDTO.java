package com.caioduarte.brasilct.codechallenge.resources.dto;

import java.time.Duration;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.caioduarte.brasilct.codechallenge.resources.adapters.DurationAdapter;

@XmlRootElement(name = "path")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class PathDTO {

	public static class StationDTO {

		private String name;
		private Integer line;

		@XmlElement(name = "name")
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@XmlElement(name = "line")
		public Integer getLine() {
			return line;
		}

		public void setLine(Integer line) {
			this.line = line;
		}

	}

	private List<StationDTO> stations;
	private Duration travelTime;

	@XmlElement(name = "stations")
	public List<StationDTO> getStations() {
		return stations;
	}

	public void setStations(List<StationDTO> stations) {
		this.stations = stations;
	}

	@XmlElement(name = "travel-time")
	@XmlJavaTypeAdapter(DurationAdapter.class)
	public Duration getTravelTime() {
		return travelTime;
	}

	public void setTravelTime(Duration travelTime) {
		this.travelTime = travelTime;
	}

}
