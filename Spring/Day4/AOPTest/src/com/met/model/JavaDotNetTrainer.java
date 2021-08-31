package com.met.model;

import java.util.List;

public class JavaDotNetTrainer {

	private String name;
	private List<String> subjects;

	public JavaDotNetTrainer() {
		
		System.out.println("Default JavaDotNetTrainer Object created...");
	}

	public JavaDotNetTrainer(String name, List<String> subjects) {
		super();
		this.name = name;
		this.subjects = subjects;
		System.out.println("Parameterized JavaDotNetTrainer Object created...");
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

	public void train() {
		
		//System.out.println("participants should take seats");
		
		//System.out.println("participants should join Zoom meeting");
		
		//System.out.println("participants should switch off mobile phones");
		
		System.out.println(name + " is teaching on JavaDotNetTrainer subjects " + subjects);		// Business logic

		//System.out.println("Training completed");
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + " is a JavaDotNetTrainer";
	}


	
}
