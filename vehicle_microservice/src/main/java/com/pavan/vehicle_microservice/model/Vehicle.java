package com.pavan.vehicle_microservice.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Vehicle {
	
	@Override
	public String toString() {
		return "Vehicle [number=" + number + ", owner=" + owner + ", purchasedDate=" + purchasedDate + ", color="
				+ color + ", make=" + make + ", signal=" + signal + "]";
	}
	@Id
	@GeneratedValue
	private String number;
	private String owner;
	private Date purchasedDate;
	private String color;
	private String make;
	private Boolean signal;
	
	
	public Vehicle() {
		
	}
	
	
	public Vehicle(String owner, Date purchasedDate, String color, String make, Boolean signal) {
		this.owner = owner;
		this.purchasedDate = purchasedDate;
		this.color = color;
		this.make = make;
		this.signal = signal;
	}


	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public Date getPurchasedDate() {
		return purchasedDate;
	}
	public void setPurchasedDate(Date purchasedDate) {
		this.purchasedDate = purchasedDate;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public Boolean getSignal() {
		return signal;
	}
	public void setSignal(Boolean signal) {
		this.signal = signal;
	}
	
	
	
}
