package com.backend.fastx.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.fastx.model.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

	Optional<Schedule> findActiveScheduleByBusId(int id);
}
