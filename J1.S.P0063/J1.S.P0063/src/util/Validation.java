package util;

public class Validation {

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
     * Checks that an address is not null and not blank.
     *
     * @param address the address string to validate
     * @return true if address is not null and not blank, false otherwise
     */
    public static boolean isValidAddress(String address) {
        return address != null && !address.trim().isEmpty();
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
     * Checks that the given string can be parsed as a valid numeric value.
     *
     * @param input the string to parse and validate
     * @return true if input is a parseable number, false otherwise
     */
    public static boolean isNumeric(String input) {
        if (input == null || input.trim().isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(input.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
