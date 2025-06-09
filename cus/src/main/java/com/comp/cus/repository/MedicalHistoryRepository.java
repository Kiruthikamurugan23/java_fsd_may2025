package com.comp.cus.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comp.cus.model.MedicalHistory;

public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory, Integer> {
    List<MedicalHistory> findByPatientId(int patientId);
}

