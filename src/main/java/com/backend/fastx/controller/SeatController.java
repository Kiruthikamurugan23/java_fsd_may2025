package com.backend.fastx.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.fastx.model.Seat;
import com.backend.fastx.service.SeatService;

@RestController
@RequestMapping("/api/seats")
public class SeatController {

    @Autowired
    private SeatService seatService;

    @GetMapping("/getall")
    public List<Seat> getAllSeats() {
        return seatService.getAllSeats();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getSeatById(@PathVariable int id) {
        try {
            Seat seat = seatService.getSeatById(id);  // service returns Seat or throws exception
            return ResponseEntity.ok(seat);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @PostMapping("/add/seat")
    public Seat addSeat(@RequestBody Seat seat) {
        return seatService.addSeat(seat);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateSeat(@PathVariable int id, @RequestBody Seat updatedSeat) {
        try {
            Seat seat = seatService.updateSeat(id, updatedSeat);
            return ResponseEntity.ok(seat);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteSeat(@PathVariable int id) {
        seatService.deleteSeat(id);
        return ResponseEntity.ok("Seat deleted with id: " + id);
    }

    // New endpoint to get calculated fare for a seat by seatId
    @GetMapping("get/{id}/fare")
    public ResponseEntity<?> getSeatFare(@PathVariable int id) {
        try {
            double fare = seatService.getFareForSeat(id);
            return ResponseEntity.ok(fare);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Seat not found with id: " + id);
        }
    }


}
