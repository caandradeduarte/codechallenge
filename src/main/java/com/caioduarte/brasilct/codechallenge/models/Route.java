package com.caioduarte.brasilct.codechallenge.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Route {

	@Id
	private Integer line;
	
	private String name;
	
	private String color;
	
	private String stripe;
	
	/**
	 * Created only because of hibernate
	 */
	@SuppressWarnings("unused")
	private Route() {}
	
	/**
	 * @param line Line Number
	 * @param name Line Name
	 * @param color Line Color
	 */
	public Route(Integer line, String name, String color) {
		this(line, name, color, null);
	}
	
	/**
	 * @param line Line Number
	 * @param name Line Name
	 * @param color Line Color
	 * @param stripe Line Stripe
	 */
	public Route(Integer line, String name, String color, String stripe) {
		this.line = line;
		this.name = name;
		this.color = color;
		this.stripe = stripe;
	}

	/**
	 * Allowed only from other models 
	 * 
	 * @param line
	 */
	Route(Integer line) {
		this(line, null, null, null);
	}

	public Integer getLine() {
		return line;
	}

	public String getName() {
		return name;
	}

	public String getColor() {
		return color;
	}

	public String getStripe() {
		return stripe;
	}
	
}
