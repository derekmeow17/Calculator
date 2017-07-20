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
	public void formula_empty_string_returns_0() {
		// Method you are testing
		Double result = calculator.calculate("");
		// Result you expect
		assertEquals(new Double(0), result);
	}

	@Test
	public void formula_string_1_returns_1() {
		Double result = calculator.calculate("1");
		assertEquals(new Double(1), result);
	}

	@Test
	public void formula_2_minus_1_returns_1() {
		Double result = calculator.calculate("2-1");
		assertEquals(new Double(1), result);
	}

	@Test
	public void formula_1_plus_1_plus_2_returns_4() {
		Double result = calculator.calculate("1+1+2");
		assertEquals(new Double(4), result);
	}

	@Test
	public void formula_1_plus_1_plus_2_minus_4_returns_0() {
		Double result = calculator.calculate("1+1+2-4");
		assertEquals(new Double(0), result);
	}

	@Test
	public void formula_1_plus_1_plus_2_times_4_minus_5_returns_5() {
		Double result = calculator.calculate("1+1+2*4-5");
		assertEquals(new Double(5), result);
	}

	@Test
	public void formula_1_times_2_plus_2_times_n8_returns_n14() {
		Double result = calculator.calculate("1*2+2*-8");
		assertEquals(new Double(-14), result);
	}

	@Test
	public void formula_complex_ODMAS_1_returns_11() {
		Double result = calculator.calculate("3-1*16/8+6+2^2");
		assertEquals(new Double(11), result);
	}

	@Test
	public void formula_complex_ODMAS_2_returns_8() {
		Double result = calculator.calculate("4^3+16/-4*9-20");
		assertEquals(new Double(8), result);
	}

	@Test
	public void formula_complex_BODMAS_1_returns_11() {
		Double result = calculator.calculate("1+(2+3)*4-5*(4/2)");
		assertEquals(new Double(11), result);
	}

	@Test
	public void formula_complex_BODMAS_2_returns_n4() {
		Double result = calculator.calculate("2^(2*4-5)/(-9+5)*2");
		assertEquals(new Double(-4), result);
	}
	
}
