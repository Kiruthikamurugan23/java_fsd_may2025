package com.backend.fastx.dto;


import java.time.LocalDate;
import java.util.List;

import com.backend.fastx.enums.*;
import com.backend.fastx.model.*;

public class BookingDetailsResponse {
    public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
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
	public List<BookingDetails> getBookingDetails() {
		return bookingDetails;
	}
	public void setBookingDetails(List<BookingDetails> bookingDetails) {
		this.bookingDetails = bookingDetails;
	}
	private int bookingId;
    private LocalDate date;
    private int totalSeats;
    private BookingStatus status;
    private double totalFare;
    private SeatType seatType;
    
    private Customer customer;
    private Schedule schedule;
    private List<BookingDetails> bookingDetails;
    

    // Getters and Setters
}
