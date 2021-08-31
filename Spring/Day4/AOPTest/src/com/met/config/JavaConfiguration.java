package com.met.config;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.met.model.DotNetTrainer;
import com.met.model.JavaDotNetTrainer;
import com.met.model.JavaTrainer;
import com.met.model.Trainer;

@Configuration			//<beans
@ComponentScan(basePackages="com.met.model, com.met.aspect")		//<context:component-scan base-package="com.met.model"></context:component-scan>

//@ComponentScan(basePackages="com.met.*")

@PropertySource("classpath:app.properties")
public class JavaConfiguration {

	
	/*<bean id="javaTrainer" class="com.met.model.JavaTrainer">
	<property name="name" value="Ram"></property>
	<property name="subjects">
		<list>
			<value>OOPS</value>
			<value>JDBC</value>
			<value>Streams</value>
			<value>Collections</value>
		</list>
	</property>
</bean>*/
	
	@Value("${trainer1.name}")							//${}
	private String javaTrainer1Name;
	
	@Value("#{${trainer1.subjects}}")
	private List<String> javaTrainer1Subjects;
	
	
	@Value("${dotNetTrainer.name}")							//${}
	private String dotNetTrainer1Name;
	
	@Value("#{${dotNetTrainer.subjects}}")
	private List<String> dotNetSubjects;
	
	@Value("${javaDotNetTrainer.name}")
	private String javaDotNetTrainerName;
	
	@Value("#{${javaDotNetTrainer.subjects}}")
	private List<String> javaDotNetTrainerSubjects;
	
	
	
	
	@Bean
	/*<bean id="javaTrainer" class="com.met.model.JavaTrainer">*/
	public Trainer javaTrainer(){						//name of function is id="javaTrainer"
		/*JavaTrainer javaTrainer = new JavaTrainer();
		javaTrainer.setName("Ram");
		
		List<String> subjects = new LinkedList<>();
		subjects.add("OOPS");
		subjects.add("JDBC");
		subjects.add("Streams");
		subjects.add("Collections");
		
		javaTrainer.setSubjects(subjects);*/
		
		
		JavaTrainer javaTrainer = new JavaTrainer();
		javaTrainer.setName(javaTrainer1Name);
		javaTrainer.setSubjects(javaTrainer1Subjects);
		
		return javaTrainer;
		
	}
	
	/*<bean id="javaTrainer2" class="com.met.model.JavaTrainer" >   <!-- primary="true" -->
	<property name="name" value="Ramesh"></property>
	<property name="subjects">
		<list>
			<value>JSP</value>
			<value>SERVLETS</value>
			<value>HIBERNATE</value>
			<value>RMI</value>
		</list>
	</property>
</bean>*/
	
	
	@Bean("javaTrainer2")
	/*@Scope("prototype")
	@Lazy*/
	//@Primary
	//<bean id="createJavaTrainer" class="com.met.model.JavaTrainer" >  
	//id="javaTrainer2"
	public Trainer createJavaTrainer(){
		
		List<String> subjects = new LinkedList<>();
		subjects.add("JSP");
		subjects.add("SERVLETS");
		subjects.add("HIBERNATE");
		subjects.add("RMI");
		
		
		
		Trainer javaTrainer = new JavaTrainer("Ramesh", subjects);
		
		return javaTrainer;
		
		
	}
	
	
	/*<bean id="dotNetTrainer" class="com.met.model.DotNetTrainer">
		<property name="name" value="Deepak"></property>
	<property name="subjects">
		<list>
			<value>REMOTING</value>
			<value>MVC</value>
			<value>WEBSERVICES</value>
			<value>ASP.NET</value>
		</list>
	</property>
	</bean>*/
	
	@Bean
	public Trainer dotNetTrainer(){
		
		DotNetTrainer trainer = new DotNetTrainer();
		
		/*List<String> subjects = new LinkedList<>();
		subjects.add("REMOTING");
		subjects.add("MVC");
		subjects.add("WEBSERVICES");
		subjects.add("ASP.NET");
		
		
		trainer.setName("Deepak");
		trainer.setSubjects(subjects);*/
		
		
		trainer.setName(dotNetTrainer1Name);
		trainer.setSubjects(dotNetSubjects);
		
		
		return trainer;
	}
	
	
	@Bean
	public 	JavaDotNetTrainer javaDotNetTrainer(){
		
		JavaDotNetTrainer javaDotNetTrainer = new JavaDotNetTrainer(javaDotNetTrainerName, javaDotNetTrainerSubjects);
		
		
		return javaDotNetTrainer;
	}

	
	
}



