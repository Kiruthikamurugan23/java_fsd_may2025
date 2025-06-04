package com.backend.fastx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backend.fastx.dto.BookingDetailsResponse;
import com.backend.fastx.model.Booking;
import com.backend.fastx.service.BookingService;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // Create a new booking for given customerId and scheduleId
    @PostMapping("/create/{customerId}/{scheduleId}")
    public ResponseEntity<Booking> createBooking(
            @PathVariable int customerId,
            @PathVariable int scheduleId,
            @RequestBody Booking bookingRequest) {

        Booking booking = bookingService.bookInBus(customerId, scheduleId, bookingRequest);
        return ResponseEntity.ok(booking);
    }

    // Get booking by id
    @GetMapping("/{bookingId}")
    public ResponseEntity<Booking> getBookingById(@PathVariable int bookingId) {
        Booking booking = bookingService.getBookingById(bookingId);
        return ResponseEntity.ok(booking);
    }

    // Get bookings by customer
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Booking>> getBookingsByCustomer(@PathVariable int customerId) {
        List<Booking> bookings = bookingService.getBookingsByCustomer(customerId);
        return ResponseEntity.ok(bookings);
    }

    // Get bookings by schedule
    @GetMapping("/schedule/{scheduleId}")
    public ResponseEntity<List<Booking>> getBookingsBySchedule(@PathVariable int scheduleId) {
        List<Booking> bookings = bookingService.getBookingsBySchedule(scheduleId);
        return ResponseEntity.ok(bookings);
    }

    // Update a booking
    @PutMapping("/update/{bookingId}")
    public ResponseEntity<Booking> updateBooking(
            @PathVariable int bookingId,
            @RequestBody Booking bookingRequest) {

        Booking updatedBooking = bookingService.updateBooking(bookingId, bookingRequest);
        return ResponseEntity.ok(updatedBooking);
    }

    // Cancel a booking
    @DeleteMapping("/cancel/{bookingId}")
    public ResponseEntity<String> cancelBooking(@PathVariable int bookingId) {
        bookingService.cancelBooking(bookingId);
        return ResponseEntity.ok("Booking cancelled successfully");
    }
    

    @GetMapping("/{id}/details")
    public ResponseEntity<BookingDetailsResponse> getBookingDetails(@PathVariable int id) {
        BookingDetailsResponse response = bookingService.getFullBookingDetails(id);
        return ResponseEntity.ok(response);
    }
}

    



