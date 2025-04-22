package com.sunbeam.dmc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Spring01App {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Arithmetic.class);	
		
		
		Arithmetic a1 = (Arithmetic)ctx.getBean("a1");
		int add = a1.add();
		System.out.println("a1 addition : " +add);
		
		Arithmetic a2 = (Arithmetic) ctx.getBean("a1");
		int sub = a1.subtraction();
		System.out.println("a1 subtraction : " +sub);
		
		Arithmetic a3 = (Arithmetic) ctx.getBean("a1");
		int mul= a1.multiply();
		System.out.println("a1 multiply : " +mul);
		
		Arithmetic a4 = (Arithmetic) ctx.getBean("a1");
		int div = a1.division();
		System.out.println("a1 division : " +div);
		
		
		

	}

}
