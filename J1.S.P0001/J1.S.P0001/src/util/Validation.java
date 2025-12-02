/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.Scanner;

/**
 *
 * @author khois
 */
public class Validation {

    public static final Scanner SCANNER = new Scanner(System.in);

    //Optional - Recommend
    /**
     * Private constructor to prevent instantiation of this utility class.
     *
     * @throws IllegalStateException always thrown to indicate that
     *                               this class should not be instantiated
     */
    private Validation() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Reads an integer from the console within a specific range.
     * <p>
     * The method keeps asking the user until a valid integer is entered and
     * the value is between {@code min} and {@code max} (inclusive).
     * </p>
     *
     * @param msg  the prompt message shown to the user before input
     * @param err1 the error message when the value is out of the given range
     * @param err2 the error message when the input is not a valid integer
     * @param min  minimum acceptable value (inclusive)
     * @param max  maximum acceptable value (inclusive)
     * @return a valid integer within the specified range
     */
    public static int getInt(String msg, String err1, String err2,
            int min, int max) {
        System.out.println(msg);
        int result;
        while (true) {
            try {
                result = Integer.parseInt(SCANNER.nextLine());
                if (result < min || result > max) {
                    System.out.println(err1);
                } else {
                    return result;
                }
            } catch (NumberFormatException e) {
                System.out.println(err2);
            }
        }
    }
}
