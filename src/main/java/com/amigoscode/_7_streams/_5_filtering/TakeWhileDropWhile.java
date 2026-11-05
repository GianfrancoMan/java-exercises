package com.amigoscode._7_streams._5_filtering;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Exercise: takeWhile and dropWhile
 *
 * Learn how to use takeWhile() and dropWhile() (Java 9+) to process
 * elements from ordered streams. Unlike filter(), these operations
 * are order-dependent and stop/start based on when the predicate changes.
 */
public class TakeWhileDropWhile {

    static void main(String[] args) {
        List<Integer> sortedNumbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> unsortedNumbers = List.of(1, 3, 2, 5, 4, 7, 6, 8);
        List<String> logLevels = List.of("DEBUG", "DEBUG", "INFO", "INFO", "WARN", "ERROR", "ERROR");
        List<String> words = List.of("apple", "avocado", "apricot", "banana", "blueberry", "cherry");

        // TODO: 1 - Use takeWhile to take numbers from 'sortedNumbers' while they are < 5
        //           Print the result (should be 1, 2, 3, 4)
        System.out.println("\ntake while");
        sortedNumbers.stream().takeWhile( sn -> sn < 5).forEach(s -> System.out.print(s + "   "));

        // TODO: 2 - Use dropWhile to skip numbers from 'sortedNumbers' while they are < 5
        //           Print the result (should be 5, 6, 7, 8, 9, 10)
        System.out.println("\n\ndrop while");
        sortedNumbers.stream().dropWhile( sn -> sn < 5).forEach(s -> System.out.print(s + "   "));



        // TODO: 3 - Combine takeWhile with other operations:
        //           From 'sortedNumbers', take numbers while < 7, then filter to keep
        //           only even numbers, and collect to a list
        //           Print the result
        System.out.println("\n\nTake While with list");
        List<Integer> minor7AndEven =
                sortedNumbers.stream().takeWhile(sn -> sn < 7).filter(tsn -> tsn % 2 == 0).collect(Collectors.toList());
        System.out.println(minor7AndEven);

        // TODO: 4 - Use takeWhile on 'words' to take words while they start with "a"
        //           Print each word taken
        System.out.println("\nTake While starts with \"a\"");
        words.stream().takeWhile( w -> w.startsWith("a")).forEach(System.out::println);

        // TODO: 5 - Compare takeWhile vs filter on 'unsortedNumbers':
        //           First, use takeWhile(n -> n < 5) and print the result
        //           Then, use filter(n -> n < 5) and print the result
        //           Notice the different outputs - takeWhile stops at first non-match
        System.out.println("\nTake While vs Filter");
        List<Integer> takeWhileMinor5 = unsortedNumbers.stream().takeWhile(usn -> usn < 5).collect(Collectors.toUnmodifiableList());Collectors.toList();
        List<Integer> filterMinor5 = unsortedNumbers.stream().filter(usn -> usn < 5).collect(Collectors.toUnmodifiableList());Collectors.toList();
        System.out.println("takeWhile result: " + takeWhileMinor5 + ", Filter result: " +  filterMinor5);


        // TODO: 6 - Use dropWhile on 'logLevels' to skip all DEBUG entries,
        //           then collect the remaining entries to a list
        //           Print the result
        System.out.println("\nDrop While..");
        List<String> debugs = logLevels.stream().dropWhile(ll -> ll.equals("DEBUG")).collect(Collectors.toList());
        System.out.println(debugs);
    }
}
