package nl.haagsehogeschool.nursinghome.model;

import java.time.LocalDate;

public class Employee extends Person {
    private String role;
    private double salary;
    //todo: relation with schedule

    public Employee(String firstName, String surName, String gender, LocalDate birthDate, String role, double salary) {
        super(firstName, surName, gender, birthDate);
        this.role = role;
        this.salary = salary;
    }

    @Override
    public String getName() {
        return super.getFirstName();
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return getName();
    }
}
