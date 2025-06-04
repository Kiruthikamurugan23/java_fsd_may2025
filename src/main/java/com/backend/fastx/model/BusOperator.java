package com.backend.fastx.model;

import jakarta.persistence.*;

@Entity
@Table(name = "bus_operator")
public class BusOperator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String contact;
    private String email;
    private String company;

    @Column(length = 1000)
    private String companyAddress;

    @OneToOne
    private User user;

    // ✅ Default constructor (required by JPA)
    public BusOperator() {}

    // Parameterized constructor
    public BusOperator(int id, String name, String contact, String email, String company, String companyAddress, User user) {
        super();
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.company = company;
        this.companyAddress = companyAddress;
        this.user = user;
    }

    // Getters and setters

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
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getCompanyAddress() {
        return companyAddress;
    }
    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}

