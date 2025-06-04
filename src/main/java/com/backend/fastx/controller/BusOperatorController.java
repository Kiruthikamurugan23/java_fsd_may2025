package com.backend.fastx.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.fastx.dto.BusOperatorDto;
import com.backend.fastx.model.BusOperator;
import com.backend.fastx.service.BusOperatorService;

@RestController
@RequestMapping("/api/busoperators")
public class BusOperatorController {

    @Autowired
    private BusOperatorService busOperatorService;

    // Get all bus operators
    @GetMapping("/get")
    public List<BusOperator> getAll() {
        return busOperatorService.findAll();
    }

    

    // Create new bus operator
    @PostMapping("/create")
  
    public ResponseEntity<BusOperator> createBusOperator(@RequestBody BusOperatorDto dto) {
        BusOperator operator = busOperatorService.createBusOperator(dto);
        return ResponseEntity.ok(operator);
    }



}
