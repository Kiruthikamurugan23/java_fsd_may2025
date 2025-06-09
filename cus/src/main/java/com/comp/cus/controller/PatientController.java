package com.comp.cus.controller;



import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.comp.cus.model.Patient;
import com.comp.cus.model.User;
import com.comp.cus.dto.PatientMedicalHistoryDto;
import com.comp.cus.service.PatientService;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/api/patient/add")
    public Patient addPatient(@RequestBody Patient patient) {
        return patientService.addPatient( patient);
    }


}
