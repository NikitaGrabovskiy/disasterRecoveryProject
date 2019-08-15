package com.boraji.tutorial.springboot.Entity;

public class MachineEntry {

	private String code;

	private double hoursUsed;

	private double totalAmount;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setHoursUsed(int hoursUsed) {
		this.hoursUsed = hoursUsed;
	}

	public MachineEntry(String code, int hoursUsed) {
		super();
		this.code = code;
		this.hoursUsed = hoursUsed;
	}

	public MachineEntry() {
		super();
	}

	public double getHoursUsed() {
		return hoursUsed;
	}

	public void setHoursUsed(double hoursUsed) {
		this.hoursUsed = hoursUsed;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

}
