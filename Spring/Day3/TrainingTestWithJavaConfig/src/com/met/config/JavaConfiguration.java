package com.met.config;

import java.util.LinkedList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.met.model.JavaTrainer;
import com.met.model.Trainer;

@Configuration			//<beans
@ComponentScan(basePackages="com.met.model")		//<context:component-scan base-package="com.met.model"></context:component-scan>
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
	
	
	@Bean
	public Trainer javaTrainer(){						//name of function is id="javaTrainer"
		JavaTrainer javaTrainer = new JavaTrainer();
		javaTrainer.setName("Ram");
		
		List<String> subjects = new LinkedList<>();
		subjects.add("OOPS");
		subjects.add("JDBC");
		subjects.add("Streams");
		subjects.add("Collections");
		
		javaTrainer.setSubjects(subjects);
		
		
		return javaTrainer;
		
	}
	
	
	
	
}



