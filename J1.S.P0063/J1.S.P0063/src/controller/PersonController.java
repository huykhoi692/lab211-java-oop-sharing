package controller;

import bo.PersonManager;
import entity.Person;
import util.Validation;

import java.util.Scanner;

public class PersonController {

    private static final int COUNT = 3;
    private final PersonManager manager = new PersonManager();
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Reads information for all persons, sorts them by salary, then displays the results.
     */
    public void run() {
        System.out.println("=====Management Person programer=====");
        Person[] persons = new Person[COUNT];

        for (int i = 0; i < COUNT; i++) {
            persons[i] = inputOnePerson();
        }

        try {
            Person[] sorted = manager.sortBySalary(persons);
            for (Person p : sorted) {
                displayPersonInfo(p);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Prompts the user to enter name, address, and salary for one person.
     *
     * @return a valid Person object with the entered data
     */
    private Person inputOnePerson() {
        System.out.println("Input Information of Person");

        String name;
        while (true) {
            System.out.print("Please input name:");
            name = scanner.nextLine().trim();
            if (Validation.isValidName(name)) {
                break;
            }
            System.out.println("Name must not be blank.");
        }

        String address;
        while (true) {
            System.out.print("Please input address:");
            address = scanner.nextLine().trim();
            if (Validation.isValidAddress(address)) {
                break;
            }
            System.out.println("Address must not be blank.");
        }

        while (true) {
            System.out.print("Please input salary:");
            String salStr = scanner.nextLine().trim();
            try {
                Person p = manager.inputPersonInfo(name, address, salStr);
                return p;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Displays the full information of a person to the console.
     *
     * @param person the Person object to display
     */
    private void displayPersonInfo(Person person) {
        System.out.println("\nInformation of Person you have entered:");
        System.out.println("Name:" + person.getName());
        System.out.println("Address:" + person.getAddress());
        System.out.println("Salary:" + person.getSalary());
    }
}
