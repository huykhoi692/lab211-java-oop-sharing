package linear_search;

import java.util.Random;

/**
 * Represents an integer array for linear search processing.
 */
public class MyArray {

    private final int[] arr;

    public MyArray(int n) {
        if (n <= 0) throw new IllegalArgumentException("Array size must be positive");
        arr = new int[n];
        Random rd = new Random();
        for (int i = 0; i < n; i++) arr[i] = rd.nextInt((n * 2) + 1) - n;
    }

    public int linearSearch(int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) return i;
        }
        return -1;
    }

    public void display() {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
