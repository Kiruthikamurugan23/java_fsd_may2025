package com.comp.cus.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comp.cus.dto.PatientMedicalHistoryDto;
import com.comp.cus.exception.ResourceNotFoundException;
import com.comp.cus.model.Doctor;
import com.comp.cus.model.MedicalHistory;
import com.comp.cus.model.Patient;
import com.comp.cus.model.PatientDoctor;
import com.comp.cus.model.User;
import com.comp.cus.repository.DoctorRepository;
import com.comp.cus.repository.MedicalHistoryRepository;
import com.comp.cus.repository.PatientDoctorRepository;
import com.comp.cus.repository.PatientRepository;
import com.comp.cus.repository.UserRepository;



	    @Service
	    public class PatientDoctorService {
	    	@Autowired
	    	private MedicalHistoryRepository medicalHistoryRepository;

	        @Autowired
	        private PatientRepository patientRepository;

	        @Autowired
	        private DoctorRepository doctorRepository;

	        @Autowired
	        private PatientDoctorRepository patientDoctorRepository;
	        @Autowired
	        private UserRepository userRepository;
	        

	        public String makeAppointment(String username, int doctorId) {
	            // 1. Get patient by username
	            Patient patient = patientRepository.getByUsername(username)
	                    .orElseThrow(() -> new ResourceNotFoundException("Patient not found with username: " + username));

	            // 2. Get doctor by ID
	            Doctor doctor = doctorRepository.findById(doctorId)
	                    .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with ID: " + doctorId));

	            // 3. Check if appointment already exists
	            boolean exists = patientDoctorRepository.existsByPatientAndDoctor(patient, doctor);
	            if (exists) {
	                return "Appointment is there with dr " + doctor.getName();
	            }

	            // 4. Save new PatientDoctor record
	            PatientDoctor appointment = new PatientDoctor();
	            appointment.setPatient(patient);
	            appointment.setDoctor(doctor);
	            patientDoctorRepository.save(appointment);

	            return "Appointment booked successfully . " + doctor.getName();
	        }

	        public List<Patient> getPatientsByDoctor(int doctorId) {
	            return patientDoctorRepository.getByDoctorId(doctorId);
	        }


			public List<PatientMedicalHistoryDto> getMedicalHistoryByPatientId(int patientId) {
			    // 1. Verify patient exists
			     patientRepository.findById(patientId)
			        .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + patientId));

			    // 2. Fetch medical histories by patient id from repository
			    List<MedicalHistory> histories = medicalHistoryRepository.findByPatientId(patientId);

			    // 3. Map to DTO
			    return histories.stream()
			        .map(mh -> new PatientMedicalHistoryDto(
			            mh.getIllness(),
			            mh.getNumOfYears(),
			            mh.getCurrentMedication()
			        ))
			        .collect(Collectors.toList());
			}
			public String addMedicalHistoryToPatient(int patientId, List<MedicalHistory> medicalHistories) {
			    // 1. Fetch patient by id
			    Patient patient = patientRepository.findById(patientId)
			        .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + patientId));
			    
			    // 2. Validate user exists on patient
			    User user = patient.getUser();
			    if (user == null) {
			        throw new IllegalArgumentException("User details are required");
			    }
			    
			    // 3. Save user (optional if already saved)
			    userRepository.save(user);
			    
			    // 4. Save patient (optional if no changes)
			    patientRepository.save(patient);
			    
			    // 5. Save each medical history linked to patient
			    if (medicalHistories != null && !medicalHistories.isEmpty()) {
			        medicalHistories.forEach(mh -> {
			            mh.setPatient(patient);
			            medicalHistoryRepository.save(mh);
			        });
			    }
			    
			    return "Patient medical history added successfully";
			}

			
	    }

			


	    



