package com.amigoscode._7_streams._11_understanding;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Exercise: Lazy Evaluation and Stream Behavior
 *
 * Understand how streams are lazily evaluated, how short-circuiting works,
 * why streams can only be consumed once, and how operation ordering
 * affects performance.
 */
public class LazyStreams {

    static void main(String[] args) {
        List<String> names = List.of("Al", "Bob", "Charlie", "Diana", "Eve", "Frank");
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // TODO: 1 - Demonstrate lazy evaluation using peek():
        //           Create a stream from 'names', add peek(n -> System.out.println("Processing: " + n))
        //           before a filter that keeps names with length > 3,
        //           add another peek after the filter,
        //           then use findFirst() as terminal operation.
        //           Observe: not all elements are processed! Operations execute per-element.
        //           Print the result.
        System.out.println("########## TODO 1 ##########");
        System.out.println(names.stream().peek(n -> System.out.println("Processing " + n))
                .filter(name -> name.length() > 3  )
                .peek(n -> System.out.println("Processing " + n))
                .findFirst());

        // TODO: 2 - Demonstrate short-circuiting with findFirst():
        //           Create a stream from 'numbers', use peek to print "Checking: " + number,
        //           filter for numbers > 5, then findFirst().
        //           Notice how the stream stops processing once the first match is found.
        //           Print how many elements were actually checked.
        System.out.println("########## TODO 2 ##########");
        numbers.stream()
                .peek(n -> System.out.println("checkink: " +n))
                .filter(n -> n > 5).findFirst()
                .ifPresent(n -> System.out.println("Found: " +n));

        // TODO: 3 - Show that streams can only be consumed once:
        //           Create a Stream<String> variable from 'names'.
        //           Call count() on it (first consumption).
        //           Then try to call count() again on the same stream.
        //           Wrap the second call in a try-catch for IllegalStateException.
        //           Print the exception message.
        System.out.println("########## TODO 3 ##########");
        Stream<String> stream = names.stream();
        System.out.println("Total names: " + stream.count());
        try {
            stream.count(); //java.lang.IllegalStateException: stream has already been operated upon or closed
        } catch (Exception e) {
            System.out.println(e);
        }

        // TODO: 4 - Demonstrate that ordering of operations matters for performance:
        //           Approach 1: filter first, then map (efficient)
        //           numbers.stream().filter(n -> n > 5).map(n -> n * n)...
        //           Approach 2: map first, then filter (wasteful - maps elements that get filtered)
        //           numbers.stream().map(n -> n * n).filter(n -> n > 25)...
        //           Use peek() to count how many times map executes in each approach.
        //           Both give the same result but the first approach does less work.
        System.out.println("########## TODO 4 ##########");
//Efficient
        System.out.println(numbers.stream().filter(n -> n > 5).map(n -> n * n).collect(Collectors.toList()));
        //wasteful
        System.out.println(numbers.stream().map(n -> n * n).filter(n -> n >25).collect(Collectors.toList()));

        // TODO: 5 - Show the difference between intermediate and terminal operations:
        //           Create a stream pipeline with filter and map but NO terminal operation.
        //           Add a System.out.println("This should NOT print") inside peek.
        //           Then add a terminal operation (e.g., collect) to a second pipeline
        //           with a peek that prints "This SHOULD print".
        //           Observe: without a terminal operation, nothing happens!
        System.out.println("########## TODO 5 ##########");
        Stream<String> stringStream = Stream.of("Ciao", "Boh", "Illo", "Ha fatto", "Il prezioso");
        stringStream.map(s -> s.length() > 3)
                .peek(_ -> System.out.println("This should not print")).collect(Collectors.toList());

    }
}
