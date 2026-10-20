package com.amigoscode._5_generics._5_boundedtypes;

import java.util.Arrays;
import java.util.List;

/**
 * Exercise: Upper Bounded Type Parameters
 *
 * This exercise demonstrates bounded type parameters using "extends".
 * When you write <T extends Number>, T can only be Number or its subclasses
 * (Integer, Double, Long, etc.). This lets you call Number methods like
 * doubleValue() on values of type T.
 *
 * Complete the TODOs below.
 */
public class UpperBound {

    // To do: 1 - Create a static generic method: <T extends Number> double sum(List<T> list)
    //  It should return the sum of all elements as a double.
    //  Use the doubleValue() method on each element (available because T extends Number).
    static <T extends Number> double sum(List<T> list) {
        double sum = 0;
        for (T number : list) {
            sum+= number.doubleValue();
        }
        return sum;
    }


    // To do: 2 - Create a static generic method: <T extends Number> T findMax(List<T> list)
    //  It should return the largest element in the list.
    //  Compare elements using doubleValue(). If the list is empty, return null.
    static <T extends Number> T findMax(List<T> list) {
        if (list.isEmpty()) return null;
        T result = list.get(0);
        for (T number : list) {
            result = Math.max(number.doubleValue(), result.doubleValue()) == result.doubleValue() ? result : number;
        }
        return result;
    }

    public static void main(String[] args) {

        // TODO: 6 - Test sum() and findMax() with:
        //  (a) A List<Integer> e.g., Arrays.asList(1, 2, 3, 4, 5)
        //  (b) A List<Double> e.g., Arrays.asList(1.5, 2.5, 3.5)
        //  Print the results for each.
        //  Also create a NumberBox<Integer> and NumberBox<Double> and test
        //  isPositive(), toInt(), and toDouble().
        List<Integer> ints = Arrays.asList(10,50,20,30,40);
        System.out.println("max in " + ints + ": " + findMax(ints));
        List<Double> doubles = Arrays.asList(10.0,50.0,20.0,30.0,40.0);
        System.out.println("max in " + doubles + ": " + findMax(doubles));

        NumberBox<Integer> nbI = new NumberBox<>(-34);
        NumberBox<Double> nbD = new NumberBox<>(34.45);
        System.out.println("is positive integer:" + nbI.isPositive());
        System.out.println("is positive floating:" + nbD.isPositive());
        System.out.println("integer to double:" + nbI.toDouble());
        System.out.println("floating to integer:" + nbD.toInt());

        // To do: 7 - Uncomment the line below and observe the compile error.
        //  Then comment it back out and add a comment explaining why it fails.
//         List<String> strings = Arrays.asList("a", "b");
//         double result = sum(strings);  // Why does this not compile?
        //The code above doesn't compile because is passed a list of 'String' but the method accepts only Instance that extends the class 'Nuber'.

    }
}

// T0 do: 3 - Create a generic class NumberBox<T extends Number> with a private T field
//  called "number" and a constructor that takes T.
class  NumberBox <T extends Number> {
    private T number;
    public NumberBox(T number) {
        this.number = number;
    }
    // To do: 4 - In NumberBox, add an isPositive() method that returns true if the
    //  stored number's doubleValue() is greater than 0.
    boolean isPositive() {
        return number.doubleValue() >= 0;
    }
    // To do: 5 - In NumberBox, add toInt() and toDouble() conversion methods that
    //  return the stored number as an int (using intValue()) and as a double
    //  (using doubleValue()) respectively.
    int toInt() {
        return this.number.intValue();
    }
    double toDouble() {
        return this.number.doubleValue();
    }
}
