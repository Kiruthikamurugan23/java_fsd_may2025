package com.comp.cus.service;

import org.springframework.stereotype.Service;

import com.comp.cus.model.Doctor;
import com.comp.cus.repository.DoctorRepository;
@Service
public class DoctorService {
	private DoctorRepository doctorRepository;

	public DoctorService(DoctorRepository doctorRepository) {
		super();
		this.doctorRepository = doctorRepository;
	}

	public Doctor addDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return doctorRepository.save(doctor);
	}

}
