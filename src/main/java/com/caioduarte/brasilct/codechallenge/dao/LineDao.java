package com.caioduarte.brasilct.codechallenge.dao;

import java.util.List;

import com.caioduarte.brasilct.codechallenge.models.Line;

public interface LineDao {

	void saveAll(List<Line> lines);
	
	List<Line> list();
	
}
