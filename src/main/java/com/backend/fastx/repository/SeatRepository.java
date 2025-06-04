package com.backend.fastx.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.fastx.model.Bus;
import com.backend.fastx.model.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {

    // Find all seats belonging to a specific bus
    List<Seat> findByBus(Bus bus);

}
