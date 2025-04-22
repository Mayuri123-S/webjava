package com.sunbeam;

import org.springframework.stereotype.Component;

@Component
public class UDPSender implements Sender {

	@Override
	public void send(double value) {
	
		System.out.println("TCP protocol"+value);
		
		
		
	}

	
	
	
}
