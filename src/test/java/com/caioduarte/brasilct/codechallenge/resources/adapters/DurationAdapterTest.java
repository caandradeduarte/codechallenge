package com.caioduarte.brasilct.codechallenge.resources.adapters;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.junit.Test;

public class DurationAdapterTest {
	
	@Test
	public void must_return_formated_duration() throws Exception {
		DurationAdapter adapter = new DurationAdapter();
		String result = adapter.unmarshal(Duration.ofHours(2).plusMinutes(4));
		
		assertEquals("02:04", result);
	}
	
	@Test
	public void must_return_a_3780_seconds_duration() throws Exception {
		DurationAdapter adapter = new DurationAdapter();
		Duration result = adapter.marshal("01:03");
		
		assertEquals(3780, result.getSeconds());
	}

}
