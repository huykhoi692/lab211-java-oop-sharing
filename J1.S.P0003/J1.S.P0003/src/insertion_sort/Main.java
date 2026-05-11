/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package insertion_sort;

import util.Validation;

/**
 * Main class for insertion sort demo.
 *
 * @author khois
 */
public class Main {

    public static void main(String[] args) {
        MyArray myArray = new MyArray(Validation.getInt(
                "Enter number of array: ", "Out of range",
                "Must be an integer number", 1, Integer.MAX_VALUE));

        System.out.print("Unsorted array: ");
        myArray.display();

        myArray.insertionSort();
        System.out.print("Sorted array: ");
        myArray.display();
    }
}
