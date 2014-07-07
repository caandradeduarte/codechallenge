package com.caioduarte.brasilct.codechallenge.models;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class StationTest {

	@Test
	public void must_create_an_station_by_its_builder() {
		int id = 1;
		String name = "name";
		BigDecimal latitude = new BigDecimal("55.14"), longitude = new BigDecimal("-0.4232");
		BigDecimal zone = new BigDecimal("2.5");
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
		assertEquals(zone, station.getZone());
		assertEquals(Integer.valueOf(totalLines), station.getTotalLines());
		assertEquals(Integer.valueOf(rail), station.getRail());
		assertEquals(displayName, station.getDisplayName());
	}

}
