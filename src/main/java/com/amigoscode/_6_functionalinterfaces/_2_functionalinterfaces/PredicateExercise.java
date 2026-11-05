package com.amigoscode._6_functionalinterfaces._2_functionalinterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Exercise: Predicate<T> and BiPredicate<T, U>
 *
 * Predicate represents a boolean-valued function of one argument. It is commonly
 * used for filtering and conditional logic. Key methods:
 *   - boolean test(T t)
 *   - and(Predicate other)    logical AND
 *   - or(Predicate other)     logical OR
 *   - negate()                logical NOT
 *
 * BiPredicate takes two arguments and returns a boolean.
 */
public class PredicateExercise {

    static void main(String[] args) {

        // TODO: 1 - Create a Predicate<Integer> called 'isPositive' that
        //  returns true if the number is greater than 0.
        Predicate<Integer> isPositive = num -> num > 0;
        int number  = 12;
        System.out.println(number + " is positive: " + isPositive.test(number));

        // TODO: 2 - Create a Predicate<String> called 'isNotEmpty' that
        //  returns true if the string is not null and not empty.
        //  Hint: s -> s != null && !s.isEmpty()
        Predicate<String> isNotEmpty = str -> str != null && !str.isEmpty();
        String strs = "";
        System.out.println(strs + " is not empty: " + isNotEmpty.test(strs));


        // TODO: 3 - Create a Predicate<Integer> called 'isEven' that returns
        //  true if the number is even. Then combine 'isPositive' and 'isEven'
        //  using and() to create 'isPositiveAndEven'. Test it with values
        //  4, -2, 3, and 0.
        Predicate<Integer> isEven = num -> num%2 == 0;
        Predicate<Integer> isPositiveAndEven = isPositive.and(isEven);
        System.out.println("Is Positive and Even");
        System.out.println(isPositiveAndEven.test(4));
        System.out.println(isPositiveAndEven.test(-2));
        System.out.println(isPositiveAndEven.test(3));
        System.out.println(isPositiveAndEven.test(0));

        // TODO: 4 - Create a Predicate<Integer> called 'isMultipleOf3' that
        //  returns true if the number is divisible by 3. Combine 'isEven' and
        //  'isMultipleOf3' using or() to create 'isEvenOrMultipleOf3'.
        //  Test it with values 4, 9, 7, and 6.
        Predicate<Integer> isMultipleOf3 = num -> num%3 == 0;
        Predicate<Integer> isEvenOrMultileOf3 = isEven.or(isMultipleOf3);
        System.out.println("Is Even or Multiple of 3");
        System.out.println(isEvenOrMultileOf3.test(4));
        System.out.println(isEvenOrMultileOf3.test(9));
        System.out.println(isEvenOrMultileOf3.test(7));
        System.out.println(isEvenOrMultileOf3.test(6));


        // TODO: 5 - Use negate() on 'isPositive' to create 'isNotPositive'.
        //  Test it with values 5, -3, and 0.
        Predicate<Integer> isNotPositive = isPositive.negate();
        System.out.println("Is Not positive");
        System.out.println(isNotPositive.test(5));
        System.out.println(isNotPositive.test(-3));
        System.out.println(isNotPositive.test(0));


        List<Integer> numbers = Arrays.asList(-5, -2, 0, 1, 3, 6, 8, 11, 15, -7);

        // TODO: 6 - Use 'isPositiveAndEven' (from TODO 3) to filter the
        //  numbers list. Store the result in a List<Integer> and print it.
        //  Hint: numbers.stream().filter(isPositiveAndEven).collect(...)
        List<Integer>  onlyPositivesAndEvens =
                numbers.stream()
                        .filter(isPositiveAndEven)
                        .collect(Collectors.toList());
        System.out.println(numbers);
        System.out.println(onlyPositivesAndEvens);

        // TODO: 7 - Create a BiPredicate<String, Integer> called 'hasLength'
        //  that returns true if the string's length equals the given integer.
        //  Test it with ("hello", 5) and ("hi", 3). Print the results.
        BiPredicate<String, Integer> hasLength = (s, l) -> s.length() == l;
        System.out.println("Has Length");
        System.out.println(hasLength.test("Hello", 5));
        System.out.println(hasLength.test("Hi", 3));

    }
}
