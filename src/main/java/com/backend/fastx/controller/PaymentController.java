package com.backend.fastx.controller;


import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backend.fastx.model.Payment;
import com.backend.fastx.model.Booking;
import com.backend.fastx.repository.BookingRepository;
import com.backend.fastx.repository.PaymentRepository;
import com.backend.fastx.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private BookingRepository bookingRepository;

   

        // Create payment for a booking
        @PostMapping("/create/{bookingId}")
        public ResponseEntity<?> createPayment(@PathVariable int bookingId, @RequestBody Payment payment) {
            Booking booking = bookingRepository.findById(bookingId)
                    .orElseThrow(() -> new ResourceNotFoundException("Booking not found with ID: " + bookingId));

            // Set required payment fields
            payment.setBooking(booking);
            payment.setPaymentDate(LocalDate.now()); // Set current date automatically

            // Optionally calculate fare based on booking
            double totalAmount = booking.getSchedule().getBaseFare() * booking.getTotalSeats();
            payment.setPaymentAmount(totalAmount);

            Payment savedPayment = paymentRepository.save(payment);
            return ResponseEntity.ok(savedPayment);
        }

        // Get payment by ID
     // Get payment by ID
        @GetMapping("/get/{id}")
        public ResponseEntity<?> getPaymentById(@PathVariable int id) {
            Payment payment = paymentRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Payment not found with ID: " + id));

            return ResponseEntity.ok(payment);
        }

}
    

