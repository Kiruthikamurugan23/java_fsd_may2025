package com.backend.fastx.model;

import java.time.LocalDate;

import com.backend.fastx.enums.SeatStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="cancellation")
public class Cancellation {
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getCancel_date() {
		return cancel_date;
	}
	public void setCancel_date(LocalDate cancel_date) {
		this.cancel_date = cancel_date;
	}
	public double getRefund_amt() {
		return refund_amt;
	}
	public void setRefund_amt(double refund_amt) {
		this.refund_amt = refund_amt;
	}
	public SeatStatus getStatus() {
		return status;
	}
	public void setStatus(SeatStatus status) {
		this.status = status;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	LocalDate cancel_date;
	private double refund_amt;
	@Enumerated(EnumType.STRING)
	// Stores enum value as string
	@OneToOne
    private BookingDetails bookingDetails;

    private SeatStatus status;
	private String reason;
	public Cancellation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cancellation(int id, LocalDate cancel_date, double refund_amt, SeatStatus status, String reason) {
		super();
		this.id = id;
		this.cancel_date = cancel_date;
		this.refund_amt = refund_amt;
		this.status = status;
		this.reason = reason;
	}
	
	

}
