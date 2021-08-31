package com.met.spring.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.met.config.JavaConfiguration;
import com.met.model.JavaDotNetTrainer;
import com.met.model.Trainer;
import com.met.model.TrainingCompany;
import com.met.model.Workshop;

public class SpringTrainingTest {

	public static void main(String[] args) {
		
		/*ApplicationContext context = new ClassPathXmlApplicationContext("training.xml");
		context.close();*/
		
		//try(AbstractApplicationContext context = new ClassPathXmlApplicationContext("training.xml")){
		
		
		try(AbstractApplicationContext context = new AnnotationConfigApplicationContext(JavaConfiguration.class)){
			
			System.out.println("*************************Spring container initialization completed *************");
			
			/*JavaTrainer javaTrainer = context.getBean("javaTrainer", JavaTrainer.class);
			javaTrainer.train();*/
			
			Trainer javaTrainer = context.getBean("javaTrainer", Trainer.class);
			
			System.out.println("Bean with id javaTrainer " + javaTrainer.getClass());
			
			//javaTrainer.train();
			
			//TrainingCompany trainingCompany = context.getBean(TrainingCompany.class);
			
			TrainingCompany trainingCompany = context.getBean("metSolutions", TrainingCompany.class);
			//trainingCompany.conductTraining();
			
			
			Workshop trainingWorkshop = context.getBean(Workshop.class);
			trainingWorkshop.conductWorkshop();
			
			JavaDotNetTrainer javaDotNetTrainer = context.getBean(JavaDotNetTrainer.class);
			javaDotNetTrainer.train();
			System.out.println("Bean with id javaDotNetTrainer " + javaDotNetTrainer.getClass());
			
		}
	}
	
}

