package com.met.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.met.model.Address;
import com.met.model.Employee;

public class SpringTest {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("test.xml");
		
		System.out.println("*************************Spring container initialization completed *************");
		
		
		Employee employee = context.getBean("emp", Employee.class);
		
		
		Employee employee2 = context.getBean("emp2", Employee.class);
		
		System.out.println(employee);
		System.out.println(employee.getAnnualIncome());
		
		System.out.println(employee2);
		System.out.println(employee2.getAnnualIncome());
		
		
		Employee employeeSingle = context.getBean("emp", Employee.class);
		Employee employeesingleton = context.getBean("emp", Employee.class);
		
		System.out.println("Spring bean with id emp : " + employeeSingle);
		System.out.println("Spring bean with id emp : " +employeesingleton);
		
		System.out.println();
		System.out.println();
		System.out.println("*************************Prototype object concepts***********************************");
		
		Employee emp3 = context.getBean("emp3", Employee.class);
		System.out.println(emp3);
		
		
		Employee empProto = context.getBean("emp3", Employee.class);
		System.out.println(empProto);
		
		System.out.println("*************************End Prototype object concepts***********************************");
		
		
		Employee emp4 = context.getBean("emp4", Employee.class);
		System.out.println("Employee with bean id emp4: "+emp4);
		System.out.println(emp4.getAnnualIncome());
		
		
		Employee emp5 = context.getBean("emp5", Employee.class);
		System.out.println("Employee with bean id emp5: "+emp5);
		System.out.println(emp5.getAnnualIncome());
		
		
		Employee emp6 = context.getBean("emp6", Employee.class);
		System.out.println("Employee with bean id emp6: "+emp6);
		System.out.println(emp6.getAnnualIncome());
		
		Employee emp7 = context.getBean("emp7", Employee.class);
		System.out.println("Employee with bean id emp7: "+emp7);
		System.out.println(emp7.getAnnualIncome());
		
		
		System.out.println("************************************Lazy init concept*******************");
		
		System.out.println();
		
		Employee emp8 = context.getBean("emp8", Employee.class);
		System.out.println("Employee with bean id emp8: " + emp8);
		System.out.println(emp8.getAnnualIncome());
		
		Employee emp8Singleton = context.getBean("emp8", Employee.class);
		System.out.println("Employee with bean id emp8: " + emp8Singleton);
		System.out.println(emp8Singleton.getAnnualIncome());
		
		System.out.println();
		
		System.out.println("************************************End Lazy init concept*******************");
		
		Address address = context.getBean(Address.class);
		System.out.println("Address bean with id address1: " + address);
		
		
		Employee employye9 = context.getBean("emp9", Employee.class);
		System.out.println("EMployee with bean id emp9 " + employye9);
		
	}
	
}





