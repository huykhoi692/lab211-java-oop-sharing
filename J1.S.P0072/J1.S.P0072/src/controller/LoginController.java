package controller;

import bo.AccountManager;
import entity.Account;
import util.Validation;

import java.util.Scanner;

public class LoginController {

    private final AccountManager manager = new AccountManager();
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Starts the main menu loop of the Login Management program.
     */
    public void run() {
        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    addAccount();
                    break;
                case "2":
                    login();
                    break;
                case "3":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Choose 1-3.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n============ Login Program =========");
        System.out.println("1. Add User");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.print("Please choice one option: ");
    }

    private void addAccount() {
        System.out.println("---------- Add User --------");

        String username;
        while (true) {
            System.out.print("Account: ");
            username = scanner.nextLine().trim();
            if (!Validation.isValidUsername(username)) {
                System.out.println("Username must not be blank.");
            } else if (manager.existsByUsername(username)) {
                System.out.println("Username [" + username + "] already exists. Please re-enter.");
            } else {
                break;
            }
        }

        String password;
        while (true) {
            System.out.print("Password: ");
            password = scanner.nextLine().trim();
            if (Validation.isValidPassword(password)) {
                break;
            }
            System.out.println("Password must not be blank.");
        }

        String name;
        while (true) {
            System.out.print("Name: ");
            name = scanner.nextLine().trim();
            if (Validation.isValidName(name)) {
                break;
            }
            System.out.println("Name must not be blank.");
        }

        String phone;
        while (true) {
            System.out.print("Phone: ");
            phone = scanner.nextLine().trim();
            if (Validation.isValidPhone(phone)) {
                break;
            }
            System.out.println("Phone must be 10 or 11 digits.");
        }

        String email;
        while (true) {
            System.out.print("Email: ");
            email = scanner.nextLine().trim();
            if (Validation.isValidEmail(email)) {
                break;
            }
            System.out.println("Email format is invalid (e.g. user@domain.com).");
        }

        String address;
        while (true) {
            System.out.print("Address: ");
            address = scanner.nextLine().trim();
            if (Validation.isValidAddress(address)) {
                break;
            }
            System.out.println("Address must not be blank.");
        }

        String dob;
        while (true) {
            System.out.print("DOB (dd/MM/yyyy): ");
            dob = scanner.nextLine().trim();
            if (Validation.isValidDOB(dob)) {
                break;
            }
            System.out.println("Date of birth must be in dd/MM/yyyy format.");
        }

        try {
            int id = manager.addAccount(username, password, name, phone, email, address, dob);
            System.out.println("Account added successfully. ID = " + id);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void login() {
        System.out.println("------------- Login ----------------");
        System.out.print("Account: ");
        String username = scanner.nextLine().trim();
        System.out.print("Password: ");
        String password = scanner.nextLine().trim();

        boolean success = manager.login(username, password);
        if (success) {
            Account acc = manager.findByUsername(username);
            System.out.println("\n------------ Welcome -----------");
            System.out.println("Hi " + acc.getName() + ", do you want change password now? Y/N:");
            String yn = scanner.nextLine().trim();
            if (yn.equalsIgnoreCase("Y")) {
                changePassword(acc);
            }
        } else {
            System.out.println("Login failed. Username or password is incorrect.");
        }
    }

    /**
     * Verifies the old password and allows the user to set a new password.
     *
     * @param acc the currently logged-in Account whose password will be changed
     */
    private void changePassword(Account acc) {
        System.out.print("Old password: ");
        String oldPass = scanner.nextLine().trim();

        if (!manager.login(acc.getUsername(), oldPass)) {
            System.out.println("Old password is incorrect.");
            return;
        }

        String newPass;
        while (true) {
            System.out.print("New password: ");
            newPass = scanner.nextLine().trim();
            if (Validation.isValidPassword(newPass)) {
                break;
            }
            System.out.println("Password must not be blank.");
        }

        String rePass;
        while (true) {
            System.out.print("Re-enter new password: ");
            rePass = scanner.nextLine().trim();
            if (rePass.equals(newPass)) {
                break;
            }
            System.out.println("Passwords do not match. Please re-enter.");
        }

        acc.setPasswordMd5(Validation.md5(newPass));
        System.out.println("Password changed successfully.");
    }
}
