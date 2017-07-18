package com.app.calculator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
	
	private Calculator calculator;
		
	@Before
	public void setUp() {
		calculator = new Calculator();
	}
	@Test
	public void when_calculating_empty_string_should_return_0() {
		// Method you are testing
		Double result = calculator.calculate("");
		// Result you expect
		assertEquals(new Double(0), result);
	}

	@Test
	public void when_calculating_string_one_should_return_1() {
		Double result = calculator.calculate("1");
		assertEquals(new Double(1), result);
	}
	
	@Test
	public void when_calculating_2_minus_1_should_return_1() {
		Double result = calculator.calculate("2-1");
		assertEquals(new Double(1), result);
	}
	
	@Test
	public void when_calculating_2_multiplies_4_should_return_8() {
		Double result = calculator.calculate("2*4");
		assertEquals(new Double(8), result);
	}

}

