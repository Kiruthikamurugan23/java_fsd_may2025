package com.backend.fastx.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

	

	@Entity
	@Table(name = "executive")
	public class Executive {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    private String name;

	    @Column(unique = true, nullable = false)
	    private String email;
	    private String phone;
	    private String address;
	    private boolean active;

	    // Constructors
	    public Executive() {
	    }

	    public Executive(String name, String email, String phone, String address, LocalDate dateOfJoining, boolean active) {
	        this.name = name;
	        this.email = email;
	        this.phone = phone;
	        this.address = address;
	        
	        this.active = active;
	    }

	    // Getters & Setters
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getPhone() {
	        return phone;
	    }

	    public void setPhone(String phone) {
	        this.phone = phone;
	    }

	    public String getAddress() {
	        return address;
	    }

	    public void setAddress(String address) {
	        this.address = address;
	    }

	    

	    public boolean isActive() {
	        return active;
	    }

	    public void setActive(boolean active) {
	        this.active = active;
	    }
	}



