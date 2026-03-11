/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.regex.Pattern;

/**
 *
 * @author khois
 */
public class Validation {
    private static final Pattern ACCOUNT_PATTERN = Pattern.compile("(\\d{10})");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(
            "(?=.*[A-Za-z])(?=.*\\d).{8,31}");
    private Validation() {
        
    }
    
    public static boolean isValidAccountNumber(String accountNumber) {
        if (accountNumber == null) {
            return false;
        }
        return ACCOUNT_PATTERN.matcher(accountNumber.trim()).matches();
    }
    
    public static boolean isValidPassword(String password) {
        if (password == null) {
            return false;
        }
        return PASSWORD_PATTERN.matcher(password.trim()).matches();
    }
    
    public static boolean isValidCaptcha(String captcha, String inputCaptcha) {
        if (captcha == null) {
            return false;
        }
        return captcha.equalsIgnoreCase(inputCaptcha.trim());
    }
}
