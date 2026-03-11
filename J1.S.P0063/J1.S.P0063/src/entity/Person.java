package entity;

public class Person {

    private String name;
    private String address;
    private double salary;

    public Person() {
    }

    /**
     * Creates a Person with all fields validated.
     *
     * @param name    the person's full name
     * @param address the person's address
     * @param salary  the person's salary (must be > 0)
     * @throws IllegalArgumentException if any field is invalid
     */
    public Person(String name, String address, double salary) {
        setName(name);
        setAddress(address);
        setSalary(salary);
    }

    /**
     * @return the person's name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the person's address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @return the person's salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * @param name the name to set
     * @throws IllegalArgumentException if name is null or blank
     */
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name must not be blank.");
        }
        this.name = name.trim();
    }

    /**
     * @param address the address to set
     * @throws IllegalArgumentException if address is null or blank
     */
    public void setAddress(String address) {
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Address must not be blank.");
        }
        this.address = address.trim();
    }

    /**
     * @param salary the salary to set
     * @throws IllegalArgumentException if salary is not greater than 0
     */
    public void setSalary(double salary) {
        if (salary <= 0) {
            throw new IllegalArgumentException("Salary is greater than zero");
        }
        this.salary = salary;
    }
}
