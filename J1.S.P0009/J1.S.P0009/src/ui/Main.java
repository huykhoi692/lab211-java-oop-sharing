package ui;

/**
 * J1.S.P0009 – Display 45 Fibonacci numbers using recursion.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("===== Fibonacci Sequence (45 numbers) =====");
        for (int i = 0; i < 45; i++) {
            System.out.println("F(" + i + ") = " + fibonacci(i));
        }
    }

    /**
     * Recursive Fibonacci.
     */
    public static long fibonacci(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}

