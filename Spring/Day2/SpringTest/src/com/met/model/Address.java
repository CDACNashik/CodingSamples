package com.met.model;

public class Address {

	private String id;			//A1 A2
	private String city;
	private String country;
	
	private static int count = 0;
	
	public Address(){
		id = "A" + ++count;			//A1
		System.out.println("Default Address object created with id: " + id) ;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", city=" + city + ", country=" + country + "]";
	}
	
	
	
}
