package com.caioduarte.brasilct.codechallenge.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Line implements Serializable {
	
	private static final long serialVersionUID = 287662115859408347L;

	@Id
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id")
	private Station source;
	
	@Id
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id")
	private Station target;
	
	@Id
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="line")
	private Route route;
	
	/**
	 * Created only because of hibernate
	 */
	@SuppressWarnings("unused")
	private Line() {}
	
	/**
	 * @param sourceId Station source id
	 * @param targetId Station target id
	 * @param routeLine Route line
	 */
	public Line(Integer sourceId, Integer targetId, Integer routeLine) {
		this.source = new Station(sourceId);
		this.target = new Station(targetId);
		this.route = new Route(routeLine);
	}

	public Station getSource() {
		return source;
	}

	public Station getTarget() {
		return target;
	}

	public Route getRoute() {
		return route;
	}

}
