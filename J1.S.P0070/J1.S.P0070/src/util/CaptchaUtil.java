/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.security.SecureRandom;


/**
 *
 * @author khois
 */
public class CaptchaUtil {
    private static final String CAPTCHA_CHARS = 
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();
    
    private CaptchaUtil() {
        
    }
    
    public static String generateCaptcha(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Captcha length must be positive");
        }
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = SECURE_RANDOM.nextInt(CAPTCHA_CHARS.length());
            stringBuilder.append(CAPTCHA_CHARS.charAt(index));
        }
        return stringBuilder.toString();
    }
}
