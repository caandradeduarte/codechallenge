package com.caioduarte.brasilct.codechallenge.models;

import java.time.Duration;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Path {

	private static final int TIME_TO_CHANGE_LINE = 12;
	private static final int TIME_TO_NEXT_STATION = 3;
	
	private static final Map<Integer, Station> STATIONS = new HashMap<Integer, Station>();
	private static final Map<Integer, Route> ROUTES = new HashMap<Integer, Route>();

	private static final Deque<Station> NO_PATH = new ArrayDeque<Station>();
	
	private final int SOURCE, TARGET;
	private final boolean SHORTEST;
	
	public Path(Collection<Station> stations, Collection<Route> routes,	Collection<Line> lines, int sourceId, int targetId, boolean shortest) {

		stations.forEach(s -> {
			STATIONS.put(s.getId(), s);
		});

		routes.forEach(r -> {
			ROUTES.put(r.getLine(), r);
		});

		lines.forEach(l -> {
			Station source = STATIONS.get(l.getSource().getId());
			Station target = STATIONS.get(l.getTarget().getId());
			Route route = ROUTES.get(l.getRoute().getLine());

			route.getStations().addAll(Arrays.asList(source, target));

			if(!source.getNextStations().contains(target))
				source.getNextStations().add(target);
			source.getLines().add(route);

			if(!target.getNextStations().contains(source))
				target.getNextStations().add(source);
			target.getLines().add(route);

			STATIONS.forEach((key, value) -> {
				NO_PATH.push(value);
			});
		});

		SOURCE = sourceId;
		TARGET = targetId;
		SHORTEST = shortest;
	}
	
	public Duration travelTime() {
		Deque<Station> path = findPath(SOURCE, TARGET, SHORTEST);
		
		if (path == null || path.size() < 2)
			return Duration.ZERO;
		
		int minutes = 0;
		Station current = path.removeLast();
		Set<Route> possibleRoutes = new HashSet<Route>(current.getLines());
		
		while (!path.isEmpty()) {
			possibleRoutes.retainAll(path.peekLast().getLines());
			minutes += TIME_TO_NEXT_STATION;
			if (possibleRoutes.isEmpty()) {
				minutes += TIME_TO_CHANGE_LINE;
				possibleRoutes.addAll(path.peekLast().getLines());
			}
			
			current = path.removeLast();
		}
		
		return Duration.ofMinutes(minutes);
	}
	
	public List<Station> stations() {
		Deque<Station> path = findPath(SOURCE, TARGET, SHORTEST);
		
		if(path == null) 
			return Collections.emptyList();
		
		ArrayList<Station> stations = new ArrayList<Station>();
		
		while (!path.isEmpty()) {
			stations.add(path.removeLast());
		}
		
		return stations;
	}
	
	protected Deque<Station> findPath(int sourceId, int targetId, boolean shortest) {
		Station source = STATIONS.get(sourceId);
		Station target = STATIONS.get(targetId);
		
		if (source == null || target == null) 
			return null;
		
		return findPath(source, target, shortest, new BitSet(NO_PATH.size()), new ArrayDeque<Station>(), NO_PATH.size(), 0);
	}

	protected Deque<Station> findPath(Station current, Station target, boolean shortest, BitSet visitedStations, Deque<Station> currentPath, int bestPathSteps, int currentStep) {
		currentPath.push(current);
		visitedStations.set(current.getId(), true);
		currentStep++;

		Deque<Station> bestPath = NO_PATH;

		if (current.getId().equals(target.getId())) {
			bestPath = new ArrayDeque<Station>(currentPath);
		} else {
			for (Station next : current.getNextStations()) {
				if (currentStep >= bestPathSteps)
					continue;

				if (visitedStations.get(next.getId()))
					continue;

				Deque<Station> path = findPath(next, target, shortest,
						visitedStations, currentPath, bestPathSteps,
						currentStep);

				if (path.size() < bestPath.size()) {
					bestPath = path;
					bestPathSteps = bestPath.size();
				}

				if (!shortest && bestPath != NO_PATH)
					break;
			}
		}
		
		currentStep--;
		visitedStations.set(current.getId(), true);
		currentPath.pop();
		
		return bestPath;
	}

}
