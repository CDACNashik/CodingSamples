package com.met.nonspring.test;

import java.util.LinkedList;
import java.util.List;

import com.met.model.JavaTrainer;
import com.met.model.MetSolutions;
import com.met.model.TrainingWorkshop;

public class NonSpringTrainingTest {

	
	public static void main(String[] args) {
		
		/*JavaTrainer javaTrainer = new JavaTrainer();
		javaTrainer.setName("Ramesh");
		
		List<String> listSubjects = new LinkedList<>();
		listSubjects.add("OOPS");
		listSubjects.add("JDBC");
		listSubjects.add("Streams");
		
		listSubjects.add("Collections");*/
		
		JavaTrainer javaTrainer1 = new JavaTrainer();
		javaTrainer1.setName("Ram");
		
		List<String> listSubjects = new LinkedList<>();
		listSubjects.add("OOPS");
		listSubjects.add("JDBC");
		listSubjects.add("Streams");
		
		listSubjects.add("Collections");
		
		javaTrainer1.setSubjects(listSubjects);
		
		
		MetSolutions metSolutions = new MetSolutions(javaTrainer1);
		//metSolutions.conductTraining();
		
		
		TrainingWorkshop workshop = new TrainingWorkshop();
		workshop.setTrainingCompany(metSolutions);

		workshop.conductWorkshop();
		
		
		
		
	}
	
	
}
