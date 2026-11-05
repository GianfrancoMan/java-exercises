package com.amigoscode._7_streams._7_statistics;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Exercise: GroupingBy
 *
 * Learn how to use Collectors.groupingBy() to group stream elements
 * into a Map. Practice with downstream collectors for counting, summing,
 * and multi-level grouping.
 */
public class GroupingBy {

    record Person(String name, int age, String city) {}

    record Order(String product, double amount, String status) {}

    static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Alice", 30, "London"),
                new Person("Bob", 25, "Paris"),
                new Person("Charlie", 35, "London"),
                new Person("Diana", 22, "Berlin"),
                new Person("Eve", 28, "Paris"),
                new Person("Frank", 45, "Berlin"),
                new Person("Grace", 19, "London"),
                new Person("Henry", 33, "Paris")
        );

        List<Order> orders = List.of(
                new Order("Laptop", 999.99, "COMPLETED"),
                new Order("Mouse", 29.99, "PENDING"),
                new Order("Keyboard", 79.99, "COMPLETED"),
                new Order("Monitor", 449.99, "SHIPPED"),
                new Order("Headset", 59.99, "PENDING"),
                new Order("Webcam", 39.99, "COMPLETED"),
                new Order("Cable", 9.99, "SHIPPED")
        );

        List<String> words = List.of(
                "apple", "banana", "avocado", "blueberry", "cherry",
                "apricot", "blackberry", "coconut", "cranberry", "almond"
        );

        // TODO: 1 - Group 'people' by city
        //           Result type: Map<String, List<Person>>
        //           Print each city and its list of people
        System.out.println("\n### Grouping people by city ###");
        Map<String, List<Person>> groupedByCity = people.stream().collect(Collectors.groupingBy(Person::city));
        groupedByCity.forEach((city, persons) -> {
            System.out.println(city + ":");
            persons.forEach(System.out::println);
            System.out.println("-----------");
        });

        // TODO: 2 - Group 'orders' by status
        //           Print each status and its list of orders
        System.out.println("\n### Grouping ordes by status ###");
        Map<String, List<Order>> groupedByStatus = orders.stream().collect(Collectors.groupingBy(Order::status));
        groupedByStatus.forEach((status, ords) -> {
            System.out.println(status + ":");
            ords.forEach(System.out::println);
            System.out.println("-----------");
        });

        // TODO: 3 - Group 'words' by their first letter
        //           Hint: Use word.charAt(0) or word.substring(0, 1)
        //           Print each letter and its words
        System.out.println("\n### Grouping words by their first char ###");
        Map<Character, List<String>> wordsByFirstChar = words.stream().collect(Collectors.groupingBy(word -> word.charAt(0)));
        wordsByFirstChar.forEach((character, wrds) -> {
            System.out.println(character + ":");
            wrds.forEach(System.out::println);
            System.out.println("-----------");
        });
        // TODO: 4 - Group 'orders' by status and count how many orders per status
        //           Use Collectors.groupingBy with Collectors.counting() as downstream
        //           Print each status and its count
        System.out.println("\n### Counting total orders per status###");
        orders.stream().collect(Collectors.groupingBy(Order::status, Collectors.counting()))
                .forEach((status, count) -> {
                    System.out.println("Total " + status + " orders: " + count);
                });

        // TODO: 5 - Group 'orders' by status and sum the amounts per status
        //           Use Collectors.groupingBy with Collectors.summingDouble as downstream
        //           Print each status and its total amount
        System.out.println("\n### Grouping ordes by status and get their amounts ###");
        orders.stream().collect(Collectors.groupingBy(Order::status, Collectors.summingDouble(order -> order.amount)))
                .forEach((status, amount) -> {
                    System.out.println("Total amount of " + status + " orders: " + amount);
                });

        // TODO: 6 - Group 'people' by city and collect names to a Set
        //           Use Collectors.groupingBy with Collectors.mapping + Collectors.toSet()
        //           Print each city and its set of names
        System.out.println("\n### Grouping people by city and remove name's duplications ###");
        people.stream().collect(Collectors.groupingBy(Person::city, Collectors.mapping(Person::name, Collectors.toSet())))
                .forEach((city, names) -> {
                    System.out.println("Names present in " + city + ":");
                    System.out.println(String.join(", ", names));
                    System.out.println("_____________________");
                });


        // TODO: 7 - Multi-level grouping: group 'people' by city, then by age range
        //           Age ranges: "Young" (< 25), "Adult" (25-35), "Senior" (> 35)
        //           Use nested groupingBy
        //           Hint: Create a helper method getAgeRange(int age)
        //           Print the result
        System.out.println("\n### Grouping people by cities and range of ages ###");
        Map<String, Map<String, List<Person>>> peopleByCityAndAgeRange =
                people.stream().collect(Collectors.groupingBy(Person::city, Collectors.groupingBy(p -> getAgeRange(p.age()))));

        peopleByCityAndAgeRange.forEach((city, ageRanges) -> {
            System.out.println(city + ":");
            ageRanges.forEach((range, person) -> {
                System.out.println("\t\t" + range + ":");
                person.forEach(p -> System.out.println("\t\t\t" + p));
            });
            System.out.println("______________________");
        });
    }

    // Helper method for TODO 7
    private static String getAgeRange(int age) {
        if (age < 25) return "Young";
        if (age <= 35) return "Adult";
        return "Senior";
    }
}
