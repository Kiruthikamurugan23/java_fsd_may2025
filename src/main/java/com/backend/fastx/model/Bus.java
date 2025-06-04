package com.backend.fastx.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String busName;
    private int busNum;
    private String busType;
    private int busCapacity;
    private String amenities;

    @ManyToOne
    private BusOperator busOperator;

    public Bus() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public int getBusNum() {
        return busNum;
    }

    public void setBusNum(int busNum) {
        this.busNum = busNum;
    }

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }

    public int getBusCapacity() {
        return busCapacity;
    }

    public void setBusCapacity(int busCapacity) {
        this.busCapacity = busCapacity;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public BusOperator getBusOperator() {
        return busOperator;
    }

    public void setBusOperator(BusOperator busOperator) {
        this.busOperator = busOperator;
    }
}

	