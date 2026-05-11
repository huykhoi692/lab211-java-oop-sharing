package linear_search;

import util.Validation;

public class Main {
    public static void main(String[] args) {
        MyArray myArray = new MyArray(Validation.getInt("Enter number of array: ", "Out of range", "Must be an integer number", 1, Integer.MAX_VALUE));
        System.out.print("Array: ");
        myArray.display();
        int value = Validation.getInt("Enter search value: ", "Out of range", "Must be an integer number", Integer.MIN_VALUE, Integer.MAX_VALUE);
        int index = myArray.linearSearch(value);
        if (index >= 0) System.out.println("Found " + value + " at index: " + index);
        else System.out.println("Not found " + value);
    }
}
