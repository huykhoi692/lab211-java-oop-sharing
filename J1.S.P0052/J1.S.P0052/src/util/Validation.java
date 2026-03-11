package util;

public class Validation {

    /**
     * Checks that a country code is not null and not blank.
     *
     * @param code the code string to validate
     * @return true if code is not null and not blank, false otherwise
     */
    public static boolean isValidCode(String code) {
        return code != null && !code.trim().isEmpty();
    }

    /**
     * Checks that a country name is not null and not blank.
     *
     * @param name the name string to validate
     * @return true if name is not null and not blank, false otherwise
     */
    public static boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    /**
     * Checks that a terrain description is not null and not blank.
     *
     * @param terrain the terrain string to validate
     * @return true if terrain is not null and not blank, false otherwise
     */
    public static boolean isValidTerrain(String terrain) {
        return terrain != null && !terrain.trim().isEmpty();
    }

    /**
     * Checks that total area is greater than zero.
     *
     * @param area the area value to validate
     * @return true if area is greater than 0, false otherwise
     */
    public static boolean isValidTotalArea(float area) {
        return area > 0;
    }

    /**
     * Checks that the given string can be parsed as a float greater than zero.
     *
     * @param input the string to parse and validate
     * @return true if input represents a float greater than 0, false otherwise
     */
    public static boolean isValidTotalAreaStr(String input) {
        if (input == null || input.trim().isEmpty()) {
            return false;
        }
        try {
            float value = Float.parseFloat(input.trim());
            return value > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
