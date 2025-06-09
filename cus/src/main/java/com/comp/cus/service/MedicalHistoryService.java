package com.comp.cus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comp.cus.model.MedicalHistory;
import com.comp.cus.repository.MedicalHistoryRepository;
@Service
public class MedicalHistoryService {
	@Autowired
	private MedicalHistoryRepository medicalHistoryRepository;

	public List<MedicalHistory> getAllMedicalHistories() {
		// TODO Auto-generated method stub
		return medicalHistoryRepository.findAll();
	}
	

}
