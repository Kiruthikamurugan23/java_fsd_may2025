package com.backend.fastx.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.backend.fastx.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

    @Query("SELECT b FROM Booking b WHERE b.customer.id = ?1")
    List<Booking> findByCustomerId(int customerId);

    @Query("SELECT b FROM Booking b WHERE b.schedule.id = ?1")
    List<Booking> findByScheduleId(int scheduleId);

}


	

	


