/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selection_sort;

import java.util.Random;

/**
 *
 * @author khois
 */

public class MyArray {

    private int[] arr;
    
    /**
     * Constructs a {@code MyArray} of the given size and fills it with
     * random integers in the range [-n, n).
     *
     * @param n the size of the array; must be non-negative
     * @throws IllegalArgumentException if {@code n} is negative
     */
    public MyArray(int n){
        if (n <= 0) {
            throw new IllegalArgumentException("Array size must be positive");
        }
        arr = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] =  random.nextInt((n * 2) + 1) - n;
        }
    }

    public int[] getArr() {
        return arr;
    }

    /**
     * Swaps two elements in the internal array.
     *
     * @param a index of the first element to swap
     * @param b index of the second element to swap
     * @throws ArrayIndexOutOfBoundsException if {@code a} or {@code b}
     *                                        are not valid indices
     */
    private void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * Sorts the internal array in ascending order using the Selection Sort algorithm.
     * <p>
     * For each position {@code i}, the algorithm finds the smallest element
     * in the sub-array {@code [i, n-1]} and swaps it with the element at {@code i}.
     * </p>
     *
     * @return the sorted integer array
     */
    public int[] selectionSort() {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(i, minIndex);
            }
        }
        return arr;
    }
    
    /**
     * Prints the contents of the internal array to the console
     * in a readable format (e.g., {@code [1, 2, 3]}).
     * <p>
     * If the array is {@code null} or empty, it simply prints an empty line.
     * </p>
     */
    public void display() {
        if (arr == null || arr.length == 0) {
            System.out.println();
            return;
        }
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
