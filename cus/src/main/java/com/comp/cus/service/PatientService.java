package com.comp.cus.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comp.cus.model.Patient;
import com.comp.cus.repository.PatientRepository;

@Service
public class PatientService {

	
	@Autowired
	private PatientRepository patientRepository;


	public Patient addPatient(Patient patient) {
		
		return  patientRepository.save(patient);
	}


	


	


}
