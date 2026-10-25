package com.amigoscode._4_datastructures._6_sets;

// Exercise: HashSet Operations
// Learn how to use HashSet - an unordered collection that contains no duplicate elements.

import java.util.*;

public class HashSetExercises {

    static void main(String[] args) {

        // TODO: 1 - Create a HashSet of Strings called 'fruits'
        HashSet<String> fruits = new HashSet<>();

        // TODO: 2 - Add elements: "Apple", "Banana", "Cherry", "Apple", "Date", "Banana"
        //           Print the set after adding all elements
        //           Observe that duplicates are automatically ignored
        fruits.add("Apple");fruits.add("Banana");fruits.add("Cherry");fruits.add("Apple");fruits.add("Date");fruits.add("Banana");
        System.out.println(fruits);

        // TODO: 3 - Check if "Cherry" exists in the set using contains()
        //           Print the result
        System.out.println("Cherry is in the set: "  +fruits.contains("Cherry"));


        // TODO: 4 - Remove "Date" from the set
        //           Print the set after removal
        fruits.remove("Date");
        System.out.println(fruits);


        // TODO: 5 - Get and print the size of the set
        System.out.println(fruits.size());

        // TODO: 6 - Iterate over the set using a for-each loop and print each element
        //           Note: the order may not match insertion order (HashSet is unordered)
        Iterator<String > iterator = fruits.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // --- Removing Duplicates from a List ---
        System.out.println("\n--- Removing Duplicates ---");
        List<String> listWithDuplicates = new ArrayList<>(
                Arrays.asList("Java", "Python", "Java", "C++", "Python", "Go", "Java")
        );
        System.out.println("Original list: " + listWithDuplicates);

        // TODO: 7 - Use a HashSet to remove duplicates from 'listWithDuplicates'
        //           Create a new HashSet from the list, then create a new ArrayList from the set
        //           Print the deduplicated list
        Set<String> uniqueSet = new HashSet<>(listWithDuplicates);
        List<String> deduplicatedList = new ArrayList<>(uniqueSet);
        System.out.println("Deduplicated list: " + deduplicatedList);

    }
}
