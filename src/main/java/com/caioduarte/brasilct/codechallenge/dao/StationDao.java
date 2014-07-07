package com.caioduarte.brasilct.codechallenge.dao;

import java.util.List;

import com.caioduarte.brasilct.codechallenge.models.Station;

public interface StationDao {

	void saveAll(List<Station> stations);

	List<Station> list();
	
}
