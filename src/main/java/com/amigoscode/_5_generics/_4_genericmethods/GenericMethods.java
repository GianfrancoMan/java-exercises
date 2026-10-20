package com.amigoscode._5_generics._4_genericmethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Exercise: Generic Methods
 *
 * This exercise focuses on writing static generic methods.
 * Generic methods declare their own type parameters independently
 * of any generic class. The type parameter appears before the return type.
 *
 * Complete the TODOs below.
 */
public class GenericMethods {

    // Create a static generic method: <T> void printArray(T[] array)
    //  It should print each element of the array on the same line separated
    //  by spaces, then print a newline at the end.
    static <T> void printArray(T[] arr) {
        for(T t : arr) {
            System.out.print(t + " ");
        }
        System.out.println();
    }


    // Create a static generic method: <T> T getFirst(List<T> list)
    //  It should return the first element of the list.
    //  If the list is empty, return null.
    static <T> T getFirst(List<T> list) {
        return list.isEmpty() ? null : list.get(0);
    }


    // Create a static generic method: <T> T getLast(List<T> list)
    //  It should return the last element of the list.
    //  If the list is empty, return null.
    static <T> T getLast(List<T> list) {
        return list.isEmpty() ? null: list.get(list.size() - 1);
    }


    // Create a static generic method: <T> List<T> filterNulls(List<T> list)
    //  It should return a new list containing only the non-null elements
    //  from the original list. Do not modify the original list.
    static <T> List<T> filterNulls(List<T> list) {
        List<T> newList =new ArrayList<>();
        for(T t : list) {
            if(t != null) {
                newList.add(t);
            }
        }
        return newList;
    }


    // Create a static generic method: <T> boolean contains(T[] array, T target)
    //  It should return true if the target is found in the array.
    //  Use the equals() method for comparison (handle null target).
    static <T> boolean contains(T[] arr, T target) {
        for(T t : arr) {
            if(null == t && null == target) {
                return true;
            } else if(t.equals(target)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {

        // Call all five methods above:
        //  (a) printArray with a String[] and an Integer[]

        String[] names  = {"Francesco","Giovanni"};
        printArray(names);
        Integer[] numbers = {10,21,32,43,54};
        printArray(numbers); //it is not necessary to specify the type parameter, the compiler infers it from the arguments
        //  (b) getFirst and getLast with a List<String> of names
        List<String> namesList = Arrays.asList("Francesco","Giovanni", "Romolo", "Remo");
        System.out.println(getFirst(namesList) );
        System.out.println(getLast(namesList) );
        //  (c) filterNulls with a list that contains some null values
        List<String> nullList = Arrays.asList("Francesco", null, "Giovanni", null, "Romolo");
        System.out.println(filterNulls(nullList));
        System.out.println(nullList);
        //  (d) contains to search for an element in an array
        Float[] myArray = {1.1f, 2.2f, 3.3f, 4.4f, 5.5f};
        System.out.println("contains 3.3f: " + contains(myArray, 3.3f));
        System.out.println("contains 12.0f: " + contains(myArray, 12.0f));


        // Demonstrate type inference: call printArray and contains
        //  WITHOUT explicitly specifying the type parameter (i.e., just call
        //  printArray(myArray) instead of GenericMethods.<String>printArray(myArray)).
        //  Add a comment explaining that the compiler infers T from the arguments.

    }
}
