package com.met.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/*<bean id="metSolutions" class="com.met.model.MetSolutions"  autowire="constructor">*/

@Component  		//<bean id="metSolutions" class="com.met.model.MetSolutions"
public class MetSolutions implements TrainingCompany {
/*	
	private Trainer trainer;
	
	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public MetSolutions() {
		super();
		System.out.println("Default METSolutions object created..");
	}
	
	@Autowired
	public MetSolutions(@Qualifier("javaTrainer") Trainer trainer) {						//primary=true
		super();	
		this.trainer = trainer;
		System.out.println("Parameterized METSolutions object created..");
	}

	@Override
	public void conductTraining() {
		System.out.println("MetSolutions :: conductTraining");
		trainer.train();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "METSolutions is a TrainingCompany";
	}
	*/
	
	
	
	private List<Trainer> trainers;

	public List<Trainer> getTrainers() {
		return trainers;
	}

	public void setTrainers(List<Trainer> trainers) {
		this.trainers = trainers;
	}

	public MetSolutions() {
		super();
		System.out.println("Default METSolutions object created..");
	}
	
	@Autowired
	public MetSolutions(List<Trainer> trainers) {
		super();
		this.trainers = trainers;
		System.out.println("Parameterized constructor of METSOlutions invoked");
	}


	@Override
	public void conductTraining() {
		System.out.println("MetSolutions :: conductTraining");
		
		for(Trainer trainer : trainers)
		{
			trainer.train();
		}
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "METSolutions is a TrainingCompany";
	}
	
}
