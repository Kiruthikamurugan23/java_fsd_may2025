package com.backend.fastx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.backend.fastx.model.Bus;

public interface BusRepository extends JpaRepository<Bus, Integer>  {

	@Query("select b from Bus b where b.id = ?1")
	List<Bus> getBusById(int id);


}
