package com.backend.fastx.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.fastx.model.Schedule;
import com.backend.fastx.repository.ScheduleRepository;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    // Create schedule
    public Schedule createSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    // Get all schedules
    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    // Get schedule by ID or throw error if not found
    public Schedule getScheduleById(int id) {
        return scheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule not found with ID: " + id));
    }

    // Update schedule
    public Schedule updateSchedule(int id, Schedule updatedSchedule) {
        Schedule existingSchedule = getScheduleById(id);

        if (updatedSchedule.getJourneyDate() != null)
            existingSchedule.setJourneyDate(updatedSchedule.getJourneyDate());

        if (updatedSchedule.getDepartureTime() != null)
            existingSchedule.setDepartureTime(updatedSchedule.getDepartureTime());

        if (updatedSchedule.getArrivalTime() != null)
            existingSchedule.setArrivalTime(updatedSchedule.getArrivalTime());

        if (updatedSchedule.getAvailableSeats() != 0)
            existingSchedule.setAvailableSeats(updatedSchedule.getAvailableSeats());

        if (updatedSchedule.getBaseFare() != 0)
            existingSchedule.setBaseFare(updatedSchedule.getBaseFare());

        if (updatedSchedule.getBus() != null)
            existingSchedule.setBus(updatedSchedule.getBus());

        if (updatedSchedule.getBusRoute() != null)
            existingSchedule.setBusRoute(updatedSchedule.getBusRoute());

        return scheduleRepository.save(existingSchedule);
    }

    // Delete schedule
    public void deleteSchedule(int id) {
        Schedule schedule = getScheduleById(id);
        scheduleRepository.delete(schedule);
    }
}
