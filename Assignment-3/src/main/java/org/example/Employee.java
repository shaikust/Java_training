package org.example;

public class Employee {
    private int id;
    private String name;
    private double salary;
    private String skill;

    public int getId() {
        return id;
    }

    public Employee(int id, String name, double salary, String skill) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.skill = skill;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", skill='" + skill + '\'' +
                '}';
    }
}
