package com.amigoscode._7_streams._7_statistics;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Exercise: Count, Min, and Max
 *
 * Learn to use counting operations and find minimum/maximum elements
 * using both stream methods and Collectors.
 */
public class CountMinMax {

    record Employee(String name, String department, double salary) {}

    static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Alice", "Engineering", 95000),
                new Employee("Bob", "Engineering", 88000),
                new Employee("Charlie", "Marketing", 72000),
                new Employee("Diana", "Marketing", 78000),
                new Employee("Eve", "Sales", 68000),
                new Employee("Frank", "Engineering", 102000),
                new Employee("Grace", "Sales", 71000),
                new Employee("Henry", "Marketing", 82000)
        );

        // TODO: 1 - Count the number of employees with salary greater than 80000
        //           Use filter + count() and print the result
        System.out.println("\nEmployees with salary > 80000:");
        System.out.println(employees.stream().filter(emp -> emp.salary() > 80000).count());


        // TODO: 2 - Find the employee with the lowest salary
        //           Use min() with Comparator.comparingDouble(Employee::salary)
        //           Print the employee's name and salary
        System.out.println("\nEmployees with the lowest salary:");
        employees.stream().min(Comparator.comparing(Employee::salary))
                .ifPresent(emp -> System.out.println(emp.name() + " --> " + emp.salary()));

        // TODO: 3 - Find the employee with the highest salary
        //           Use max() with an appropriate comparator
        //           Print the employee's name and salary
        System.out.println("\nEmployees with the highest salary:");
        employees.stream().max(Comparator.comparing(Employee::salary))
                .ifPresent(emp -> System.out.println(emp.name() + " --> " + emp.salary()));

        // TODO: 4 - Use the Collectors.counting() collector to count all employees
        //           Print the result
        System.out.println("\nEmployees counting:");
        System.out.println(employees.stream().collect(Collectors.counting()));

        // TODO: 5 - Combine count with groupingBy: count employees per department
        //           Use Collectors.groupingBy with Collectors.counting() as downstream
        //           Print each department and its count
        System.out.println("\nCounts employees per departement:");
        Map<String, Long> groups = employees.stream().collect(Collectors.groupingBy(Employee::department, Collectors.counting()));
        groups.forEach((dep, count) -> {
            System.out.println(dep + " --> " + count);
        });

        // TODO: 6 - Use Collectors.minBy and Collectors.maxBy to find the lowest
        //           and highest paid employees
        //           Print both results
        System.out.println("\nLowest and highest payed employees by Collectors.minBy and Comparator.comparing");
        System.out.println("Lowest ---> " + employees.stream().collect(Collectors.minBy(Comparator.comparing(emp -> emp.salary()))));
        System.out.println("Highest ---> " + employees.stream().collect(Collectors.maxBy(Comparator.comparing(emp -> emp.salary()))));
    }
}
