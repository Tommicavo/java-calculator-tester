package org.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.java.exceptions.InvalidDivisionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
	
	private Calculator calculator;
	
	@BeforeEach
	void init() {
		calculator = new Calculator();
	}
	
	@Test
	void testCorrectAdd() {
		float num1 = 1.2F;
		float num2 = 0.9F;
		
		float sum = num1 + num2;
		
		assertEquals(sum, num1 + num2, "Correct sum operation");
	}
	
	@Test
	void testCorrectSub() {
		float num1 = 1.2F;
		float num2 = 0.9F;
		
		float sum = num1 - num2;
		
		assertEquals(sum, num1 - num2, "Correct sub operation");
	}
	
	@Test
	void testCorrectMul() {
		float num1 = 1.2F;
		float num2 = 0.9F;
		
		float sum = num1 * num2;
		
		assertEquals(sum, num1 * num2, "Correct mul operation");
	}
	
	@Test
	void testCorrectDiv() {
		float num1 = 1.2F;
		float num2 = 0.9F;
		
		float sum = num1 / num2;
		
		assertEquals(sum, num1 / num2, "Correct div operation");
	}
	
	@Test
    void testInvalidDiv() {
        float num1 = 1.2F;
        float num2 = 0;

        InvalidDivisionException exception = assertThrows(InvalidDivisionException.class, () -> {
            calculator.div(num1, num2);
        });

        assertEquals("You must not divide by 0", exception.getMessage(), "Exception message is correct");
    }
}
