package com.backend.fastx.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.fastx.model.BusRoute;

@Repository
public interface BusRouteRepository extends JpaRepository<BusRoute, Integer> {
}
