package controller;

import bo.WorkerManager;
import entity.SalaryHistory;
import entity.SalaryHistory.SalaryStatus;
import entity.Worker;
import util.Validation;

import java.util.List;
import java.util.Scanner;

public class WorkerController {

    private final WorkerManager manager = new WorkerManager();
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Starts the main menu loop of the Worker Management program.
     */
    public void run() {
        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    addWorker();
                    break;
                case "2":
                    upSalary();
                    break;
                case "3":
                    downSalary();
                    break;
                case "4":
                    displaySalary();
                    break;
                case "5":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Choose 1-5.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n======== Worker Management =========");
        System.out.println("1. Add Worker");
        System.out.println("2. Up salary");
        System.out.println("3. Down salary");
        System.out.println("4. Display Information salary");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private void addWorker() {
        System.out.println("--------- Add Worker ----------");

        String id;
        while (true) {
            System.out.print("Enter Code: ");
            id = scanner.nextLine().trim();
            if (!Validation.isValidCode(id)) {
                System.out.println("Code must not be blank.");
            } else if (manager.existsById(id)) {
                System.out.println("Worker code [" + id + "] is duplicate. Please re-enter.");
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
            System.out.println("Name must not be blank.");
        }

        int age = 0;
        while (true) {
            System.out.print("Enter Age (18-50): ");
            String ageStr = scanner.nextLine().trim();
            if (Validation.isValidAgeStr(ageStr)) {
                age = Integer.parseInt(ageStr);
                break;
            }
            System.out.println("Age must be between 18 and 50.");
        }

        double salary = 0;
        while (true) {
            System.out.print("Enter Salary: ");
            String salStr = scanner.nextLine().trim();
            if (Validation.isValidSalaryStr(salStr)) {
                salary = Double.parseDouble(salStr);
                break;
            }
            System.out.println("Salary must be greater than 0.");
        }

        String location;
        while (true) {
            System.out.print("Enter work location: ");
            location = scanner.nextLine().trim();
            if (Validation.isValidWorkLocation(location)) {
                break;
            }
            System.out.println("Work location must not be blank.");
        }

        try {
            manager.addWorker(new Worker(id, name, age, salary, location));
            System.out.println("Worker added successfully.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void upSalary() {
        adjustSalary(SalaryStatus.UP);
    }

    private void downSalary() {
        adjustSalary(SalaryStatus.DOWN);
    }

    /**
     * Prompts the user for a worker code and adjustment amount, then applies the salary change.
     *
     * @param status UP to increase salary, DOWN to decrease salary
     */
    private void adjustSalary(SalaryStatus status) {
        if (status == SalaryStatus.UP) {
            System.out.println("------- Up Salary --------");
        } else {
            System.out.println("------- Down Salary --------");
        }
        System.out.print("Enter Code: ");
        String code = scanner.nextLine().trim();

        double amount = 0;
        while (true) {
            System.out.print("Enter Amount: ");
            String amtStr = scanner.nextLine().trim();
            if (Validation.isValidAmountStr(amtStr)) {
                amount = Double.parseDouble(amtStr);
                break;
            }
            System.out.println("Amount must be greater than 0.");
        }

        try {
            manager.changeSalary(status, code, amount);
            System.out.println("Salary updated successfully.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void displaySalary() {
        List<SalaryHistory> list = manager.getInformationSalary();
        System.out.println("--------------------Display Information Salary-----------------------");
        if (list.isEmpty()) {
            System.out.println("No salary adjustment records.");
            return;
        }
        System.out.printf("%-6s %-10s %-6s %-10s %-6s %s%n", "Code", "Name", "Age", "Salary", "Status", "Date");
        for (SalaryHistory h : list) {
            System.out.println(h);
        }
    }
}
