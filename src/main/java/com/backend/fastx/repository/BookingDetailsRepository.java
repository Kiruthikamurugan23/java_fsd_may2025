package com.backend.fastx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.fastx.model.BookingDetails;

public interface BookingDetailsRepository extends JpaRepository<BookingDetails, Integer> {
    List<BookingDetails> findByBookingId(int bookingId);
}
