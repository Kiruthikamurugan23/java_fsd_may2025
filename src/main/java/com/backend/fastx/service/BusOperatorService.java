package com.backend.fastx.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.fastx.dto.BusOperatorDto;
import com.backend.fastx.model.BusOperator;
import com.backend.fastx.model.User;
import com.backend.fastx.repository.BusOperatorRepository;
@Service
public class BusOperatorService {
    
     private BusOperatorRepository busOperatorRepository;
	 private UserService userService; 
	 
	
    public BusOperatorService(BusOperatorRepository busOperatorRepository, UserService userService) {
		super();
		this.busOperatorRepository = busOperatorRepository;
		this.userService = userService;
	}

	public List<BusOperator>findAll() {
		
		return busOperatorRepository.findAll();
	}

	public BusOperator save(BusOperator busOperator, int userId) {
	    User user = userService.getById(userId); // this must exist
	    if (user == null) {
	        throw new RuntimeException("User not found with ID: " + userId);
	    }
	    user.setRole("BUSOPERATOR");
	    busOperator.setUser(user);
	    return busOperatorRepository.save(busOperator);
	}

	public BusOperator createBusOperator(BusOperatorDto dto) {
	    User user = userService.getUserById(dto.getUserId());
	    if (user == null) {
	        throw new RuntimeException("User not found");
	    }

	    user.setRole("BUSOPERATOR");
	    userService.updateUser(user);

	    BusOperator operator = new BusOperator();
	    operator.setName(dto.getName());
	    operator.setContact(dto.getContact());
	    operator.setEmail(dto.getEmail());
	    operator.setCompany(dto.getCompany());
	    operator.setCompanyAddress(dto.getCompanyAddress());
	    operator.setUser(user);  // Set the full User entity

	    return busOperatorRepository.save(operator);
	}

	

		
	}




