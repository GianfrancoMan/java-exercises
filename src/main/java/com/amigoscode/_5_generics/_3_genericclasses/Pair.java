package com.amigoscode._5_generics._3_genericclasses;

import java.util.Objects;

/**
 * Exercise: Generic Pair Class
 *
 * This exercise has you build a generic Pair<K, V> class that holds
 * two related values of potentially different types, like a key-value pair.
 *
 * Complete the TODOs below.
 */
public class Pair<K, V> {

    // Declare two private fields: one of type K called "key"
    //  and one of type V called "value".
    private K key;
    private V value;


    //  Create a constructor that takes a K key and a V value
    //  and assigns them to the fields.
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }


    //  Add getter methods getKey() and getValue() that return
    //  the key and value respectively.
    public K getKey() {
        return this.key;
    }
    public V getValue() {
        return this.value;
    }


    // Create a swap() method that returns a new Pair<V, K> with
    //  the key and value swapped. For example, Pair<String, Integer>("age", 25)
    //  would return Pair<Integer, String>(25, "age").
    public Pair<V, K> swap() {
        return new Pair<>(this.value, this.key);
    }


    // Override toString() to return "Pair{key=" + key + ", value=" + value + "}".
    @Override
    public String toString() {
        return "Pair{key=" + key + ", value=" + value + '}';
    }


    // Override equals(Object o) to compare two Pairs based on both
    //  key and value fields. Use Objects.equals() for null-safe comparison.
    //  Also override hashCode() using Objects.hash(key, value).
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair<?, ?> pair)) return false;
        return Objects.equals(getKey(), pair.getKey()) && Objects.equals(getValue(), pair.getValue());    }

    @Override
    public int hashCode() {
        return Objects.hash(getKey(), getValue());
    }

    public static void main(String[] args) {

        // Create a Pair<String, Integer> representing a person's
        //  name and age (e.g., "Alice", 30). Print the pair. Call swap()
        //  and print the swapped pair. Create another pair with the same
        //  name and age, and test equals() between the two.
        Pair<String, Integer> pair1 = new Pair<>("Alice", 30);
        System.out.println(pair1);
        Pair<Integer,String> swapped = pair1.swap();
        System.out.println(swapped);
        Pair<String, Integer> pair2 = new Pair<>("Alice", 30);
        System.out.println("pair1 == pair2: " + pair1.equals(pair2));
        System.out.println("pair1 == swapped: " + pair1.equals(swapped));
    }
}
