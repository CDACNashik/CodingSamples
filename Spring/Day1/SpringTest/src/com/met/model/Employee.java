package com.met.model;

public class Employee {

	private int id;
	private String name;
	private String designation;
	private String emailId;
	private double salary = 12000;
	
	private static int count=0;
	
	public Employee(){
		
		id = ++count;
		System.out.println("Default Employee Object created with id: " + id);
		
	}

	public Employee(String name, String emailId){			//constructor arguements
		
		this();
		this.name = name;
		this.emailId = emailId;
		this.designation = "FRESHER";
		System.out.println("Parameterized Employee object created with id: " + id);
	}
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getId() {
		return id;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", designation=" + designation + ", emailId=" + emailId
				+ ", salary=" + salary + "]";
	}

	public double getAnnualIncome(){
		return salary * 12;
	}
}
