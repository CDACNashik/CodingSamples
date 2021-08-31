package com.met.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@EnableAspectJAutoProxy
@Component
/*<bean id="participants" class="com.met.aspect.Participants">*/
public class Participants {

	/*
	 * 1) Any accessfier/modifier public, private, protected, default
	 * 2) Any java class		(JavaTrainer, DOtNetTrainer)
	 * 3) .. -> any number of arguements 
	 * */
	
	@Pointcut("execution(* *.train(..))")
	public void training(){}
	
	
	/*@Before("training()")												//creating DB connection
	public void joinZoom(){
		System.out.println("Participants should join zoom/googlemeet.");
	}
	
	@Before("training()")												//creating prepared statement
	public void switchOffPhones(){
		System.out.println("participants should switch off mobile phones");
	}
	
	@After("training()")												//finally block
	public void trainingCompleted(){
		System.out.println("Training completed");
	}
	
	
	@AfterThrowing("training()")										//exception handling rollback tx
	public void trainingFailure(){
		System.out.println("Training failure");
	}
	
		
	@AfterReturning("training()")										//commit tx
	public void trainingSuccess(){
		System.out.println("Training completed successfully..");
	}*/
	
	
	@Around("training()")				//Spring framework uses @Around advice for tx management
	public void aroundTraining(ProceedingJoinPoint pjp){
		
		
		try{
			System.out.println("Participants should join zoom/googlemeet.");
			System.out.println("participants should switch off mobile phones");
			
			//invoke busines logic
			pjp.proceed();
			
			
			System.out.println("Training completed successfully..");
			
		}catch(Throwable th){
			System.out.println("Training failure");
		}finally{
			System.out.println("Training completed");
		}
		
		
	}
	
}










