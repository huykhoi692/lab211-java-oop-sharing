package util;

public class Validation {

    /**
     * Checks that a dimension value (side, radius, width, or length) is greater than zero.
     *
     * @param value the dimension value to validate
     * @return true if value is greater than 0, false otherwise
     */
    public static boolean isValidDimension(double value) {
        return value > 0;
    }

    /**
     * Checks that the given string can be parsed as a dimension greater than zero.
     *
     * @param input the string to parse and validate
     * @return true if input represents a double greater than 0, false otherwise
     */
    public static boolean isValidDimensionStr(String input) {
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
     * Validates the triangle inequality: each side must be less than the sum of the other two.
     *
     * @param a the length of side A
     * @param b the length of side B
     * @param c the length of side C
     * @return true if the three sides form a valid triangle, false otherwise
     */
    public static boolean isValidTriangle(double a, double b, double c) {
        return a > 0 && b > 0 && c > 0
                && (a + b > c) && (a + c > b) && (b + c > a);
    }
}
