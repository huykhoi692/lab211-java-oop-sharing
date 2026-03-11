package bo;

import entity.Person;

public class PersonManager {

    /**
     * Validates salary input and creates a Person object.
     *
     * @param name    the person's name
     * @param address the person's address
     * @param sSalary the salary as a string (must be a positive number)
     * @return a new Person object if all inputs are valid
     * @throws Exception if sSalary is blank, not numeric, or not greater than zero
     */
    public Person inputPersonInfo(String name, String address, String sSalary) throws Exception {
        if (sSalary == null || sSalary.trim().isEmpty()) {
            throw new Exception("You must input Salary.");
        }
        double salary;
        try {
            salary = Double.parseDouble(sSalary.trim());
        } catch (NumberFormatException e) {
            throw new Exception("You must input digit.");
        }
        if (salary <= 0) {
            throw new Exception("Salary is greater than zero");
        }
        return new Person(name, address, salary);
    }

    /**
     * Sorts an array of persons by salary in ascending order using bubble sort.
     *
     * @param persons the array of Person objects to sort
     * @return the sorted array of Person objects
     * @throws Exception if the array is null or empty
     */
    public Person[] sortBySalary(Person[] persons) throws Exception {
        if (persons == null || persons.length == 0) {
            throw new Exception("Can't Sort Person");
        }
        for (int i = 0; i < persons.length - 1; i++) {
            for (int j = 0; j < persons.length - 1 - i; j++) {
                if (persons[j].getSalary() > persons[j + 1].getSalary()) {
                    Person tmp = persons[j];
                    persons[j] = persons[j + 1];
                    persons[j + 1] = tmp;
                }
            }
        }
        return persons;
    }
}
