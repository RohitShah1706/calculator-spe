package tech.rohitshah1706.calculator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CalculatorApplicationTests {
	private Calculator calculator = new Calculator();

	@Test
	void testSquareRoot() {
		assertEquals(3.0, calculator.squareRoot(9));
	}

	@Test
	void testFactorial() {
		assertEquals(120, calculator.factorial(5));
	}

	@Test
	void testNaturalLogarithm() {
		assertEquals(1.6094379124341003, calculator.naturalLogarithm(5));
	}

	@Test
	void testPower() {
		assertEquals(32.0, calculator.power(2, 5));
	}

	@Test
	void testSquareRootNegative() {
		assertThrows(ArithmeticException.class, () -> calculator.squareRoot(-9));
	}

	@Test
	void testFactorialNegative() {
		assertThrows(ArithmeticException.class, () -> calculator.factorial(-5));
	}

	@Test
	void testNaturalLogarithmNonPositive() {
		assertThrows(ArithmeticException.class, () -> calculator.naturalLogarithm(0));
	}

	@Test
	void testPowerZero() {
		assertEquals(1.0, calculator.power(2, 0));
	}
}
