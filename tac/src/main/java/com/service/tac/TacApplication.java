package com.service.tac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TacApplication {

	public static void main(String[] args) {
		SpringApplication.run(TacApplication.class, args);
	}
	
	/*
	 * @Bean public InternalResourceViewResolver setupViewResolver() {
	 * InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	 * resolver.setPrefix("/WEB-INF/views/"); resolver.setSuffix(".jsp"); return
	 * resolver; }
	 */

}
