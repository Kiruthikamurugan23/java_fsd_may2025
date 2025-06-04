package com.backend.fastx.service;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.fastx.model.Schedule;
import com.backend.fastx.model.Seat;
import com.backend.fastx.repository.ScheduleRepository;
import com.backend.fastx.repository.SeatRepository;
import com.backend.fastx.util.FareUtil;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;



    public Seat addSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    public Seat getSeatById(int id) {
        return seatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Seat not found with ID: " + id));
    }

    public Seat updateSeat(int id, Seat updatedSeat) {
        Seat existingSeat = getSeatById(id);

        if (updatedSeat.getSeatNum() != 0)
            existingSeat.setSeatNum(updatedSeat.getSeatNum());

        if (updatedSeat.getStatus() != null)
            existingSeat.setStatus(updatedSeat.getStatus());

        if (updatedSeat.getSeatType() != null)
            existingSeat.setSeatType(updatedSeat.getSeatType());

        if (updatedSeat.getBus() != null)
            existingSeat.setBus(updatedSeat.getBus());

        return seatRepository.save(existingSeat);
    }

    public void deleteSeat(int id) {
        Seat seat = getSeatById(id);
        seatRepository.delete(seat);
    }

    public double getFareForSeat(int seatId) {
        Seat seat = getSeatById(seatId);

        Schedule schedule = scheduleRepository.findActiveScheduleByBusId(seat.getBus().getId())
                .orElseThrow(() -> new RuntimeException("Schedule not found for bus"));

        double baseFare = schedule.getBaseFare();

        return FareUtil.calculateFare(
                baseFare,
                seat.getSeatType(),
                seat.getDistanceCategory(),   // make sure this is set in seat
                seat.getSeatPosition()       // and this too
        );
    }}

