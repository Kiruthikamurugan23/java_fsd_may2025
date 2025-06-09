package com.comp.cus.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.comp.cus.model.Doctor;
import com.comp.cus.model.Patient;
import com.comp.cus.model.PatientDoctor;
public interface PatientDoctorRepository extends JpaRepository<PatientDoctor, Integer> {
    boolean existsByPatientAndDoctor(Patient patient, Doctor doctor);
    @Query("SELECT pd.patient FROM PatientDoctor pd WHERE pd.doctor.id = ?1")
    List<Patient> getByDoctorId(int doctorId);

}


