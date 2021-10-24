package com.pavan.vehicle_microservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pavan.vehicle_microservice.model.Vehicle;
import com.pavan.vehicle_microservice.repo.VechicleRepository;

@Service
public class VehicleService {
	
	@Autowired
	private VechicleRepository vehicleRepository;
	
	public List<Vehicle> getAllVechicles() {
		return vehicleRepository.findAll();
	}

	public List<Vehicle> vehiclesAtSignal(Boolean signal) {
		return vehicleRepository.findBySignal(signal);
	}

	public Optional<Vehicle> getVehicle(String number) {
		return vehicleRepository.findById(number);
	}


}
