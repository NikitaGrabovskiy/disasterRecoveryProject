package com.boraji.tutorial.springboot.Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="timesheet")
public class Timesheet implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "site_code")
	private String site_code;
	
	@Column(name = "contractor_name")
	private String contractor_name;

	@Column(name = "total_hours")
	private double total_hours;
	
	@Column(name = "total_amount")
	private double total_amount;
	
	@Column(name = "finalized")
	private boolean finalized;

	public String getSite_code() {
		return site_code;
	}

	public void setSite_code(String site_code) {
		this.site_code = site_code;
	}

	public String getContractor_name() {
		return contractor_name;
	}

	public void setContractor_name(String contractor_name) {
		this.contractor_name = contractor_name;
	}

	public double getTotal_hours() {
		return total_hours;
	}

	public void setTotal_hours(double total_hours) {
		this.total_hours = total_hours;
	}

	public double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}

	public Timesheet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isFinalized() {
		return finalized;
	}

	public void setFinalized(boolean finalized) {
		this.finalized = finalized;
	}

	public Timesheet(String site_code, String contractor_name, double total_hours, double total_amount,
			boolean finalized) {
		super();
		this.site_code = site_code;
		this.contractor_name = contractor_name;
		this.total_hours = total_hours;
		this.total_amount = total_amount;
		this.finalized = finalized;
	}

	
	
}
