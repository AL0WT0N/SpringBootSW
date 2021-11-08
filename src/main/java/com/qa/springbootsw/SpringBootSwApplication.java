package com.qa.springbootsw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootSwApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootSwApplication.class, args);
		
		Object byName = context.getBean("greeting");
		String byType = context.getBean(String.class);
		String byBoth = context.getBean("greeting", String.class);
		
		System.out.println(byName);
		System.out.println(byType);
		System.out.println(byBoth);
	}

}
