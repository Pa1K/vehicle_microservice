package com.pavan.vehicle_microservice.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pavan.vehicle_microservice.model.Vehicle;

@Repository
public interface VechicleRepository extends JpaRepository<Vehicle, String> {

	List<Vehicle> findBySignal(Boolean signal);

}
