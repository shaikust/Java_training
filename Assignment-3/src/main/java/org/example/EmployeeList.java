package org.example;

public class EmployeeList {
    private Integer age;
    private  String experience;
    private  Integer salary;
    private String name;
    private String department;
    private Integer empIdl;



    public EmployeeList(Integer age, String experience, Integer salary, String name, String department,Integer empIdl) {
        this.age = age;
        this.experience = experience;
        this.salary = salary;
        this.name = name;
        this.department = department;
        this.empIdl = empIdl;

    }

    public Integer getAge() {
        return age;
    }

    public Integer getEmpIdl() {
        return empIdl;
    }

    public void setEmpIdl(Integer empIdl) {
        this.empIdl = empIdl;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "age=" + age +
                ", experience='" + experience + '\'' +
                ", salary=" + salary +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
