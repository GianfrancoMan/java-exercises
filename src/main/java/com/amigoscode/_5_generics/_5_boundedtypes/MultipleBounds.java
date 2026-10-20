package com.amigoscode._5_generics._5_boundedtypes;

import java.awt.print.Printable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Exercise: Multiple Bounds
 *
 * This exercise demonstrates how a type parameter can have multiple bounds.
 * The syntax is: <T extends ClassBound & InterfaceBound1 & InterfaceBound2>
 * If a class is included, it must come first.
 *
 * Complete the TODOs below.
 */
public class MultipleBounds {

    // To do: 1 - Create an interface called Printable with a single method:
    //  void print();


    // To do: 2 - Create a static generic method:
    //  <T extends Comparable<T> & Printable> T findMin(List<T> list)
    //  It should return the smallest element using compareTo().
    //  If the list is empty, return null.
    //  This method requires T to be both Comparable AND Printable.
    static  <T extends  Comparable<T> & Printable> T findMin(List<T> list) {
        if (list.isEmpty()) return null;
        T min =list.get(0);
        for(T item : list) {
            if(min.compareTo(item) < 0) {
                min = item;
            }
        }
        return min;
    }


    // To do: 3 - Create a static inner class Student that implements both
    //  Comparable<Student> and Printable.
    //  Student should have a "name" (String) and "grade" (double) field,
    //  a constructor, compareTo() based on grade (ascending),
    //  and print() that prints "Student{name='...', grade=...}".
    //  Also override toString() with the same format as print().
    static class  Student  implements  Comparable<Student>, Printable {
        private String name;
        private double grade;

        Student(String name,double grade) {
            this.name=name;
            this.grade=grade;
        }
        @Override
        public int compareTo(Student o) {
            return Double.compare(this.grade,o.grade) * -1;
        }

        @Override
        public void print() {
            System.out.println(String.format("Student{name=%s, grade=%,.2f}",  name, grade));
        }

        @Override
        public String toString() {
            return String.format("Student{name=%s, grade=%,.2f}", name, grade);
        }
    }


    public static void main(String[] args) {

        // To do: 4 - Create a List<Student> with at least 3 students having
        //  different grades. Call findMin() to find the student with the
        //  lowest grade. Print the result using the print() method.
        List<Student > students = Arrays.asList(new Student("John",8), new Student("Al", 6.5), new Student("Mark", 9));
         findMin(students).print();


        // To do: 5 - Add a comment below explaining:
        //  (a) Why must a class bound come before interface bounds?
        //      e.g., <T extends SomeClass & SomeInterface> is valid
        //      but  <T extends SomeInterface & SomeClass> is NOT valid
        //      a) Is a rule
        //  (b) Can you have multiple class bounds? Why or why not?
        //      (b) No, a class can extend only one class
        //  (c) How many interface bounds can you have?
        //      (c) How many I need.

    }

    interface Printable {
        void print();
    }
}
