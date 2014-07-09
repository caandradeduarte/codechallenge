package com.caioduarte.brasilct.codechallenge.resources;

import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.caioduarte.brasilct.codechallenge.dao.StationDao;
import com.caioduarte.brasilct.codechallenge.models.Path;
import com.caioduarte.brasilct.codechallenge.models.Station;
import com.caioduarte.brasilct.codechallenge.resources.converters.Path2PathDtoConverter;
import com.caioduarte.brasilct.codechallenge.services.PathFinder;

@Component
@javax.ws.rs.Path("/path")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class PathFinderResource {

	@Autowired
	private StationDao stationDao;

	@Autowired
	private PathFinder pathFinder;

	@GET
	@javax.ws.rs.Path("/source/{source-id}/target/{target-id}")
	public Response anyPath(@PathParam("source-id") final Integer sourceId,
			@PathParam("target-id") final Integer targetId) {

		Station source = stationDao.find(sourceId);
		Station target = stationDao.find(targetId);
		
		if(source == null || target == null) {
			Response.status(Status.NOT_FOUND).build();
		}

		Path path = pathFinder.anyPath(source, target);

		return Response.ok(new Path2PathDtoConverter().convert(path)).build();
	}

	@GET
	@javax.ws.rs.Path("/shortest/source/{source-id}/target/{target-id}")
	public Response shortestPath(
			@PathParam("source-id") final Integer sourceId,
			@PathParam("target-id") final Integer targetId) {

		Station source = stationDao.find(sourceId);
		Station target = stationDao.find(targetId);
		
		if(source == null || target == null) {
			Response.status(Status.NOT_FOUND).build();
		}

		Path path = pathFinder.shortestPath(source, target);

		return Response.ok(new Path2PathDtoConverter().convert(path)).build();
	}

}
