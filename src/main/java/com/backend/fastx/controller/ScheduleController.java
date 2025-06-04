package com.backend.fastx.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.fastx.model.Schedule;
import com.backend.fastx.service.ScheduleService;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping("/create")
    public Schedule createSchedule(@RequestBody Schedule schedule) {
        return scheduleService.createSchedule(schedule);
    }

    @GetMapping
    public List<Schedule> getAllSchedules() {
        return scheduleService.getAllSchedules();
    }

    @GetMapping("/{id}")
    public Schedule getScheduleById(@PathVariable int id) {
        return scheduleService.getScheduleById(id);
    }

    @PutMapping("/{id}")
    public Schedule updateSchedule(@PathVariable int id, @RequestBody Schedule updatedSchedule) {
        return scheduleService.updateSchedule(id, updatedSchedule);
    }

    @DeleteMapping("/{id}")
    public void deleteSchedule(@PathVariable int id) {
        scheduleService.deleteSchedule(id);
    }
}

