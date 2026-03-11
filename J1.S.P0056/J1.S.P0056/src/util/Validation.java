package util;

public class Validation {

    /**
     * Checks that a worker code is not null and not blank.
     *
     * @param code the code string to validate
     * @return true if code is not null and not blank, false otherwise
     */
    public static boolean isValidCode(String code) {
        return code != null && !code.trim().isEmpty();
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
     * Checks that an age is within the valid range of 18 to 50.
     *
     * @param age the age value to validate
     * @return true if age is between 18 and 50 inclusive, false otherwise
     */
    public static boolean isValidAge(int age) {
        return age >= 18 && age <= 50;
    }

    /**
     * Checks that the given string can be parsed as an age in the range 18 to 50.
     *
     * @param input the string to parse and validate
     * @return true if input represents an integer between 18 and 50, false otherwise
     */
    public static boolean isValidAgeStr(String input) {
        if (input == null || input.trim().isEmpty()) {
            return false;
        }
        try {
            int value = Integer.parseInt(input.trim());
            return isValidAge(value);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Checks that a salary is greater than zero.
     *
     * @param salary the salary value to validate
     * @return true if salary is greater than 0, false otherwise
     */
    public static boolean isValidSalary(double salary) {
        return salary > 0;
    }

    /**
     * Checks that the given string can be parsed as a salary greater than zero.
     *
     * @param input the string to parse and validate
     * @return true if input represents a double greater than 0, false otherwise
     */
    public static boolean isValidSalaryStr(String input) {
        if (input == null || input.trim().isEmpty()) {
            return false;
        }
        try {
            double value = Double.parseDouble(input.trim());
            return value > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Checks that an adjustment amount is greater than zero.
     *
     * @param amount the amount to validate
     * @return true if amount is greater than 0, false otherwise
     */
    public static boolean isValidAmount(double amount) {
        return amount > 0;
    }

    /**
     * Checks that the given string can be parsed as an amount greater than zero.
     *
     * @param input the string to parse and validate
     * @return true if input represents a double greater than 0, false otherwise
     */
    public static boolean isValidAmountStr(String input) {
        if (input == null || input.trim().isEmpty()) {
            return false;
        }
        try {
            double value = Double.parseDouble(input.trim());
            return value > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Checks that a work location is not null and not blank.
     *
     * @param loc the location string to validate
     * @return true if loc is not null and not blank, false otherwise
     */
    public static boolean isValidWorkLocation(String loc) {
        return loc != null && !loc.trim().isEmpty();
    }
}
