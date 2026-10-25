package com.amigoscode._4_datastructures._5_linkedlists;

// Exercise: LinkedList vs ArrayList Performance Comparison
// Understand when to use LinkedList vs ArrayList by measuring operation times.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListVsArrayList {

    public static void main(String[] args) {

        // TODO: 1 - Create both an ArrayList<Integer> and a LinkedList<Integer>
        //           Fill each with 10000 elements (0 to 9999) using a for loop
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();


        // TODO: 2 - Measure time to add an element at the beginning (index 0) for both lists
        //           Use System.nanoTime() before and after the operation
        //           Perform the add(0, value) operation 1000 times for each list
        //           Print the time taken for each in milliseconds
        //           (divide nanoseconds by 1_000_000 to get milliseconds)
        var start = System.nanoTime();
        for (int i = 0; i < 1000; i++)  arrayList.add(0, i);
        var end = System.nanoTime();
        System.out.println("ArrayList: " + (end - start) );

        start = System.nanoTime();
        for (int i = 0; i < 1000; i++)  linkedList.addLast(i);
        end = System.nanoTime();
        System.out.println("LinkedList: " + (end - start));


        // TODO: 3 - Measure time to add an element at the end for both lists
        //           Perform the add(value) operation 1000 times for each list
        //           Print the time taken for each
        start = System.nanoTime();
        for (int i = 0; i < 1000; i++)  arrayList.addLast(i);
        end = System.nanoTime();
        System.out.println("ArrayList: " + (end - start) );

        start = System.nanoTime();
        for (int i = 0; i < 1000; i++)  linkedList.add(0, i);
        end = System.nanoTime();
        System.out.println("LinkedList: " + (end - start));


        // TODO: 4 - Measure time to get an element at the middle index for both lists
        //           Perform get(list.size() / 2) operation 1000 times for each list
        //           Print the time taken for each
        start = System.nanoTime();
        for (int i = 0; i < 1000; i++)  arrayList.get(arrayList.size() / 2);
        end = System.nanoTime();
        System.out.println("ArrayList: " + (end - start) );

        start = System.nanoTime();
        for (int i = 0; i < 1000; i++)  linkedList.get(linkedList.size() / 2);
        end = System.nanoTime();
        System.out.println("LinkedList: " + (end - start));


        // TODO: 5 - Print a summary explaining the differences
        //           Use System.out.println() to explain:
        //           - Why LinkedList is faster for insertions at the beginning
        //           - Why ArrayList is faster for random access (get by index)
        //           - When you would choose one over the other
        System.out.println
                ("LinkedList is faster for insertions at the beginning because ArrayList need to shift all elements to the right. LinkedList get it directly.");
        System.out.println(
                "ArrayList is faster than LinkedList because is backed by an array directly accessible by index" +
                        " LinkedList is backed by a doubly linked list, and must refer to both the previous and the next reference"
        );
        System.out.println("We should  use LinkedList when the most operation follow the principle of first in first out (FIFO)");

    }
}
