/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package insertion_sort;

import java.util.Random;

/**
 * Represents an integer array for insertion sort processing.
 *
 * @author khois
 */
public class MyArray {

    private final int[] arr;

    /**
     * Constructs random array with size n.
     *
     * @param n number of elements
     */
    public MyArray(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Array size must be positive");
        }
        arr = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt((n * 2) + 1) - n;
        }
    }

    /**
     * Sorts array by insertion sort.
     *
     * @return sorted array
     */
    public int[] insertionSort() {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    /**
     * Displays array in format [a, b, c].
     */
    public void display() {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
