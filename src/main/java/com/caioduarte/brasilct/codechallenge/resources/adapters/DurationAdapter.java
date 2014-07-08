package com.caioduarte.brasilct.codechallenge.resources.adapters;

import java.time.Duration;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.springframework.util.StringUtils;

public class DurationAdapter extends XmlAdapter<Duration, String> {

	@Override
	public String unmarshal(Duration v) throws Exception {
		if(v == null) return null;
		Integer hour = (int) v.getSeconds() / 3600;
		Integer mins = (int) (v.getSeconds()%3600) / 60;
		return String.format("%02d", hour) + ":" + String.format("%02d", mins);
	}

	@Override
	public Duration marshal(String v) throws Exception {
		if (!StringUtils.isEmpty(v) || v.matches("([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]")) {
			int hour = Integer.valueOf(v.split(":")[0]);
			int mins = Integer.valueOf(v.split(":")[1]);
			
			return Duration.ofSeconds(hour*3600 + mins*60);
		}
		return null;
	}

}
