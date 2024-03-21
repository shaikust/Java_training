package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "John", 50000, "Java"));
        employees.add(new Employee(2, "Alice", 60000, "java"));
        employees.add(new Employee(3, "Bob", 55000, "Python"));

        List<Employee> pythonEmployees = employees.stream()
                .filter(employee -> employee.getSkill().equalsIgnoreCase("Python"))
                .toList();
        if (pythonEmployees.isEmpty()) {
            throw new RuntimeException("No employee with skill Python found");
        }

        System.out.println("Employees with skill Python:");
        pythonEmployees.forEach(System.out::println);
    }

}