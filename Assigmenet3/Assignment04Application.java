package com.sunbeam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class Assignment04Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Assignment04Application.class, args);
	}
	
	@Qualifier()
  @Autowired
  private Values val;
	
	@Override
	public void run(String... args) throws Exception {
    val.sendValue();
	//	valuess.setsValue(100);
		
	}


	
	
}
