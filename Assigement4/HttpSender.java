package com.sunbeam;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Primary
@Component
public class HttpSender implements Sender {

	@Override
	public void send(double value) {
		System.out.println("Http SENDER : "+ value);
		
	}

}
