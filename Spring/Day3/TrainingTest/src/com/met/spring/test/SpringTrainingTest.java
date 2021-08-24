package com.met.spring.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.met.model.JavaTrainer;
import com.met.model.Trainer;
import com.met.model.TrainingCompany;
import com.met.model.Workshop;

public class SpringTrainingTest {

	public static void main(String[] args) {
		
		/*ApplicationContext context = new ClassPathXmlApplicationContext("training.xml");
		context.close();*/
		
		try(AbstractApplicationContext context = new ClassPathXmlApplicationContext("training.xml")){
			
			System.out.println("*************************Spring container initialization completed *************");
			
			/*JavaTrainer javaTrainer = context.getBean("javaTrainer", JavaTrainer.class);
			javaTrainer.train();*/
			
			Trainer javaTrainer = context.getBean("javaTrainer", Trainer.class);
			//javaTrainer.train();
			
			//TrainingCompany trainingCompany = context.getBean(TrainingCompany.class);
			
			TrainingCompany trainingCompany = context.getBean("metSolutions", TrainingCompany.class);
			//trainingCompany.conductTraining();
			
			
			Workshop trainingWorkshop = context.getBean(Workshop.class);
			trainingWorkshop.conductWorkshop();
			
		}
	}
	
}

