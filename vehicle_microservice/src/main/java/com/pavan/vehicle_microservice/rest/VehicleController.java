package com.pavan.vehicle_microservice.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.pavan.vehicle_microservice.model.Govt;
import com.pavan.vehicle_microservice.model.Vehicle;
import com.pavan.vehicle_microservice.service.VehicleService;

@RestController
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	
	@RequestMapping("/vehicles")
	private List<Vehicle> getAllVehicles() {
		return vehicleService.getAllVechicles();
		
	}
	
	@RequestMapping("/vehicles/{number}")
	private Vehicle getAllVehicles(@PathVariable String number) {
		return vehicleService.getVehicle(number).orElseGet(() -> new Vehicle());
		
	}
	
	@RequestMapping("/vehicles/signal")
	private List<Vehicle> vehiclesAtSignal(@RequestParam Boolean signal) {
		
		 List<Vehicle>  vehiclesAtSignal = vehicleService.vehiclesAtSignal(signal);
		 
		 RestTemplate rt = new RestTemplate(); 
		 
			
			  List<Govt> vehiclesPenaltyDetails = vehiclesAtSignal.stream().map(
					  		vehicleAtSignal ->  rt.getForObject("http://localhost:8081/govt/"+vehicleAtSignal.getNumber(), Govt.class))
					  		.filter(e -> e.getNumber()!=null). collect(Collectors.toList());
			 
		 
			
			  //System.out.println("vehiclesAtSignal "+vehiclesAtSignal.toString());
			  //System.out.println("vehiclePenaltyDetails "+vehiclesPenaltyDetails.toString());
			 

			  
			  
			//System.out.println("vehiclesAtSignalWithPenalty "+vehiclesAtSignalWithPenalty.toString());
			  
			 List<String> penaltyVehicleNumbers=vehiclesPenaltyDetails.stream().map(Govt::getNumber).collect(Collectors.toList());
			 List<Vehicle> vehiclesAtSignalWithPenalty =  vehiclesAtSignal.stream().filter(e->penaltyVehicleNumbers.contains(e.getNumber())).collect(Collectors.toList());

			 //System.out.println("vehiclesAtSignalWithPenalty "+vehiclesAtSignalWithPenalty.toString());
			 
			 StringBuilder AllDetails = new StringBuilder();
			 
			 for(int i=0;i<penaltyVehicleNumbers.size();i++) {
				 AllDetails.append(vehiclesAtSignalWithPenalty.get(i).toString() + " "+ vehiclesPenaltyDetails.get(i).toString()+"\n");
			 }

			
			 
			//String AllDetails = vehiclesPenaltyDetails.toString()+vehiclesAtSignalWithPenalty.toString();
			
			 rt.getForObject("http://localhost:8082/sendmail?body="+AllDetails.toString(), String.class);
			 
			
		 return vehiclesAtSignal;
	}
	
	

}
