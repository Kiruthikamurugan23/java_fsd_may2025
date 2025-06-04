package com.backend.fastx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.fastx.model.Bus;
import com.backend.fastx.service.BusService;


@RestController
@RequestMapping("/api/buses")
public class BusController {
    @Autowired
    private final BusService busService;

    public BusController(BusService busService) {
        this.busService = busService;
    }

    @PostMapping("/add")
    public Bus addBus(@RequestBody Bus bus) {
        // Make sure ID is zero or not set, to avoid accidental updates
        if (bus.getId() != 0) {
            throw new IllegalArgumentException("Cannot set ID when adding a new bus.");
        }
        return busService.addBus(bus);
    }
 // Read - Get all buses
    @GetMapping("/getall")
    public List<Bus> getAllBuses() {
        return busService.getAllBuses();
    }

    @GetMapping("/getall/{id}")
    public ResponseEntity<?> getBusById(@PathVariable int id) {
        List<Bus> bus = busService.getBusById(id);
        if (bus == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bus not found with id: " + id);
        }
        return ResponseEntity.ok(bus);
    }

//
    // Update - Update an existing bus
    @PutMapping("update/{id}")
    public ResponseEntity<Bus> updateBus(@PathVariable int id, @RequestBody Bus bus) {
        if (bus.getId() != id) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(bus);
    }}

