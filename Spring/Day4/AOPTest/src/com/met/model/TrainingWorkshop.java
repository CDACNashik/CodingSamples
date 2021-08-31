package com.met.model;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*<bean id="trainingWorkshop" class="com.met.model.TrainingWorkshop" autowire="byType">*/

@Component
public class TrainingWorkshop implements Workshop {			//TrainingWorkshop -> trainingWorkshop

	@Autowired
	private TrainingCompany trainingCompany;
	
	@Autowired(required=false)
	private DataSource dataSource;
	
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
