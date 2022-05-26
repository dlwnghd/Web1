package com.example.calc;

public class Calc {
	
	private int num1;
	private int num2;
	
	public Calc() {;}
	
	public Calc(int num1, int num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
	}

	//덧셈
	public int add() {return num1 + num2;}
	//뺄셈
	public int sub() {return num1 - num2;}
	//곱셈
	public int mul() {return num1 * num2;}
	//나눗셈
	public int div() {return num1 / num2;}
}
