package com.backend.fastx.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "schedule")
public class Schedule {


	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(LocalDate journeyDate) {
		this.journeyDate = journeyDate;
	}
	public LocalTime getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	public double getBaseFare() {
		return baseFare;
	}
	public void setBaseFare(double baseFare) {
		this.baseFare = baseFare;
	}
	public LocalTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
	}
	public BusRoute getBusRoute() {
		return busRoute;
	}
	public void setBusRoute(BusRoute busRoute) {
		this.busRoute = busRoute;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate journeyDate;

    private LocalTime departureTime;
    private int availableSeats;
    private double baseFare;
    private LocalTime arrivalTime;
    @ManyToOne
    private Bus bus;
    @ManyToOne
    private BusRoute busRoute;
   

}

    

