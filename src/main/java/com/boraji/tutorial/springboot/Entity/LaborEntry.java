package com.boraji.tutorial.springboot.Entity;

public class LaborEntry {

	private String code;

	private double hoursWorked;

	private double totalAmount;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setHoursWorked(int hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	public LaborEntry(String code, int hoursWorked) {
		super();
		this.code = code;
		this.hoursWorked = hoursWorked;
	}

	public LaborEntry() {
		super();
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public void setHoursWorked(double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	public double getHoursWorked() {
		return hoursWorked;
	}

}
