package tech.rohitshah1706.calculator;

import java.util.Scanner;

public class CalculatorApplication {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		Scanner scanner = new Scanner(System.in);
		boolean exit = false;

		while (!exit) {
			System.out.println("=== Calculator Menu ===");
			System.out.println("1. Add");
			System.out.println("2. Subtract");
			System.out.println("3. Multiply");
			System.out.println("4. Divide");
			System.out.println("5. Exit");
			System.out.print("Select an option: ");
			int option = scanner.nextInt();

			if (option == 5) {
				exit = true;
				System.out.println("Exiting...");
			} else {
				System.out.print("Enter the first number: ");
				int num1 = scanner.nextInt();
				System.out.print("Enter the second number: ");
				int num2 = scanner.nextInt();

				switch (option) {
					case 1:
						System.out.println("Result: " + calculator.add(num1, num2));
						break;
					case 2:
						System.out.println("Result: " + calculator.subtract(num1, num2));
						break;
					case 3:
						System.out.println("Result: " + calculator.multiply(num1, num2));
						break;
					case 4:
						try {
							System.out.println("Result: " + calculator.divide(num1, num2));
						} catch (ArithmeticException e) {
							System.out.println(e.getMessage());
						}
						break;
					default:
						System.out.println("Invalid option, please try again.");
						break;
				}
			}
			System.out.println();
		}
		scanner.close();
	}

}
