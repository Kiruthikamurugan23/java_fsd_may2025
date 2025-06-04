package com.backend.fastx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.fastx.model.Bus;
import com.backend.fastx.model.BusOperator;
import com.backend.fastx.repository.BusOperatorRepository;
import com.backend.fastx.repository.BusRepository;


@Service
public class BusService {
	 @Autowired
    private final BusRepository busRepository;
    private final BusOperatorRepository busOperatorRepository;

   
    public BusService(BusRepository busRepository, BusOperatorRepository busOperatorRepository) {
        this.busRepository = busRepository;
        this.busOperatorRepository = busOperatorRepository;
    }

    public Bus addBus(Bus bus) {
        if (bus.getBusOperator() != null && bus.getBusOperator().getId() != 0) {
            int operatorId = bus.getBusOperator().getId();
            BusOperator fullOperator = busOperatorRepository.findById(operatorId)
                .orElseThrow(() -> new RuntimeException("BusOperator not found with ID: " + operatorId));
            
            bus.setBusOperator(fullOperator); // Set fully populated operator
        }

        return busRepository.save(bus);
    }

    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }

    public List<Bus> getBusById(int id) {
        return busRepository.getBusById(id);
    }

    public Bus updateBus(int id, Bus updatedBus) {
        Bus existingBus = busRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Bus not found with ID: " + id));

        if (updatedBus.getBusName() != null)
            existingBus.setBusName(updatedBus.getBusName());
        if (updatedBus.getBusNum() != 0)
            existingBus.setBusNum(updatedBus.getBusNum());
        if (updatedBus.getBusType() != null)
            existingBus.setBusType(updatedBus.getBusType());
        if (updatedBus.getBusCapacity() != 0)
            existingBus.setBusCapacity(updatedBus.getBusCapacity());
        if (updatedBus.getAmenities() != null)
            existingBus.setAmenities(updatedBus.getAmenities());

        if (updatedBus.getBusOperator() != null)
            existingBus.setBusOperator(updatedBus.getBusOperator());

        return busRepository.save(existingBus);
    }
}
