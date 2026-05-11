package quick_sort;

import java.util.Random;

/**
 * Represents an integer array for quick sort processing.
 */
public class MyArray {

    private final int[] arr;

    public MyArray(int n) {
        if (n <= 0) throw new IllegalArgumentException("Array size must be positive");
        arr = new int[n];
        Random rd = new Random();
        for (int i = 0; i < n; i++) arr[i] = rd.nextInt((n * 2) + 1) - n;
    }

    public void quickSort() {
        quickSort(0, arr.length - 1);
    }

    private void quickSort(int left, int right) {
        int i = left, j = right;
        int pivot = arr[(left + right) / 2];
        while (i <= j) {
            while (arr[i] < pivot) i++;
            while (arr[j] > pivot) j--;
            if (i <= j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        if (left < j) quickSort(left, j);
        if (i < right) quickSort(i, right);
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
