package com.comp.cus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comp.cus.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

}
