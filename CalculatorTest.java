package git.Calculator;

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
	public void when_calculating_1_plus_1_plus_2_should_return_4() {
		Double result = calculator.calculate("1+1+2");
		assertEquals(new Double(4), result);
	}
	
	@Test
	public void when_calculating_1_plus_1_plus_2_minus_4_should_return_0() {
		Double result = calculator.calculate("1+1+2-4");
		assertEquals(new Double(0), result);
	}
	
	@Test
	public void when_calculating_1_multiplies_2_plus_2_multiplies_n8_should_return_n14() {
		Double result = calculator.calculate("1*2+2*-8");
		assertEquals(new Double(-14), result);
	}
	
	@Test
	public void when_calculating_1_multiplies_2_plus_2_multiplies_n8_should_return_n() {
		Double result = calculator.calculate("3-1*16/8+6+2^2");
		assertEquals(new Double(11), result);
	}

}
