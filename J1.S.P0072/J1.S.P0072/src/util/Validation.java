package util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Validation {

    /**
     * Checks that a username is not null and not blank.
     *
     * @param username the username string to validate
     * @return true if username is not null and not blank, false otherwise
     */
    public static boolean isValidUsername(String username) {
        return username != null && !username.trim().isEmpty();
    }

    /**
     * Checks that a password is not null and not blank.
     *
     * @param password the password string to validate
     * @return true if password is not null and not blank, false otherwise
     */
    public static boolean isValidPassword(String password) {
        return password != null && !password.trim().isEmpty();
    }

    /**
     * Checks that a name is not null and not blank.
     *
     * @param name the name string to validate
     * @return true if name is not null and not blank, false otherwise
     */
    public static boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    /**
     * Validates that a phone number contains exactly 10 or 11 digits.
     *
     * @param phone the phone number string to validate
     * @return true if phone matches the pattern of 10 or 11 digits, false otherwise
     */
    public static boolean isValidPhone(String phone) {
        if (phone == null) {
            return false;
        }
        return phone.trim().matches("\\d{10,11}");
    }

    /**
     * Validates email format using a standard pattern (e.g. user@domain.com).
     *
     * @param email the email string to validate
     * @return true if email matches the expected format, false otherwise
     */
    public static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        return email.trim().matches("^[\\w.+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }

    /**
     * Checks that an address is not null and not blank.
     *
     * @param address the address string to validate
     * @return true if address is not null and not blank, false otherwise
     */
    public static boolean isValidAddress(String address) {
        return address != null && !address.trim().isEmpty();
    }

    /**
     * Validates that a date of birth string matches the dd/MM/yyyy format and is a real calendar date.
     *
     * @param dob the date of birth string to validate
     * @return true if dob is a valid date in dd/MM/yyyy format, false otherwise
     */
    public static boolean isValidDOB(String dob) {
        if (dob == null || dob.trim().isEmpty()) {
            return false;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(dob.trim());
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    /**
     * Computes the MD5 hex hash of the given input string.
     *
     * @param input the plain-text string to hash
     * @return a 32-character lowercase hexadecimal MD5 hash string
     */
    public static String md5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, hash);
            StringBuilder hex = new StringBuilder(number.toString(16));
            while (hex.length() < 32) {
                hex.insert(0, '0');
            }
            return hex.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not found.", e);
        }
    }
}
