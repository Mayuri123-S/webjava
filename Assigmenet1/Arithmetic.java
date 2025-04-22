package com.sunbeam.dmc;

public class Arithmetic {
	private int num1;
	private int num2;
	
	public Arithmetic() {
		System.out.println("Arithmetic() called..");
		
	}

	public Arithmetic(int num1, int num2) {
		
		this.num1 = num1;
		this.num2 = num2;
	}

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

	@Override
	public String toString() {
		return "Arithmetic [num1=" + num1 + ", num2=" + num2 + "]";
	}
	
	public int add() {
		return this.num1 + this.num2;
	}
	
	public int subtraction() {
		return this.num1 - this.num2;
	}
	
	public int multiply() {
		return this.num1 * this.num2;
	}
	
	public int division() {
		return this.num1 / this.num2;
	}
		

}
