package controller;

import bo.CountryManager;
import entity.EastAsiaCountry;
import util.Validation;

import java.util.Scanner;

public class CountryController {

    private final CountryManager manager = new CountryManager();
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Starts the main menu loop of the Country Management program.
     */
    public void run() {
        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    inputCountries();
                    break;
                case "2":
                    displayAll();
                    break;
                case "3":
                    searchByName();
                    break;
                case "4":
                    displaySorted();
                    break;
                case "5":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose 1-5.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n                               MENU");
        System.out.println("==========================================================================");
        System.out.println("1. Input the information of 11 countries in East Asia");
        System.out.println("2. Display the information of country you've just input");
        System.out.println("3. Search the information of country by user-entered name");
        System.out.println("4. Display the information of countries sorted name in ascending order");
        System.out.println("5. Exit");
        System.out.println("==========================================================================");
        System.out.print("Enter your choice: ");
    }

    private void printHeader() {
        System.out.printf("%-16s%-16s%-16s%-16s%n", "ID", "Name", "Total Area", "Terrain");
    }

    private void inputCountries() {
        int remaining = 11 - manager.size();
        if (remaining <= 0) {
            System.out.println("Already entered 11 countries.");
            return;
        }
        System.out.println("Enter information for " + remaining + " country(ies).");
        for (int i = 0; i < remaining; i++) {
            System.out.println("--- Country " + (manager.size() + 1) + " ---");

            String code;
            while (true) {
                System.out.print("Enter code of country: ");
                code = scanner.nextLine().trim();
                if (Validation.isValidCode(code)) {
                    break;
                }
                System.out.println("Code must not be blank.");
            }

            String name;
            while (true) {
                System.out.print("Enter name of country: ");
                name = scanner.nextLine().trim();
                if (Validation.isValidName(name)) {
                    break;
                }
                System.out.println("Name must not be blank.");
            }

            float area = 0;
            while (true) {
                System.out.print("Enter total Area: ");
                String areaStr = scanner.nextLine().trim();
                if (Validation.isValidTotalAreaStr(areaStr)) {
                    area = Float.parseFloat(areaStr);
                    break;
                }
                System.out.println("Total area must be a number greater than 0.");
            }

            String terrain;
            while (true) {
                System.out.print("Enter terrain of country: ");
                terrain = scanner.nextLine().trim();
                if (Validation.isValidTerrain(terrain)) {
                    break;
                }
                System.out.println("Terrain must not be blank.");
            }

            try {
                EastAsiaCountry country = new EastAsiaCountry(code, name, area, terrain);
                manager.addCountryInformation(country);
                System.out.println("Country added.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                i--;
            }
        }
    }

    private void displayAll() {
        if (manager.getAll().isEmpty()) {
            System.out.println("No countries entered yet.");
            return;
        }
        printHeader();
        for (EastAsiaCountry c : manager.getAll()) {
            c.display();
        }
    }

    private void searchByName() {
        System.out.print("Enter the name you want to search for: ");
        String name = scanner.nextLine().trim();
        try {
            EastAsiaCountry[] results = manager.searchInformationByName(name);
            printHeader();
            for (EastAsiaCountry c : results) {
                c.display();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void displaySorted() {
        try {
            EastAsiaCountry[] sorted = manager.sortInformationByAscendingOrder();
            printHeader();
            for (EastAsiaCountry c : sorted) {
                c.display();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
