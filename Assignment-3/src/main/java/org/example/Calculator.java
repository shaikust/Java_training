package org.example;

import java.util.Scanner;
interface Add {
    int add(int a, int b);
}
interface Subtract {
    int subtract(int a, int b);
}
interface Multiply {
    int multiply(int a, int b);
}
interface Divide {
    int divide(int a, int b);
}

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter operation you need to perform (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();

        int result = 0;

        switch (operator) {
            case '+':
                Add add=(a,b)->(a+b);
                result= add.add(num1,num2);
                break;
            case '-':
                Subtract subtract=(a,b)->(a-b);
                result=subtract.subtract(num1,num2);
                break;
            case '*':
                Multiply multiply=(a,b)->(a*b);
                result= multiply.multiply(num1,num2);
            case '/':
                Divide divide=(a,b)->(a/b);
                result= divide.divide(num1,num2);
                break;
            default:
                System.out.println("Invalid operator!");
        }

        System.out.println("Result: " + result);
        scanner.close();
    }

}
