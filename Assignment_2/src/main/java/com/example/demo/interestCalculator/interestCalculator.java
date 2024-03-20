package com.example.demo.interestCalculator;

import java.util.Scanner;

public class interestCalculator {

    @FunctionalInterface
    interface SimpleInterest {
        double calculate(double principal, double rate, int time);
    }

    @FunctionalInterface
    interface CompoundInterest {
        double calculate(double principal, double rate, int time);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter principal amount: ");
            double principal = scanner.nextDouble();
            if (principal <= 0) {
                throw new IllegalArgumentException("Principal amount cannot be negative or zero.");
            }

            System.out.print("Enter interest rate : ");
            double rate = scanner.nextDouble();
            if (rate <= 0) {
                throw new IllegalArgumentException("Interest rate cannot be negative or zero.");
            }

            System.out.print("Enter time : ");
            int time = scanner.nextInt();
            if (time <=0) {
                throw new IllegalArgumentException("Time cannot be negative or zero.");
            }

            System.out.print("Enter '1' to calculate Simple Interest or '2' to calculate Compound Interest: ");
            int choice = scanner.nextInt();
            if (choice != 1 && choice != 2) {
                throw new IllegalArgumentException("Invalid choice. Please enter '1' for Simple Interest or '2' for Compound Interest.");
            }

            double interest = 0.0;

            if (choice == 1) {
                SimpleInterest simpleInterestCalculator = (p, r, t) ->
                        (p * r * t) / 100;
                interest = simpleInterestCalculator.calculate(principal, rate, time);
            } else if (choice == 2) {
                CompoundInterest compoundInterestCalculator = (p, r, t) ->
                        p * Math.pow((1 + r / 100), t) - p;
                interest = compoundInterestCalculator.calculate(principal, rate, time);
            }

            System.out.println("Interest: " + interest);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
