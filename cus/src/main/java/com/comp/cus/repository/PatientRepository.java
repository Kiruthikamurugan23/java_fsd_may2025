package com.comp.cus.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.comp.cus.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    @Query("SELECT p FROM Patient p WHERE p.user.username = ?1")
    Optional<Patient> getByUsername(String username);
}



