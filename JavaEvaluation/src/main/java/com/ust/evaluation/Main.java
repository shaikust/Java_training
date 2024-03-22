package com.ust.evaluation;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<Employee,Address> employeeAddressMap=new HashMap<>();
        Employee employee1=new Employee(1,"SAm");
        Employee employee2=new Employee(2,"SAmul");
        Employee employee3=new Employee(3,"Sai");

        Address address1=new Address(111,"street1","Kollam",6789);
        Address address2=new Address(112,"street2","Kollam",6780);
        Address address3=new Address(113,"street3","Kollam",6782);

        employeeAddressMap.put(employee1,address1);
        employeeAddressMap.put(employee2,address2);
        employeeAddressMap.put(employee3,address3);
        getAddress(employeeAddressMap,employee1);
        getAddress(employeeAddressMap,new Employee(5,"arun"));



    }
    public static void getAddress(Map<Employee, Address> map, Employee employee) {
        Address address = map.get(employee);
        if (address != null) {
            System.out.println(address.toString());
        } else {
            System.out.println("Employee does not exist.");
        }
}
}