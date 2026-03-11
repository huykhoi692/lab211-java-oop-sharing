package controller;

import bo.DoctorManager;
import entity.Doctor;
import util.Validation;

import java.util.HashMap;
import java.util.Scanner;

public class DoctorController {

    private final DoctorManager manager;
    private final Scanner scanner;

    public DoctorController() {
        manager = new DoctorManager();
        scanner = new Scanner(System.in);
    }

    /**
     * Starts the main menu loop of the Doctor Management program.
     */
    public void run() {
        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    addDoctor();
                    break;
                case "2":
                    updateDoctor();
                    break;
                case "3":
                    deleteDoctor();
                    break;
                case "4":
                    searchDoctor();
                    break;
                case "5":
                    running = false;
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose 1-5.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n========= Doctor Management ==========");
        System.out.println("1. Add Doctor");
        System.out.println("2. Update Doctor");
        System.out.println("3. Delete Doctor");
        System.out.println("4. Search Doctor");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private void addDoctor() {
        System.out.println("--------- Add Doctor ----------");

        String code;
        while (true) {
            System.out.print("Enter Code: ");
            code = scanner.nextLine().trim();
            if (!Validation.isValidCode(code)) {
                System.out.println("Code must not be blank. Please re-enter.");
            } else if (manager.existsByCode(code)) {
                System.out.println("Doctor code [" + code + "] is duplicate. Please re-enter.");
            } else {
                break;
            }
        }

        String name;
        while (true) {
            System.out.print("Enter Name: ");
            name = scanner.nextLine().trim();
            if (Validation.isValidName(name)) {
                break;
            }
            System.out.println("Name must not be blank. Please re-enter.");
        }

        String spec;
        while (true) {
            System.out.print("Enter Specialization: ");
            spec = scanner.nextLine().trim();
            if (Validation.isValidSpecialization(spec)) {
                break;
            }
            System.out.println("Specialization must not be blank. Please re-enter.");
        }

        int availability = readAvailability();

        try {
            manager.addDoctor(new Doctor(code, name, spec, availability));
            System.out.println("Doctor added successfully.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void updateDoctor() {
        System.out.println("--------- Update Doctor -------");
        System.out.print("Enter Code: ");
        String code = scanner.nextLine().trim();

        if (!manager.existsByCode(code)) {
            System.out.println("Doctor code does not exist.");
            return;
        }

        Doctor existing = manager.getByCode(code);

        System.out.print("Enter Name (leave blank to keep \"" + existing.getName() + "\"): ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            name = existing.getName();
        } else {
            while (!Validation.isValidName(name)) {
                System.out.println("Name must not be blank. Please re-enter.");
                System.out.print("Enter Name: ");
                name = scanner.nextLine().trim();
                if (name.isEmpty()) {
                    name = existing.getName();
                    break;
                }
            }
        }

        System.out.print("Enter Specialization (leave blank to keep \"" + existing.getSpecialization() + "\"): ");
        String spec = scanner.nextLine().trim();
        if (spec.isEmpty()) {
            spec = existing.getSpecialization();
        } else {
            while (!Validation.isValidSpecialization(spec)) {
                System.out.println("Specialization must not be blank. Please re-enter.");
                System.out.print("Enter Specialization: ");
                spec = scanner.nextLine().trim();
                if (spec.isEmpty()) {
                    spec = existing.getSpecialization();
                    break;
                }
            }
        }

        System.out.print("Enter Availability (leave blank to keep " + existing.getAvailability() + "): ");
        String availStr = scanner.nextLine().trim();
        int availability;
        if (availStr.isEmpty()) {
            availability = existing.getAvailability();
        } else {
            while (!Validation.isValidAvailabilityStr(availStr)) {
                System.out.println("Availability must be a non-negative integer. Please re-enter.");
                System.out.print("Enter Availability: ");
                availStr = scanner.nextLine().trim();
                if (availStr.isEmpty()) {
                    availStr = String.valueOf(existing.getAvailability());
                    break;
                }
            }
            availability = Integer.parseInt(availStr.trim());
        }

        try {
            manager.updateDoctor(new Doctor(code, name, spec, availability));
            System.out.println("Doctor updated successfully.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void deleteDoctor() {
        System.out.println("--------- Delete Doctor -------");
        System.out.print("Enter Code: ");
        String code = scanner.nextLine().trim();
        try {
            manager.deleteDoctor(code);
            System.out.println("Doctor deleted successfully.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void searchDoctor() {
        System.out.println("---------- Search Doctor --------");
        System.out.print("Enter text: ");
        String keyword = scanner.nextLine();
        try {
            HashMap<String, Doctor> results = manager.searchDoctor(keyword);
            System.out.println("--------- Result ------------");
            if (results.isEmpty()) {
                System.out.println("No doctors found.");
            } else {
                printHeader();
                for (Doctor d : results.values()) {
                    System.out.println(d);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void printHeader() {
        System.out.printf("%-10s %-15s %-20s %s%n", "Code", "Name", "Specialization", "Availability");
        System.out.println("--------------------------------------------------");
    }

    /**
     * Prompts the user repeatedly until a valid non-negative integer is entered.
     *
     * @return the parsed availability value entered by the user
     */
    private int readAvailability() {
        while (true) {
            System.out.print("Enter Availability: ");
            String input = scanner.nextLine().trim();
            if (Validation.isValidAvailabilityStr(input)) {
                return Integer.parseInt(input);
            }
            System.out.println("Availability must be a non-negative integer. Please re-enter.");
        }
    }
}
