package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class EmployeeOperation {
    private  static List<EmployeeList> addEmployee(){
        List<EmployeeList> employeeList=new ArrayList<>();
        employeeList.add(new EmployeeList(25,"2",20000,"amal","It",121));
        employeeList.add(new EmployeeList(24,"3",25000,"amalu","support",121));
        employeeList.add(new EmployeeList(25,"1",20000,"raju","dev",432));
        employeeList.add(new EmployeeList(24,"2",20000,"saju","support",534));
        employeeList.add(new EmployeeList(26,"4",30000,"ammu","It",221));
        employeeList.add(new EmployeeList(23,"1",20000,"shammu","dev",109));
        return employeeList;

    }
    public static void main(String[] args) {
        System.out.println("Total employees :"+addEmployee().stream()
                .collect(Collectors.counting()));
        System.out.println("grouping based on department :"+addEmployee().stream()
                .collect(Collectors.groupingBy(EmployeeList::getDepartment)));
        System.out.println("Total salary :"+addEmployee().stream()
                .mapToDouble(EmployeeList::getSalary)
                .sum());
        System.out.println("Total salary based on department :"+addEmployee().stream()
                .collect(Collectors.groupingBy(EmployeeList::getDepartment,Collectors.summingDouble(EmployeeList::getSalary))));
        System.out.println("Sorting based on age :"+addEmployee().stream()
                .sorted(Comparator.comparingInt(EmployeeList::getAge))
                .collect(Collectors.toList()));
        System.out.println("sort the employees based on experince"+addEmployee().stream()
                .sorted(Comparator.comparing(EmployeeList::getExperience))
                .collect(Collectors.toList()));








    }
}
