package com.caioduarte.brasilct.codechallenge.models;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

public class Path {

	private ArrayList<Line> legs;
	
	public Path(ArrayList<Line> legs) {
		this.legs = legs;
	}
	
	public List<Line> legs() {
		return legs;
	}

	public Duration travelTime() {
		if(CollectionUtils.isEmpty(legs)) return Duration.ZERO;
		
		int totalConections = 0;
		int lastLine = legs.get(0).getRoute().getLine();
		
		for(Line leg : legs) {
			if(lastLine != leg.getRoute().getLine()){
				lastLine = leg.getRoute().getLine();
				totalConections++;
			}
		}
		
		return Duration.ofMinutes(3 * legs.size() + totalConections * 12);
	}
	
}
