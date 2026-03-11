/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.Calendar;

/**
 *
 * @author khois
 */
public class Validation {
    public static boolean isNonEmptyString(String value) {
        return value != null && value.isEmpty();
    }
    public static boolean isValidYob(int value) {
        return 1900 <= value && value <= Calendar.getInstance().get(Calendar.YEAR);
    }
    
    public static boolean isValidPhoneNumber(String value) {
        return value.matches("\\d{10}");
    }
    
    public static boolean isValidEmail(String value) {
        return value.matches("^[A-Za-z](.*)([@]{1})(.{2,})(\\\\.)(.{2,})");
    }
    
    public static boolean isValidYearOfExp(int value) {
        return 0 <= value && value <= 100;
    }
}
