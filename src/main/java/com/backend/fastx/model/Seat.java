package com.backend.fastx.model;

import com.backend.fastx.enums.DistanceCategory;
import com.backend.fastx.enums.SeatPosition;
import com.backend.fastx.enums.SeatStatus;
import com.backend.fastx.enums.SeatType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;



	@Entity
	public class Seat {
 
		

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getSeatNum() {
			return seatNum;
		}

		public void setSeatNum(int seatNum) {
			this.seatNum = seatNum;
		}

		public SeatStatus getStatus() {
			return status;
		}

		public void setStatus(SeatStatus status) {
			this.status = status;
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

		public SeatType getSeatType() {
			return seatType;
		}

		public void setSeatType(SeatType seatType) {
			this.seatType = seatType;
		}

		public Bus getBus() {
			return bus;
		}

		public void setBus(Bus bus) {
			this.bus = bus;
		}

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    private int seatNum;

	    @Enumerated(EnumType.STRING)
	    private SeatStatus status;
	    @Enumerated(EnumType.STRING)
	    private DistanceCategory distanceCategory;
	    @Enumerated(EnumType.STRING)
	    private SeatPosition seatPosition;
	    

	    @Enumerated(EnumType.STRING)
	    private SeatType seatType;
        
	    @ManyToOne
	    private Bus bus;

	    

	    // getters and setters


		

	    // Getters and Setters
	

	
	 
	 

}
