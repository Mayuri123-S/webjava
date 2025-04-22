package com.sunbeam.dmc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArithConfig {

	@Bean
	public Arithmetic a1() {
		Arithmetic a1 = new Arithmetic();
		a1.setNum1(22);
		a1.setNum2(7);
		return a1;
		
		
	}
	
	//Constructor based di
	@Bean
	public Arithmetic a2() {
		Arithmetic a2 = new Arithmetic(22, 7);
		return a2;
	}
	
	

}
