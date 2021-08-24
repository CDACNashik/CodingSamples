package com.met.model;

public class MetSolutions implements TrainingCompany {
	
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
	
	public MetSolutions(Trainer trainer) {
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
	
}
