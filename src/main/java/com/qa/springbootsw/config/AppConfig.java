package com.qa.springbootsw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

	@Bean
//	@Scope("prototype")
	public String greeting() {
		return "Hello, world";
	}
	
}
