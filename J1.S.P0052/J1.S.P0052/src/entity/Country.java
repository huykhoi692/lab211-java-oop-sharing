package entity;

import util.Validation;

public class Country {

    protected String countryCode;
    protected String countryName;
    protected float totalArea;

    public Country() {
    }

    /**
     * Creates a Country with all fields validated.
     *
     * @param countryCode the country's unique code
     * @param countryName the country's name
     * @param totalArea   the country's total area (must be > 0)
     * @throws IllegalArgumentException if any field is invalid
     */
    public Country(String countryCode, String countryName, float totalArea) {
        setCountryCode(countryCode);
        setCountryName(countryName);
        setTotalArea(totalArea);
    }

    /**
     * @return the country's unique code
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * @return the country's name
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * @return the country's total area
     */
    public float getTotalArea() {
        return totalArea;
    }

    /**
     * @param countryCode the country code to set
     * @throws IllegalArgumentException if countryCode is null or blank
     */
    public void setCountryCode(String countryCode) {
        if (!Validation.isValidCode(countryCode)) {
            throw new IllegalArgumentException("Country code must not be blank.");
        }
        this.countryCode = countryCode.trim();
    }

    /**
     * @param countryName the country name to set
     * @throws IllegalArgumentException if countryName is null or blank
     */
    public void setCountryName(String countryName) {
        if (!Validation.isValidName(countryName)) {
            throw new IllegalArgumentException("Country name must not be blank.");
        }
        this.countryName = countryName.trim();
    }

    /**
     * @param totalArea the total area to set
     * @throws IllegalArgumentException if totalArea is not greater than 0
     */
    public void setTotalArea(float totalArea) {
        if (!Validation.isValidTotalArea(totalArea)) {
            throw new IllegalArgumentException("Total area must be greater than 0.");
        }
        this.totalArea = totalArea;
    }

    /**
     * Displays the country's information to the console.
     */
    public void display() {
        System.out.printf("%-16s%-16s%-16s%n", countryCode, countryName, totalArea);
    }
}
