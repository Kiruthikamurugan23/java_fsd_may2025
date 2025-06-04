package com.backend.fastx.model;



import com.backend.fastx.enums.Gender;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bookingdetails")

public class BookingDetails {

	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassName() {
		return passName;
	}
	public void setPassName(String passName) {
		this.passName = passName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getBoardingPoint() {
		return boardingPoint;
	}
	public void setBoardingPoint(String boardingPoint) {
		this.boardingPoint = boardingPoint;
	}
	public String getDroppingPoint() {
		return droppingPoint;
	}
	public void setDroppingPoint(String droppingPoint) {
		this.droppingPoint = droppingPoint;
	}
	public String getTotalFare() {
		return totalFare;
	}
	public void setTotalFare(String totalFare) {
		this.totalFare = totalFare;
	}
	public String getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(String totalSeats) {
		this.totalSeats = totalSeats;
	}
	public Seat getSeat() {
		return seat;
	}
	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String passName;
	private int age;
	@Enumerated(EnumType.STRING) // Stores enum value as string (BOOKED / NOT_BOOKED/Pending)
    
	private Gender gender;
	private String boardingPoint;
	private String droppingPoint;
	private String totalFare;
	private String totalSeats;
	
	@ManyToOne
	private Seat seat;
	@ManyToOne
	private Booking booking;
	

	

	

}
