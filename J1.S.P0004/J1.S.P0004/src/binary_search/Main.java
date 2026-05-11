package binary_search;

import util.Validation;

public class Main {
    public static void main(String[] args) {
        MyArray myArray = new MyArray(Validation.getInt(
                "Enter number of array: ", "Out of range", "Must be an integer number", 1, Integer.MAX_VALUE));
        System.out.print("Unsorted array: ");
        myArray.display();
        myArray.sortAscending();
        System.out.print("Sorted array: ");
        myArray.display();
        int key = Validation.getInt("Enter search value: ", "Out of range", "Must be an integer number", Integer.MIN_VALUE, Integer.MAX_VALUE);
        int index = myArray.binarySearch(key);
        if (index >= 0) System.out.println("Found " + key + " at index: " + index);
        else System.out.println("Not found " + key);
    }
}
