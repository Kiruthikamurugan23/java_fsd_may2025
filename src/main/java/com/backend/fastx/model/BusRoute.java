package com.backend.fastx.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="bus_route")
public class BusRoute {
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String origin;
	private  String destination;
	private String duration;
	public BusRoute() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BusRoute(int id, String origin, String destination, String duration) {
		super();
		this.id = id;
		this.origin = origin;
		this.destination = destination;
		this.duration = duration;
	}
	
	}
	
	
