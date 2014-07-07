package com.caioduarte.brasilct.codechallenge.dao;

import java.util.List;

import com.caioduarte.brasilct.codechallenge.models.Route;

public interface RouteDao {
	
	void saveAll(List<Route> routes);
	
	List<Route> list();

}
