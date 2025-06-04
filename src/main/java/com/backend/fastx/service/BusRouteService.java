package com.backend.fastx.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.fastx.model.BusRoute;
import com.backend.fastx.repository.BusRouteRepository;

@Service
public class BusRouteService {

    @Autowired
    private BusRouteRepository busRouteRepository;

    public BusRoute addBusRoute(BusRoute busRoute) {
        return busRouteRepository.save(busRoute);
    }

	public List<BusRoute> getBusRoute(BusRoute busRoute) {		
		return busRouteRepository.findAll(); 
	}

	public BusRoute getBusRouteById(int id) {
		// TODO Auto-generated method stub
		return busRouteRepository.findById(id).orElseThrow(()->new RuntimeException("Bus Route NOt Found"+id));
	}
}
