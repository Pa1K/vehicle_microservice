package com.pavan.vehicle_microservice.model;

import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


public class Govt {
	

	private String number;
	private String violation;
	private Date violation_date;
	private int penalty;
	
	
	public Govt() { }


	public Govt(String violation, Date violation_date, int penalty) {
		this.violation = violation;
		this.violation_date = violation_date;
		this.penalty = penalty;
	}


	@Override
	public String toString() {
		return "Govt [number=" + number + ", violation=" + violation + ", violation_date=" + violation_date
				+ ", penalty=" + penalty + "]";
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getViolation() {
		return violation;
	}


	public void setViolation(String violation) {
		this.violation = violation;
	}


	public Date getViolation_Date() {
		return violation_date;
	}


	public void setViolation_Date(Date violation_Date) {
		this.violation_date = violation_Date;
	}


	public int getPenalty() {
		return penalty;
	}


	public void setPenalty(int penalty) {
		this.penalty = penalty;
	}
	

	
	
}
