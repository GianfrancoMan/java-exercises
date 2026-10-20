package com.amigoscode._5_generics._1_classcastexception;

import java.util.ArrayList;
import java.util.List;

/**
 * Exercise: ClassCastException Problem
 *
 * This exercise demonstrates why Java generics were introduced.
 * Before generics, collections used raw types and stored Objects,
 * which led to ClassCastException at runtime.
 *
 * Complete the TODOs below to see the problem firsthand.
 */
public class ClassCastProblem {

    public static void main(String[] args) {

        // Create a raw (non-generic) ArrayList without any type parameter.
        List list = new ArrayList();


        // Add a String "Hello" and an Integer 42 to the raw list.
        //  This compiles fine because raw lists accept any Object.
        list.add("hello"); list.add(42);


        // Iterate through the list and try to cast every element to String.
        //  Use a for loop: for (int i = 0; i < list.size(); i++)
        //  Inside the loop, cast list.get(i) to String and print it.
        //  This will compile, but will throw ClassCastException at runtime
        //  when it reaches the Integer element.
        for(int i = 0; i < list.size(); i ++) {
            try {
                System.out.println((String )list.get(i));
            }catch (Exception e) {
                System.out.println(e);
            }
        }


        // Wrap the casting code from in a try-catch block
        //  that catches ClassCastException. Print the exception message
        //  so you can see what went wrong.


        // Add a comment below explaining:
        //  (a) Why did the ClassCastException occur?
        // I try to cast an int as a String, this generated a ClassCastException
        //  (b) How do generics (e.g., List<String>) prevent this problem?
        //Using generics, the problem arises in the compilation time.
        //  (c) At what stage (compile-time or runtime) do generics catch type errors?
        //Compile-time

    }
}
