package com.amigoscode._4_datastructures._8_challenge;

// Exercise: Data Structure Challenge
// Combine multiple data structures to solve a real-world problem.
// Manage a collection of students, group them, track recently viewed, and generate reports.

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class DataStructureChallenge {

    // TODO: 1 - Create a Student record (or class) with three fields:
    //           String name, int grade, String subject
    //           If using a record: record Student(String name, int grade, String subject) {}
    //           If using a class: include constructor, getters, and a toString() method
    record Student(String name, int grade, String subject) {}

    static void main(String[] args) {

        // TODO: 2 - Create a List of 10 students with various names, grades, and subjects
        //           Use at least 3 different subjects (e.g., "Math", "Science", "English")
        //           Example: new Student("Alice", 92, "Math")
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 92, "Math"));
        students.add(new Student("Bob", 85, "Science"));
        students.add(new Student("Charlie", 78, "Math"));
        students.add(new Student("Diana", 95, "English"));
        students.add(new Student("Eve", 88, "Math"));
        students.add(new Student("Frank", 90, "Science"));
        students.add(new Student("Grace", 80, "English"));
        students.add(new Student("Hannah", 95, "Math"));
        students.add(new Student("Ivy", 75, "Science"));
        students.add(new Student("Jack", 82, "English"));

        // TODO: 3 - Use a Map<String, List<Student>> to group students by subject
        //           Iterate through the student list
        //           For each student, use computeIfAbsent() to get or create the list for their subject
        //           Then add the student to that list
        //           Print each subject and its students
        Map<String, List<Student>> studentsBySubject = new HashMap<>();
        for (Student student : students) {
            studentsBySubject.computeIfAbsent(student.subject(), k -> new ArrayList<>()).add(student);
        }
        for (Map.Entry<String, List<Student>> entry : studentsBySubject.entrySet()) {
            System.out.println(entry.getKey() + ": ");
            for (Student student : entry.getValue()) {
                System.out.println("  Name:" + student.name() + " - Grade:" + student.grade());
            }
            System.out.println();
        }



        // TODO: 4 - Use a Set<String> to find all unique subjects
        //           Iterate through the students and add each subject to the set
        //           Print the unique subjects
        Set<String> uniqueSubjects = new HashSet<>();
        for (Student student : students) {
            uniqueSubjects.add(student.subject());
        }
        System.out.println("Unique subjects: " + uniqueSubjects);

        // TODO: 5 - Use a Stack<Student> to track the last 3 students "viewed"
        //           Push any 3 students from the list onto the stack
        //           Then pop and print them to show the viewing history (most recent first)
        Stack<Student> viewedStudents = new Stack<>();
        viewedStudents.push(students.get(0));
        viewedStudents.push(students.get(1));
        viewedStudents.push(students.get(2));
        System.out.println("Last 3 viewed students: " + viewedStudents);
        System.out.println(viewedStudents.pop());
        System.out.println(viewedStudents.pop());
        System.out.println(viewedStudents.pop());



        // TODO: 6 - Sort the student list by grade in descending order using a Comparator
        //           Use list.sort() with Comparator.comparingInt() and .reversed()
        //           Print the sorted list
        System.out.println("Sorting...");
        students.sort(Comparator.comparingInt((Student s)->s.grade()).reversed());
        System.out.println(students);

        // TODO: 7 - Print a summary report:
        //           - Total number of students
        //           - Number of unique subjects (from the Set)
        //           - Highest grade student (first in sorted list)
        //           - Number of students per subject (from the Map)
        System.out.println("Report: ");
        System.out.println("Total number of students: " + students.size());
        System.out.println("Number of unique subjects: " + uniqueSubjects.size());
        System.out.println("Highest grade student: " + students.get(0));
        System.out.println("Number of students per subject: ");
        for (Map.Entry<String, List<Student>> entry : studentsBySubject.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().size());
        }
    }
}
