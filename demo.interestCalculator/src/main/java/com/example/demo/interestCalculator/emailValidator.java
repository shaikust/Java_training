package com.example.demo.interestCalculator;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class emailValidator {

    private static final String emailPattern =
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    private static final Pattern pattern = Pattern.compile(emailPattern);

    public static boolean validate(String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter email address: ");
        String email = scanner.nextLine();

        boolean isValid = validate(email);
        if (isValid) {
            System.out.println("Valid email address.");
        } else {
            System.out.println("Invalid email address.");
        }

        scanner.close();
    }
}
