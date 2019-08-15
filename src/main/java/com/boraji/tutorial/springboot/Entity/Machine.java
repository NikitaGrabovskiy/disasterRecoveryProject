package com.boraji.tutorial.springboot.Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "machine_mng")
public class Machine implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@Column(name = "mach_code")
	private String mach_code;

	@Column(name = "mach_desc")
	private String mach_desc;

	@Column(name = "hourly_rent")
	private double hourly_rent;

	@Column(name = "max_hours")
	private double max_hours;

	public Machine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMach_code() {
		return mach_code;
	}

	public void setMach_code(String mach_code) {
		this.mach_code = mach_code;
	}

	public String getMach_desc() {
		return mach_desc;
	}

	public void setMach_desc(String mach_desc) {
		this.mach_desc = mach_desc;
	}

	public double getHourly_rent() {
		return hourly_rent;
	}

	public void setHourly_rent(double hourly_rent) {
		this.hourly_rent = hourly_rent;
	}

	public double getMax_hours() {
		return max_hours;
	}

	public void setMax_hours(double max_hours) {
		this.max_hours = max_hours;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Machine(String mach_code, String mach_desc, double hourly_rent, double max_hours) {
		super();
		this.mach_code = mach_code;
		this.mach_desc = mach_desc;
		this.hourly_rent = hourly_rent;
		this.max_hours = max_hours;
	}

}
