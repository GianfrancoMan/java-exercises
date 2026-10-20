package com.amigoscode._5_generics._6_wildcards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Exercise: Unbounded Wildcards (?)
 *
 * The unbounded wildcard <?> represents an unknown type.
 * A List<?> can refer to a list of any type, but you cannot add elements
 * to it (except null) because the compiler does not know the actual type.
 *
 * Complete the TODOs below.
 */
public class UnboundedWildcard {

    // To do 1 - Create a static method: void printList(List<?> list)
    //  It should iterate through the list and print each element.
    //  Note: elements come out as Object since the type is unknown.
    static void printList(List<?> list) {
        for (Object item : list) {
            System.out.println(item);
        }
    }


    // To do: 2 - Create a static method: int getSize(List<?> list)
    //  It should return the size of any list, regardless of its type.
    static int getSize(List<?> list) {
        return list.size();
    }


    public static void main(String[] args) {

        // TODO: 3 - Create three lists:
        //  (a) List<String> with values "Hello", "World"
        //  (b) List<Integer> with values 1, 2, 3
        //  (c) List<Double> with values 1.1, 2.2, 3.3
        //  Call printList() and getSize() with each of them.
        List<String> stringValues = Arrays.asList("Hello", "World");
        List<Integer> intValues = Arrays.asList(1, 2, 3);
        List<Double> doubleValues = Arrays.asList(1.1, 2.2, 3.3, 4.4);
        printList(stringValues);
        System.out.println("Size: " + getSize(stringValues));
        printList(intValues);
        System.out.println("Size: " + getSize(intValues));
        printList(doubleValues);
        System.out.println("Size: " + getSize(doubleValues));


        // To do: 4 - Demonstrate that you CANNOT add elements to a List<?>.
        //  Uncomment the code below, observe the compile error, then comment
        //  it back out. Add a comment explaining why adding is not allowed.
        //
         List<?> unknownList = Arrays.asList("a", "b", "c");
//         unknownList.add("d");       // Why does this not compile?
//         unknownList.add(1);         // Why does this not compile either?
        //The code above doesn't compile because the list contains elements of a specific type, but this is unknown to the compiler, so it cannot infer if the type added .is correct or no.


        // To do: 5 - Demonstrate what you CAN do with List<?>:
        //  (a) Get the size
        System.out.println("unknownList size:" +unknownList.size());
        //  (b) Check if it is empty
        System.out.println("unknownList is empty:" +unknownList.isEmpty());
        //  (c) Read elements as Object
        for(Object item : unknownList) System.out.println(item);
        //  (d) Remove elements (by index or using clear())
        // Arrays.asList return a list with fixed size, and methods that change it thrown an UnsupportedOperationException
        //but..
        List<String> newUnknowns = new ArrayList<>();
        newUnknowns.add("a"); newUnknowns.add("b"); newUnknowns.add("c");
        removeElement(newUnknowns, 1);
        System.out.println("newUnknowns after removal: " + newUnknowns);//[a, c]
    }

    static void removeElement(List<?> list, int index) {
        list.remove(index);
    }
}
