package com.caioduarte.brasilct.codechallenge.resources.dto;

import java.time.Duration;
import java.util.ArrayList;
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

	private List<String> stations = new ArrayList<String>();
	private Duration travelTime;

	@XmlElement(name = "stations")
	public List<String> getStations() {
		return stations;
	}

	public void setStations(List<String> stations) {
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
