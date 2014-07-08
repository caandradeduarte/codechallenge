package com.caioduarte.brasilct.codechallenge.models;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class PathTest {
	
	@Test
	public void must_return_zero_duration_if_list_of_legs_is_null() {
		Path path = new Path(null); 
		
		assertEquals(Duration.ZERO, path.travelTime());
	}

	@Test
	public void must_return_zero_duration_if_list_of_legs_is_empty() {
		Path path = new Path(new ArrayList<Line>()); 
		
		assertEquals(Duration.ZERO, path.travelTime());
	}
	
	@Test
	public void must_return_3_minutes_duration_if_there_is_only_one_leg() {
		Line leg = new Line(1, 2, 1);
		
		Path path = new Path(new ArrayList<Line>(Arrays.asList(leg)));
		
		assertEquals(Duration.ofMinutes(3), path.travelTime());
	}
	
	@Test
	public void must_return_18_minutes_if_there_are_2_legs_from_different_lines() {
		Line leg = new Line(1, 2, 1);
		Line leg2 = new Line(2, 3, 2);
		
		Path path = new Path(new ArrayList<Line>(Arrays.asList(leg, leg2)));
		
		assertEquals(Duration.ofMinutes(18), path.travelTime());
	}

}
