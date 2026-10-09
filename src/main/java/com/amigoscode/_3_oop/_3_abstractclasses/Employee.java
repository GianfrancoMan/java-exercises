package com.amigoscode._3_oop._3_abstractclasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Exercise: Abstract Classes - Employee Hierarchy
 *
 * Build an employee hierarchy using abstract classes. The abstract Employee
 * defines common behavior, while FullTimeEmployee and ContractEmployee
 * provide different pay calculation strategies.
 *
 * Key concepts:
 * - Abstract class with both abstract and concrete methods
 * - Multiple subclasses with different implementations
 * - Polymorphism with a List of the abstract type
 * - Inner classes (classes defined in the same file)
 */

// TODO: 1 - Make the Employee class abstract. Add two protected fields:
//   - name (String)
//   - baseSalary (double)
//   Create a constructor that takes both fields and assigns them.
abstract class Employee {
    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // TODO: 2 - Declare an abstract method: double calculatePay()
    //   Each subclass will compute pay differently.
    abstract double calculatePay();


    // TODO: 3 - Create a concrete method: String getDetails()
    //   Return: "<name> - Pay: $<calculatePay()>"
    //   Use String.format("%.2f", calculatePay()) for formatting.
    public String getDetails() {
        return String.format("%s - Pay: $%.2f", name, calculatePay());
    }
}

// TODO: 4 - Create a FullTimeEmployee class that extends Employee.
//   - Constructor takes name and baseSalary, calls super(name, baseSalary)
//   - Implement calculatePay() to simply return baseSalary
class FullTimeEmployee extends Employee {

    public FullTimeEmployee(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    double calculatePay() {
        return baseSalary;
    }
}


// TODO: 5 - Create a ContractEmployee class that extends Employee.
//   - Add two private fields: hourlyRate (double) and hoursWorked (int)
//   - Constructor takes name, hourlyRate, and hoursWorked
//     (pass name and 0.0 as baseSalary to super)
//   - Implement calculatePay() to return hourlyRate * hoursWorked
class ContractEmployee extends Employee {

    private double hourlyRate;
    private double hoursWorked;

    public ContractEmployee(String name, double hourlyRate, int hoursWorked) {
        super(name, 0.0);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    double calculatePay() {
        return hourlyRate * hoursWorked;
    }
}


// TODO: 6 - In the EmployeeDemo class below, complete the main method:
//   - Create a List<Employee> with at least one FullTimeEmployee
//     and one ContractEmployee
//   - Iterate over the list and print getDetails() for each employee

// TODO: 7 - Add a method in EmployeeDemo: static Employee getHighestPaid(List<Employee> employees)
//   that returns the employee with the highest calculatePay() value.
//   Call it from main and print the result.

class EmployeeDemo {
    public static void main(String[] args) {
        // Complete TODOs 6 and 7 here
        List<Employee> employees = new ArrayList<>(Arrays.asList(
                new ContractEmployee("John BonJohn", 80.0, 140),
                new FullTimeEmployee("Alice Cooper", 5000.0),
                new ContractEmployee("Bob Sinclar", 250.0, 60)
        ));

        for(Employee employee: employees) System.out.println(employee.getDetails());

        System.out.println("Highest paid: " + getHighestPaid(employees).getDetails());
    }


    public static Employee getHighestPaid(List<Employee> employees) {
        Employee highestPaid = null;
        for (Employee employee : employees) {
            if (highestPaid == null || employee.calculatePay() > highestPaid.calculatePay()) {
                highestPaid = employee;
            }
        }
        return highestPaid;
    }
}
