package com.comp.cus.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comp.cus.dto.PatientMedicalHistoryDto;
import com.comp.cus.model.MedicalHistory;
import com.comp.cus.model.Patient;

import com.comp.cus.service.PatientDoctorService;
import com.comp.cus.service.PatientService;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/patientdoctor")
public class PatientDoctorController {

    @Autowired
    private PatientDoctorService patientDoctorService;  
    
    
    @PostMapping("/patient/medicalhistory/userdetails/{patientId}")
    public String addMedicalHistoryToPatient(@PathVariable int patientId, @RequestBody List<MedicalHistory> medicalHistory) {
        return patientDoctorService.addMedicalHistoryToPatient(patientId, medicalHistory);
    }

    


    
    // 1. Make appointment with a doctor-all
    @PostMapping("/appointment/{doctorId}")
    public ResponseEntity<?> makeAppointment(Principal principal, @PathVariable int doctorId) {
       
        return ResponseEntity.ok( patientDoctorService.makeAppointment(principal.getName(), doctorId));
    }

    // 2. Get all patients by doctor id -only doc
    @GetMapping("/doctor/{doctorId}/patients")
    
    public ResponseEntity<?> getPatientsByDoctor(@PathVariable int doctorId) {
        List<Patient> patients = patientDoctorService.getPatientsByDoctor(doctorId);
        return ResponseEntity.ok(patients);
    }
    //get-det-patid
    @GetMapping("/medical-history/{patientId}")
    public ResponseEntity<List<PatientMedicalHistoryDto>> getMedicalHistory(@PathVariable int patientId) {
        return ResponseEntity.ok(patientDoctorService.getMedicalHistoryByPatientId(patientId));
    }

}
