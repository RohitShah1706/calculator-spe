package tech.rohitshah1706.calculator;

import java.util.Scanner;

public class CalculatorApplication {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		Scanner scanner = new Scanner(System.in);
		boolean exit = false;

		while (!exit) {
			System.out.println("=== Calculator Menu ===");
			System.out.println("1. Square Root");
			System.out.println("2. Factorial");
			System.out.println("3. Natural Logarithm");
			System.out.println("4. Power");
			System.out.println("5. Exit");
			System.out.print("Select an option: ");
			int option = scanner.nextInt();

			if (option == 5) {
				exit = true;
				System.out.println("Exiting...");
			} else {
				switch (option) {
					case 1:
						System.out.print("Enter a number: ");
						int number1 = scanner.nextInt();
						try {
							System.out.println("Square root: " + calculator.squareRoot(number1));
						} catch (ArithmeticException e) {
							System.out.println(e.getMessage());
						}
						break;

					case 2:
						System.out.print("Enter a number: ");
						int number2 = scanner.nextInt();
						try {
							System.out.println("Factorial: " + calculator.factorial(number2));
						} catch (ArithmeticException e) {
							System.out.println(e.getMessage());
						}
						break;

					case 3:
						System.out.print("Enter a number: ");
						int number3 = scanner.nextInt();
						try {
							System.out.println("Natural logarithm: " + calculator.naturalLogarithm(number3));
						} catch (ArithmeticException e) {
							System.out.println(e.getMessage());
						}
						break;

					case 4:
						System.out.print("Enter the base: ");
						int base = scanner.nextInt();
						System.out.print("Enter the exponent: ");
						int exponent = scanner.nextInt();
						System.out.println("Power: " + calculator.power(base, exponent));
						break;
				}
			}
			System.out.println();
		}
		scanner.close();
	}

}
