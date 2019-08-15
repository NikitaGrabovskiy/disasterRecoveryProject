package com.boraji.tutorial.springboot.Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "job_mng")
public class Job implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@Column(name = "job_code")
	private String job_code;

	@Column(name = "j_desc")
	private String j_desc;

	@Column(name = "hourly_rate")
	private double hourly_rate;

	@Column(name = "max_hours")
	private double max_hours;

	public String getJ_desc() {
		return j_desc;
	}

	public void setJ_desc(String j_desc) {
		this.j_desc = j_desc;
	}

	public double getHourly_rate() {
		return hourly_rate;
	}

	public void setHourly_rate(double hourly_rate) {
		this.hourly_rate = hourly_rate;
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

	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Job(String job_code, String j_desc, double hourly_rate, double max_hours) {
		super();
		this.job_code = job_code;
		this.j_desc = j_desc;
		this.hourly_rate = hourly_rate;
		this.max_hours = max_hours;
	}

	public String getJob_code() {
		return job_code;
	}

	public void setJob_code(String job_code) {
		this.job_code = job_code;
	}

}
