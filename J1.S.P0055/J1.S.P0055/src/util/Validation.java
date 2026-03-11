package util;

public class Validation {

    /**
     * Checks that a doctor code is not null and not blank.
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
     * Checks that a specialization is not null and not blank.
     *
     * @param specialization the specialization string to validate
     * @return true if specialization is not null and not blank, false otherwise
     */
    public static boolean isValidSpecialization(String specialization) {
        return specialization != null && !specialization.trim().isEmpty();
    }

    /**
     * Checks that availability is a non-negative integer.
     *
     * @param availability the integer value to validate
     * @return true if availability is greater than or equal to 0, false otherwise
     */
    public static boolean isValidAvailability(int availability) {
        return availability >= 0;
    }

    /**
     * Checks that the given string can be parsed as a non-negative integer.
     *
     * @param input the string to parse and validate
     * @return true if input represents a non-negative integer, false otherwise
     */
    public static boolean isValidAvailabilityStr(String input) {
        if (input == null || input.trim().isEmpty()) {
            return false;
        }
        try {
            int value = Integer.parseInt(input.trim());
            return value >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
