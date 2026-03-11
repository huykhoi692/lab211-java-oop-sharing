package bo;

import entity.EastAsiaCountry;
import java.util.ArrayList;
import java.util.List;

public class CountryManager {

    private final List<EastAsiaCountry> countries = new ArrayList<>();

    /**
     * Adds a country to the list.
     *
     * @param country the EastAsiaCountry object to add
     * @throws Exception if country is null or the list already contains 11 entries
     */
    public void addCountryInformation(EastAsiaCountry country) throws Exception {
        if (country == null) {
            throw new Exception("Country data does not exist.");
        }
        if (countries.size() >= 11) {
            throw new Exception("Cannot add more than 11 countries.");
        }
        countries.add(country);
    }

    /**
     * Returns the most recently added country.
     *
     * @return the last EastAsiaCountry added to the list
     * @throws Exception if no country has been added yet
     */
    public EastAsiaCountry getRecentlyEnteredInformation() throws Exception {
        if (countries.isEmpty()) {
            throw new Exception("No country has been entered yet.");
        }
        return countries.get(countries.size() - 1);
    }

    /**
     * Searches countries by name using case-insensitive contains matching.
     *
     * @param name the keyword to search for within country names
     * @return an array of matching EastAsiaCountry objects
     * @throws Exception if no country matching the name is found
     */
    public EastAsiaCountry[] searchInformationByName(String name) throws Exception {
        List<EastAsiaCountry> result = new ArrayList<>();
        String keyword = (name == null) ? "" : name.trim().toLowerCase();
        for (EastAsiaCountry c : countries) {
            if (c.getCountryName().toLowerCase().contains(keyword)) {
                result.add(c);
            }
        }
        if (result.isEmpty()) {
            throw new Exception("No country found with name: " + name);
        }
        return result.toArray(new EastAsiaCountry[0]);
    }

    /**
     * Returns all countries sorted in ascending order by name using bubble sort.
     *
     * @return an array of EastAsiaCountry objects sorted by country name
     * @throws Exception if the list is empty
     */
    public EastAsiaCountry[] sortInformationByAscendingOrder() throws Exception {
        if (countries.isEmpty()) {
            throw new Exception("No countries to sort.");
        }
        EastAsiaCountry[] arr = countries.toArray(new EastAsiaCountry[0]);
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j].getCountryName().compareToIgnoreCase(arr[j + 1].getCountryName()) > 0) {
                    EastAsiaCountry tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }

    /**
     * Returns the full list of countries.
     *
     * @return the List containing all EastAsiaCountry entries
     */
    public List<EastAsiaCountry> getAll() {
        return countries;
    }

    /**
     * Returns the number of countries currently in the list.
     *
     * @return the size of the country list
     */
    public int size() {
        return countries.size();
    }
}
