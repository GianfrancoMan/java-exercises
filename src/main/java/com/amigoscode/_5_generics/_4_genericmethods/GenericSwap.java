package com.amigoscode._5_generics._4_genericmethods;

import java.util.Arrays;

/**
 * Exercise: Generic Swap and Reverse
 *
 * This exercise practices generic methods by implementing swap and reverse
 * operations that work with arrays of any type.
 *
 * Complete the TODOs below.
 */
public class GenericSwap {

    // Create a static generic method: <T> void swap(T[] array, int i, int j)
    //  It should swap the elements at indices i and j in the array.
    //  Use a temporary variable of type T to perform the swap.
    static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    // Create a static generic method: <T> T[] reverse(T[] array)
    //  It should reverse the array in place and return it.
    //  Hint: swap elements from both ends, moving toward the center,
    //  Use the swap() method you wrote in TO DO 1.
    static <T> T[] reverse(T[] arr) {
        T[] reversed = Arrays.copyOf(arr, arr.length);
        for(int i=0, j=reversed.length-1; i<j; i++, j-- ) {
            swap(reversed, i, j);
        }
        return reversed;
    }



    public static void main(String[] args) {

        // Create an Integer[] array {1, 2, 3, 4, 5}.
        //  Use swap() to swap the first and last elements.
        //  Print the result using Arrays.toString().
        Integer[] numbers = {1,2,3,4,5};
        swap(numbers,0,numbers.length-1);
        System.out.println(Arrays.toString(numbers));


        // Create a String[] array {"A", "B", "C", "D"}.
        //  Use swap() to swap elements at index 1 and index 2.
        //  Print the result using Arrays.toString().
        String[]  letters = {"A","B","C","D","E","F","G","H"};
        swap(letters, 1,2);
        System.out.println(Arrays.toString(letters));


        //  Use reverse() on both the Integer[] and String[] arrays.
        //  Print the reversed arrays using Arrays.toString().
        //  Verify the output is correct.
        System.out.println("\n"+Arrays.toString(numbers));
        System.out.println(Arrays.toString(reverse(numbers)));
        System.out.println("\n"+Arrays.toString(letters));
        System.out.println(Arrays.toString(reverse(letters)));


    }
}
