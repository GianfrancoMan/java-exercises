package com.amigoscode._7_streams._2_intstreams;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Exercise: IntStream Basics
 *
 * Learn how to use IntStream, a specialized stream for int primitives.
 * IntStream avoids boxing overhead and provides useful numeric operations
 * like sum(), average(), min(), and max().
 */
public class IntStreamBasics {

    static void main(String[] args) {

        // TODO: 1 - Create an IntStream using IntStream.range(1, 11)
        //           This generates numbers 1 to 10 (end exclusive)
        //           Print each number using forEach
        System.out.println("IntStream range end exclusive");
        IntStream.range(1,11).forEach(v -> System.out.println(v));


        // TODO: 2 - Create an IntStream using IntStream.rangeClosed(1, 10)
        //           Calculate and print the sum of all numbers (should be 55)
        System.out.println("IntStream range end inclusive and sum values");
        System.out.println(IntStream.rangeClosed(1,10).sum());


        // TODO: 3 - Create an IntStream.rangeClosed(1, 5) and convert it to
        //           a Stream<Integer> using boxed()
        //           Collect the result to a List<Integer> and print it
        System.out.println(IntStream.rangeClosed(1,5).boxed().collect(Collectors.toList()));

        // TODO: 4 - Create an IntStream using IntStream.of(10, 20, 30, 40, 50)
        //           Print each value
        IntStream.of(10, 20,30,40,50).forEach(System.out::println);


        // TODO: 5 - Create an IntStream of the values 85, 90, 78, 92, 88
        //           Calculate and print the average using .average()
        //           Remember: average() returns OptionalDouble, use getAsDouble() or orElse()
        System.out.println(IntStream.of(85, 90, 78, 92,88).average().getAsDouble());

        // TODO: 6 - Create an IntStream of the values 15, 3, 42, 7, 28
        //           Find and print both the min and max values
        //           Note: You cannot reuse a stream, so create the IntStream twice
        //           or use summaryStatistics()
        IntSummaryStatistics statistics = IntStream.of(15, 3, 42, 7, 28).summaryStatistics();
        System.out.println("Min: " + statistics.getMin() + ", Max. " + statistics.getMax());
    }
}
