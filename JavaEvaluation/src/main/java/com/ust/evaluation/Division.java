package com.ust.evaluation;

import java.util.Scanner;

class InvalidDivisorException extends Exception {
    public InvalidDivisorException(String message) {
        super(message);
    }
}
public class Division  {
public static double division(int dividend,int divisor)throws InvalidDivisorException{
    try {
        if (divisor == 0) {
            throw new ArithmeticException("Division by zero error");
        }
        double result = dividend / divisor;
        System.out.println("Division completed successfully.");
        return result;
    } catch (ArithmeticException e) {
        System.out.println("Entire error trace:");
        e.printStackTrace();
        throw new InvalidDivisorException("Please pass a valid divisor");
    } finally {
        System.out.println("Divisor used: " + divisor);
        System.out.println("Dividend used: " + dividend);
    }

}
    public static void main(String[] args) {
        try {
            Scanner scanner=new Scanner(System.in);
            System.out.println("enter dividend");
            int dividend = scanner.nextInt();
            System.out.println("enter divisor");
            int divisor = scanner.nextInt();
            double result = division(dividend, divisor);
            System.out.println("Result: " + result);
        } catch (InvalidDivisorException e) {
            System.out.println("Error message: " + e.getMessage());
        }
    }
}
