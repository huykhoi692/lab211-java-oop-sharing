/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selection_sort;

import util.Validation;

/**
 *
 * @author khois
 */
public class Main {

    public static void main(String[] args) {
        boolean isArray = false;
        while (!isArray) {
            try {
                MyArray myArray = new MyArray(Validation.getInt(
                        "Enter number of array: ", "Out of range",
                        "Must be an integer number",
                        Integer.MIN_VALUE, Integer.MAX_VALUE));
                isArray = true;
                
                System.out.print("Unsorted array: ");
                myArray.display();

                
                myArray.selectionSort();
                System.out.print("Sorted array: ");
                myArray.display();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}