package com.mm.android.lc;


public class Calculator {

	public double add(double num1, double num2) {
		return num1 + num2;
	}

	public double minus(double num1, double num2) {
		return num1 - num2;
	}

	public double multiply(double num1, double num2) {
		// 死循环，模拟超时
		int i = 0;
		while (true) {
			i++;
		}
		
	}

	public double division(double num1, double num2) {
		if(0.0 == num2){
			throw new ArithmeticException("被除数不能为0");
		}else{
			return num1 / num2;
		}
		
	}
}