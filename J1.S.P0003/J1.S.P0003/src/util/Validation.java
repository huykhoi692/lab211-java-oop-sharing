/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.Scanner;

/**
 * Utility class for validating console input.
 *
 * @author khois
 */
public class Validation {

    public static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Prevents instantiation of utility class.
     */
    private Validation() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Reads an integer in range [min, max].
     *
     * @param msg prompt message
     * @param err1 out-of-range message
     * @param err2 invalid-number message
     * @param min minimum value
     * @param max maximum value
     * @return valid integer value
     */
    public static int getInt(String msg, String err1, String err2, int min, int max) {
        System.out.println(msg);
        while (true) {
            try {
                int result = Integer.parseInt(SCANNER.nextLine());
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
