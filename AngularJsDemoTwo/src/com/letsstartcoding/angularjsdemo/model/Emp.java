package com.letsstartcoding.angularjsdemo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="Emp.findAll",query="SELECT e from Emp e")
public class Emp implements Serializable{
	
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	
	public Emp(String designation2, String name2, int salary2) {
		// TODO Auto-generated constructor stub
		this.designation=designation2;
		this.name=name2;
		this.salary=salary2;
	}

	public Emp(long idValue, String designation2, String name2, int salary2) {
		// TODO Auto-generated constructor stub
		        this.id=idValue;
				this.designation=designation2;
				this.name=name2;
				this.salary=salary2;
	}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	private String designation;
	
	private String name;
	
	private int salary;

}
