package com.met.model;

import java.util.List;
import java.util.Random;

public class JavaTrainer implements Trainer {

	private String name;
	private List<String> subjects;

	public JavaTrainer() {
		
		System.out.println("Default JavaTrainer Object created...");
	}

	public JavaTrainer(String name, List<String> subjects) {
		super();
		this.name = name;
		this.subjects = subjects;
		System.out.println("Parameterized JavaTrainer Object created...");
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
		
		//System.out.println("participants should take seats");
		
		//System.out.println("participants should join Zoom meeting");
		
		//System.out.println("participants should switch off mobile phones");
		
		Random random = new Random();
		int no = random.nextInt(10);
		
		if(no < 5){
			throw new RuntimeException();
		}
		
		
		System.out.println(name + " is teaching on java subjects " + subjects);			// Business logic

		//System.out.println("Training completed");
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + " is a JavaTrainer";
	}

}
