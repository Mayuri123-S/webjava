package com.sunbeam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Values {

	
		
		@Autowired
		private Sender sValue;

		public Sender getsValue() {
			return sValue;
		}

		public void setsValue(Sender sValue) {
			this.sValue = sValue;
			
		}
		public void sendValue() {
			if(sValue != null)
				sValue.send(100.00);
		}

		

	}

	
	

