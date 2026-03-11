package entity;

import util.Validation;

public class EastAsiaCountry extends Country {

    private String countryTerrain;

    public EastAsiaCountry() {
    }

    /**
     * Creates an EastAsiaCountry with all fields validated.
     *
     * @param countryCode    the country's unique code
     * @param countryName    the country's name
     * @param totalArea      the country's total area (must be > 0)
     * @param countryTerrain the country's terrain description
     * @throws IllegalArgumentException if any field is invalid
     */
    public EastAsiaCountry(String countryCode, String countryName, float totalArea, String countryTerrain) {
        super(countryCode, countryName, totalArea);
        setCountryTerrain(countryTerrain);
    }

    /**
     * @return the country's terrain description
     */
    public String getCountryTerrain() {
        return countryTerrain;
    }

    /**
     * @param countryTerrain the terrain description to set
     * @throws IllegalArgumentException if countryTerrain is null or blank
     */
    public void setCountryTerrain(String countryTerrain) {
        if (!Validation.isValidTerrain(countryTerrain)) {
            throw new IllegalArgumentException("Terrain must not be blank.");
        }
        this.countryTerrain = countryTerrain.trim();
    }

    /**
     * Displays the country's information including terrain to the console.
     */
    @Override
    public void display() {
        System.out.printf("%-16s%-16s%-16s%-16s%n", countryCode, countryName, totalArea, countryTerrain);
    }
}
