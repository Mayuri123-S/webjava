package com.sunbeam;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArithConfig {

	
	@Bean
	
	public ArithmeticPojo arith()
	{
		return new ArithmeticPojo(22,7);
	}
	
	
}
