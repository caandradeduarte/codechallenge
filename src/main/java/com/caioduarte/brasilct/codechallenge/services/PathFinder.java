package com.caioduarte.brasilct.codechallenge.services;

import com.caioduarte.brasilct.codechallenge.models.Path;
import com.caioduarte.brasilct.codechallenge.models.Station;

public interface PathFinder {
	
	Path anyPath(Station source, Station target);
	
	Path shortestPath(Station source, Station target);

}
