package tech.rohitshah1706.calculator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CalculatorApplicationTests {

	Calculator calculator = new Calculator();

	@Test
	public void testAdd() {
		assertEquals(5, calculator.add(2, 3));
	}

	@Test
	public void testSubtract() {
		assertEquals(1, calculator.subtract(3, 2));
	}

	@Test
	public void testMultiply() {
		assertEquals(6, calculator.multiply(2, 3));
	}

	@Test
	public void testDivide() {
		assertEquals(2, calculator.divide(4, 2));
	}

	@Test
	public void testDivideByZero() {
		Exception exception = assertThrows(ArithmeticException.class, () -> {
			calculator.divide(4, 0);
		});

		assertEquals("Division by zero is not allowed", exception.getMessage());
	}

}
