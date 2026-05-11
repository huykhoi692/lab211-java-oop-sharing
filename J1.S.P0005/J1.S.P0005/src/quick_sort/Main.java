package quick_sort;

import util.Validation;

public class Main {
    public static void main(String[] args) {
        MyArray myArray = new MyArray(Validation.getInt("Enter number of array: ", "Out of range", "Must be an integer number", 1, Integer.MAX_VALUE));
        System.out.print("Unsorted array: ");
        myArray.display();
        myArray.quickSort();
        System.out.print("Sorted array: ");
        myArray.display();
    }
}
