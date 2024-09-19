package tech.rohitshah1706.calculator;

public class Calculator {
    // Finds the square root of the given number
    public double squareRoot(int a) throws ArithmeticException {
        if (a < 0) {
            throw new ArithmeticException("Square root of a negative number is not allowed");
        }
        return Math.sqrt(a);
    }

    // Finds the factorial of the given number
    public int factorial(int a) throws ArithmeticException {
        if (a < 0) {
            throw new ArithmeticException("Factorial of a negative number is not allowed");
        }
        if (a == 0) {
            return 1;
        }
        return a * factorial(a - 1);
    }

    // Finds the natural logarithm of the given number
    public double naturalLogarithm(int a) throws ArithmeticException {
        if (a <= 0) {
            throw new ArithmeticException("Natural logarithm of a non-positive number is not allowed");
        }
        return Math.log(a);
    }

    // Finds the power of the given number
    public double power(int a, int b) {
        return Math.pow(a, b);
    }
}
