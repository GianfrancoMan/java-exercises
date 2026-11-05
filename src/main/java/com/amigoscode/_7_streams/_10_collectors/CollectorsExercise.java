package com.amigoscode._7_streams._10_collectors;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

/**
 * Exercise: Advanced Collectors
 *
 * Practice using advanced collectors including toMap(), toUnmodifiableList(),
 * partitioningBy(), collectingAndThen(), and teeing().
 */
public class CollectorsExercise {

    record Person(String name, int age, String city) {}

    record Product(String name, double price, String category) {}

    static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie", "Diana", "Eve");

        List<Person> people = List.of(
                new Person("Alice", 30, "London"),
                new Person("Bob", 25, "Paris"),
                new Person("Charlie", 35, "London"),
                new Person("Diana", 22, "Berlin"),
                new Person("Eve", 28, "Paris")
        );

        List<Product> products = List.of(
                new Product("Laptop", 999.99, "Electronics"),
                new Product("Mouse", 29.99, "Electronics"),
                new Product("Desk", 299.99, "Furniture"),
                new Product("Chair", 199.99, "Furniture"),
                new Product("Keyboard", 79.99, "Electronics")
        );

        List<Person> peopleWithDuplicateCities = List.of(
                new Person("Alice", 30, "London"),
                new Person("Bob", 25, "London"),
                new Person("Charlie", 35, "Paris")
        );

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // TODO: 1 - Collect 'names' to an unmodifiable list
        //           Use Collectors.toUnmodifiableList() or stream .toList()
        //           Print the result and try to verify it's unmodifiable
        //           (optional: try adding to it and catch UnsupportedOperationException)
        System.out.println("\n#### Create unmodifiable list using Collectors.toUnmodifiableList method ####");
        List<String> unmodifiableList = names.stream().collect(Collectors.toUnmodifiableList());
        System.out.println(unmodifiableList);
//        unmodifiableList.add("ILLO"); //the code compile, but there is a RuntimeException because the list immutable.
//        System.out.println(unmodifiableList);

        // TODO: 2 - Collect 'people' to a Map where key is name and value is age
        //           Use Collectors.toMap(Person::name, Person::age)
        //           Print the resulting map
        System.out.println(
                "\n#### Collect 'people' to a Map where key is name and value is age Print the result and try to verify it's unmodifiable ####");

//        Map<String, Integer> toMapByCollectors = people.stream().collect(Collectors.toMap(p -> p.name(), p -> p.age()));
        Map<String, Integer> toMapByCollectors = people.stream().collect(Collectors.toMap(Person::name, Person::age));
        System.out.println(toMapByCollectors);
        toMapByCollectors.put("ILLO",120); //unlike the toList method, the Map returned by the Collectors.toMap method is non-immutable.
        System.out.println(toMapByCollectors);

        // TODO: 3 - Handle duplicate keys in toMap:
        //           Collect 'peopleWithDuplicateCities' to a Map<String, String>
        //           where key is city and value is name
        //           Since London appears twice, use a merge function: (name1, name2) -> name1 + ", " + name2
        //           Print the result
        System.out.println("\n#### Handle duplicate keys in toMap ####");
        System.out.println(
                peopleWithDuplicateCities.stream().collect(Collectors.toMap(Person::city, Person::name, (n1, n2) -> n1 + ", " + n2))
        );

        // TODO: 4 - Collect 'people' to a ConcurrentMap using Collectors.toConcurrentMap()
        //           Key: name, Value: city
        //           Print the result and its class name
        System.out.println("\n#### Handle duplicate keys in toMap ####");
        ConcurrentMap<String, String> concurrentMap = peopleWithDuplicateCities.stream().collect(Collectors.toConcurrentMap(Person::name, Person::city));
        System.out.println(concurrentMap);
        System.out.println(concurrentMap.getClass().getName());

        // TODO: 5 - Use Collectors.partitioningBy to split 'numbers' into
        //           even (true) and odd (false) groups
        //           Print both partitions
        System.out.println("\n####  split 'numbers' into even (true) and odd (false) groups ####");
        Map<Boolean, List<Integer>> partitioned = numbers.stream().collect(Collectors.partitioningBy(v -> v % 2 == 0));
        partitioned.forEach((k ,v) -> {
            System.out.println(k);
            v.forEach(value -> System.out.print("\t" + value +"\t\t"));
            System.out.println("\n");
        });

        // TODO: 6 - Use Collectors.collectingAndThen to collect 'names' to a list
        //           and then transform the result to its size (count)
        //           Hint: collectingAndThen(Collectors.toList(), List::size)
        //           Print the result
        System.out.println("\n####  collect 'names' to a Set and then transform the result to its size (count) ####");
        Integer sizeToSetToList = names.stream().collect(Collectors.collectingAndThen(Collectors.toSet(), Collection::size));
        System.out.println(sizeToSetToList);

        // TODO: 7 - Use Collectors.teeing() (Java 12+) to compute both the sum
        //           and count of 'numbers' simultaneously, then calculate the average
        //           teeing(Collectors.summingInt(...), Collectors.counting(), (sum, count) -> ...)
        //           Print the calculated average
        Double averageNumbers = numbers.stream().collect(Collectors.teeing(
                Collectors.summingInt(n -> n),
                Collectors.counting(),
                (s, c) -> Double.valueOf(s/c)));
        System.out.println(averageNumbers);
    }
}
