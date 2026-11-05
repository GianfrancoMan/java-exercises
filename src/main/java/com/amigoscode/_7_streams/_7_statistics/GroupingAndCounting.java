package com.amigoscode._7_streams._7_statistics;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Exercise: Grouping and Counting
 *
 * Practice advanced grouping scenarios including finding the most common
 * element, partitioning, and using downstream collectors like mapping() and maxBy().
 */
public class GroupingAndCounting {

    record Student(String name, int grade, String subject) {}

    static void main(String[] args) {
        List<String> wordsWithRepeats = List.of(
                "java", "streams", "lambda", "java", "streams",
                "java", "functional", "lambda", "streams", "api",
                "java", "lambda", "functional", "api", "streams"
        );

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);

        List<Student> students = List.of(
                new Student("Alice", 92, "Math"),
                new Student("Bob", 85, "Science"),
                new Student("Charlie", 78, "Math"),
                new Student("Diana", 95, "Science"),
                new Student("Eve", 88, "Math"),
                new Student("Frank", 72, "Science"),
                new Student("Grace", 91, "Math"),
                new Student("Henry", 83, "Science")
        );

        // TODO: 1 - Group 'wordsWithRepeats' by the word itself and count occurrences
        //           Result type: Map<String, Long>
        //           Print each word and its count
        System.out.println("\n## Word occurrences by groupingBy ##");
        Map<String, Long> wordsOccurrences = wordsWithRepeats.stream().collect(Collectors.groupingBy(wwr -> wwr, Collectors.counting()));
        wordsOccurrences.forEach((word, count) -> {
            System.out.println(word + " --> " + count);
        });

        // TODO: 2 - Find the most common word in 'wordsWithRepeats'
        //           Group by word, count occurrences, then find the entry with max value
        //           Hint: Use entrySet().stream() on the grouped map, then max()
        //           Print the word and its count
        System.out.println("\n## Word more present in wordsWithRepeats ##");
        Map<String, Long> occurrences = wordsWithRepeats.stream().collect(Collectors.groupingBy(wwr -> wwr, Collectors.counting()));
        Optional<Map.Entry<String, Long>> max = occurrences.entrySet().stream().max(Map.Entry.comparingByValue());
        System.out.println(max.get().getKey() + " --> " + max.get().getValue());


        // TODO: 3 - Use Collectors.partitioningBy to split 'numbers' into even and odd
        //           Result type: Map<Boolean, List<Integer>>
        //           Print the even numbers (key=true) and odd numbers (key=false)
        System.out.println("\n## Splits odd and even from numbers list ##");
        Map<Boolean, List<Integer>> evenAndOdd = numbers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        evenAndOdd.forEach((key, numbs) -> {
            System.out.println(key == true ? "even:" : "odd:");
            numbs.forEach(n -> System.out.print(n + "    "));
            System.out.println("\n-------------------");
        });


        // TODO: 4 - Partition 'students' into those with grade >= 85 (pass) and below (fail)
        //           Print each group
        System.out.println("\n## Divide students into those who pass the exam and those who fail. ##");
        Map<Boolean, List<Student>> splitter = students.stream().collect(Collectors.partitioningBy(s -> s.grade() >= 85));
        splitter.forEach((key, stds) -> {
            System.out.println(key == true ? "Pass:" : "Fail:");
            stds.forEach(System.out::println);
            System.out.println("\n-------------------");
        });

        // TODO: 5 - Use Collectors.mapping() within groupingBy:
        //           Group students by subject, but collect only their names (not full objects)
        //           Hint: Collectors.groupingBy(Student::subject, Collectors.mapping(Student::name, Collectors.toList()))
        //           Print each subject and its list of student names
        System.out.println("\n## Groups students and map the result with student's name ##");
        Map<String, List<String>> studentsPerSubject =
                students.stream().collect(Collectors.groupingBy(Student::subject, Collectors.mapping(Student::name, Collectors.toList())));
        studentsPerSubject.forEach((st, list) -> {
            System.out.print("Subject: " + st + "\n[   ");
            list.forEach(s -> System.out.print(s + "    "));
            System.out.print("]\n-----------------------\n");
        });

        // TODO: 6 - Use maxBy as a downstream collector:
        //           Group students by subject and find the highest-scoring student per subject
        //           Use Collectors.groupingBy with Collectors.maxBy
        //           Print each subject and its top student
        System.out.println("\n## Student with highest score per subject ##");
        Map<String, Optional<Student>> collected =
                students.stream().collect(Collectors.groupingBy(Student::subject, Collectors.maxBy(Comparator.comparingInt(Student::grade))));
        collected.forEach((st, opts) -> {
            System.out.println(st + " --> " + opts.get());
        });
    }
}
