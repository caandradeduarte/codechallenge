package com.caioduarte.brasilct.codechallenge.models;

import static org.junit.Assert.*;
import org.junit.Test;

import com.caioduarte.brasilct.codechallenge.models.Station;

public class StationTest {

	@Test
	public void must_create_an_station_by_its_builder() {
		int id = 1;
		String name = "name";
		String latitude = "latitude", longitude = "longitude";
		int zone = 2;
		int totalLines = 3;
		int rail = 4;
		String displayName = "displayName";
		
		Station.Builder builder = new Station.Builder();
		Station station = builder.id(id).name(name).coordinates(latitude, longitude).zone(zone).totalLines(totalLines)
				.rail(rail).displayName(displayName).build();

		assertEquals(Integer.valueOf(id), station.getId());
		assertEquals(name, station.getName());
		assertEquals(latitude, station.getLatitude());
		assertEquals(longitude, station.getLongitude());
		assertEquals(Integer.valueOf(zone), station.getZone());
		assertEquals(Integer.valueOf(totalLines), station.getTotalLines());
		assertEquals(Integer.valueOf(rail), station.getRail());
		assertEquals(displayName, station.getDisplayName());
	}

}
