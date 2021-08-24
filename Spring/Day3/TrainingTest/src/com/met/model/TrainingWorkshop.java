package com.met.model;

public class TrainingWorkshop implements Workshop {

	private TrainingCompany trainingCompany;
	
	public TrainingCompany getTrainingCompany() {
		return trainingCompany;
	}

	public void setTrainingCompany(TrainingCompany trainingCompany) {
		this.trainingCompany = trainingCompany;
	}

	public TrainingWorkshop() {
		super();
		System.out.println("Default TrainingWorkshop object created...");
	}

	public TrainingWorkshop(TrainingCompany trainingCompany) {
		super();
		this.trainingCompany = trainingCompany;
		System.out.println("Parameterized TrainingWorkshop object created...");
	}

	@Override
	public void conductWorkshop() {
		System.out.println("TrainingWorkshop :: conductWorkshop" );
		trainingCompany.conductTraining();

	}
	
	

}
