package com.example.demo.interestCalculator;

import java.util.*;

public class Employee{
    record Employeelist(int id, String name, String place, int age) {}
    public static void main(String[] args) {
        List<Employeelist> employees = List.of(
                new Employeelist(101, "John", "New York", 30),
                new Employeelist(102, "Alice", "London", 25),
                new Employeelist(103, "Bob", "Paris", 35),
                new Employeelist(101, "John", "New York", 30)
        );

        Set<Integer> employeeIds = new HashSet<>(employees.size());
        employees.forEach(employee -> employeeIds.add(employee.id));
        System.out.println("id without duplicate"+employeeIds);

        List<Integer> sortedIds = new ArrayList<>(employeeIds);
        sortedIds.sort(Comparator.reverseOrder());
        System.out.println("sorted employee id descending order  :"+sortedIds);

        Map<Integer, Employeelist> employeeInfoById = new HashMap<>();
        employees.forEach(employee -> employeeInfoById.put(employee.id(), employee));
        System.out.println("employee details :"+employeeInfoById);

        sortedIds.forEach(id -> {
            Employeelist employee = employeeInfoById.get(id);
            System.out.println("Employee ID: " + id + ", Name: " + employee.name +
                    ", Place: " + employee.place + ", Age: " + employee.age);
        });
    }

}

