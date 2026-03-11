package entity;

import util.Validation;

public class Worker {

    private String id;
    private String name;
    private int age;
    private double salary;
    private String workLocation;

    public Worker() {
    }

    /**
     * Creates a Worker with all fields validated.
     *
     * @param id           the worker's unique ID code
     * @param name         the worker's name
     * @param age          the worker's age (must be 18–50)
     * @param salary       the worker's salary (must be > 0)
     * @param workLocation the worker's work location
     * @throws IllegalArgumentException if any field is invalid
     */
    public Worker(String id, String name, int age, double salary, String workLocation) {
        setId(id);
        setName(name);
        setAge(age);
        setSalary(salary);
        setWorkLocation(workLocation);
    }

    /**
     * @return the worker's unique ID
     */
    public String getId() {
        return id;
    }

    /**
     * @return the worker's name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the worker's age
     */
    public int getAge() {
        return age;
    }

    /**
     * @return the worker's current salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * @return the worker's work location
     */
    public String getWorkLocation() {
        return workLocation;
    }

    /**
     * @param id the ID to set
     * @throws IllegalArgumentException if id is null or blank
     */
    public void setId(String id) {
        if (!Validation.isValidCode(id)) {
            throw new IllegalArgumentException("Worker ID must not be blank.");
        }
        this.id = id.trim();
    }

    /**
     * @param name the name to set
     * @throws IllegalArgumentException if name is null or blank
     */
    public void setName(String name) {
        if (!Validation.isValidName(name)) {
            throw new IllegalArgumentException("Name must not be blank.");
        }
        this.name = name.trim();
    }

    /**
     * @param age the age to set
     * @throws IllegalArgumentException if age is not between 18 and 50
     */
    public void setAge(int age) {
        if (!Validation.isValidAge(age)) {
            throw new IllegalArgumentException("Age must be between 18 and 50.");
        }
        this.age = age;
    }

    /**
     * @param salary the salary to set
     * @throws IllegalArgumentException if salary is not greater than 0
     */
    public void setSalary(double salary) {
        if (!Validation.isValidSalary(salary)) {
            throw new IllegalArgumentException("Salary must be greater than 0.");
        }
        this.salary = salary;
    }

    /**
     * Updates the salary directly without validation.
     * Used internally by the BO layer when applying salary adjustments.
     *
     * @param newSalary the new salary value to apply
     */
    public void applySalaryChange(double newSalary) {
        this.salary = newSalary;
    }

    /**
     * @param workLocation the work location to set
     * @throws IllegalArgumentException if workLocation is null or blank
     */
    public void setWorkLocation(String workLocation) {
        if (!Validation.isValidWorkLocation(workLocation)) {
            throw new IllegalArgumentException("Work location must not be blank.");
        }
        this.workLocation = workLocation.trim();
    }
}
