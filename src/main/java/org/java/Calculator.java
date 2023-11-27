package org.java;

import org.java.exceptions.InvalidDivisionException;

public class Calculator {
	
	public Calculator() {}
	
	public float add(float num1, float num2) {
		return num1 + num2;
	}
	
	public float sub(float num1, float num2) {
		return num1 - num2;
	}
	
	public float mul(float num1, float num2) {
		return num1 * num2;
	}
	
	public float div(float num1, float num2) throws InvalidDivisionException {
		if (num2 == 0) {
			throw new InvalidDivisionException("You must not divide by 0");
		}
		return num1 / num2;
	}
}
