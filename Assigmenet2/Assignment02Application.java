package com.sunbeam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Assignment02Application {

	public static void main(String[] args) {
		ApplicationContext ctx= SpringApplication.run(Assignment02Application.class, args);
		
	
		ArithmeticPojo a1=(ArithmeticPojo) ctx.getBean("arith");
		
		System.out.println("addition is:"+a1.add());
		System.out.println("subtract is:"+a1.sub());
		System.out.println("multiplication is:"+a1.mul());
		System.out.println("division is:"+a1.div());
		
		
	}

}
