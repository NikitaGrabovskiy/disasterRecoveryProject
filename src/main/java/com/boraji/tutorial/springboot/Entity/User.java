package com.boraji.tutorial.springboot.Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "usr_name")
	private String name;
	
	@Column(name = "usr_role")
	private String usr_role;
	
	@Column(name = "pass")
	private String pass;

	public User(String usr_name, String usr_role, String pass) {
		super();
		this.name = usr_name;
		this.usr_role = usr_role;
		this.pass = pass;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getUsr_role() {
		return usr_role;
	}

	public void setUsr_role(String usr_role) {
		this.usr_role = usr_role;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public User() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
	
	
	

}
