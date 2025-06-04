package com.backend.fastx.model;



import java.time.LocalDate;

import com.backend.fastx.enums.BookingStatus;
import com.backend.fastx.enums.DistanceCategory;
import com.backend.fastx.enums.SeatPosition;
import com.backend.fastx.enums.SeatType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "booking")
public class Booking {

   

   
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	public BookingStatus getStatus() {
		return status;
	}
	public void setStatus(BookingStatus status) {
		this.status = status;
	}
	public double getTotalFare() {
		return totalFare;
	}
	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}
	public SeatType getSeatType() {
		return seatType;
	}
	public void setSeatType(SeatType seatType) {
		this.seatType = seatType;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	public DistanceCategory getDistanceCategory() {
		return distanceCategory;
	}
	public void setDistanceCategory(DistanceCategory distanceCategory) {
		this.distanceCategory = distanceCategory;
	}
	public SeatPosition getSeatPosition() {
		return seatPosition;
	}
	public void setSeatPosition(SeatPosition seatPosition) {
		this.seatPosition = seatPosition;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private LocalDate date;

	private int totalSeats;

	@Enumerated(EnumType.STRING)
	private BookingStatus status;

	private double totalFare;

	@Enumerated(EnumType.STRING)
	private SeatType seatType;

	@ManyToOne
	private Customer customer;

	@ManyToOne
	private Schedule schedule;
	@Enumerated(EnumType.STRING)
	private DistanceCategory distanceCategory;
	@Enumerated(EnumType.STRING)
	private SeatPosition seatPosition;
	


	

	
    

 

}
