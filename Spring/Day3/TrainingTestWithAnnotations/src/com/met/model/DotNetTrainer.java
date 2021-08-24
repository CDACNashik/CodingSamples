package com.met.model;

import java.util.List;

public class DotNetTrainer implements Trainer {

	private String name;
	private List<String> subjects;

	public DotNetTrainer() {
		
		System.out.println("Default DotNetTrainer Object created...");
	}

	public DotNetTrainer(String name, List<String> subjects) {
		super();
		this.name = name;
		this.subjects = subjects;
		System.out.println("Parameterized DotNetTrainer Object created...");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}

	@Override
	public void train() {
		
		System.out.println(name + " is teaching on DotNet subjects " + subjects);

	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + " is a DotNetTrainer";
	}

}
