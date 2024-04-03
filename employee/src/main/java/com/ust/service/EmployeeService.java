package com.ust.service;

import com.ust.exception.ResourceNotFoundException;
import com.ust.model.Address;
import com.ust.model.Employee;
import com.ust.repository.AddressRepository;
import com.ust.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private AddressRepository addressRepository;


    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    public Employee addEmployee(Employee employee) {
        Employee employee1=new Employee();
        employee1.setDepartment(employee.getDepartment());
        employee1.setName(employee.getName());
        employee1.setSkill(employee.getSkill());
        employee1.setSalary(employee.getSalary());
        employee1.setAddress(employee.getAddress());
        employee1=employeeRepository.save(employee1);

        Address address=new Address();
        address.setAddress(employee.getAddress());
        address.setEmployee(employee1);
        addressRepository.save(address);

      return employee1;

    }

    public Employee updateEmployee(Long id,Employee employee){
        Employee employeeDetails=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not found with id"+id));
        employeeDetails.setName(employee.getName());
        employeeDetails.setDepartment(employee.getDepartment());
        employeeDetails.setSalary(employee.getSalary());
        employeeDetails.setSkill(employee.getSkill());

        return  employeeRepository.save(employeeDetails);
    }

    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

        employeeRepository.delete(employee);
    }
    public Page<Employee> getEmployeesByDepartment(String department, Pageable pageable) {
        return employeeRepository.findByDepartment(department, pageable);
    }

}
