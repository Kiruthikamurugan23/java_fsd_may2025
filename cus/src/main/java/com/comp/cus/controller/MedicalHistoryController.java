package com.comp.cus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comp.cus.model.MedicalHistory;
import com.comp.cus.service.MedicalHistoryService;

@RestController
@RequestMapping("/api/medicalhistory")
public class MedicalHistoryController {

    @Autowired
    private MedicalHistoryService medicalHistoryService;



   //Get all medical histories
    @GetMapping("/all")
    public List<MedicalHistory> getAllMedicalHistories() {
        return medicalHistoryService.getAllMedicalHistories();
    }

  
}

