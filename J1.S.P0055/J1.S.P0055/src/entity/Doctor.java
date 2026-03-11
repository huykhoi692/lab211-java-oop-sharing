package entity;

import util.Validation;

public class Doctor {

    private String code;
    private String name;
    private String specialization;
    private int availability;

    public Doctor() {
    }

    /**
     * Creates a Doctor with all fields validated.
     *
     * @param code           the doctor's unique code
     * @param name           the doctor's name
     * @param specialization the doctor's medical specialization
     * @param availability   the number of available slots (must be >= 0)
     * @throws IllegalArgumentException if any field is invalid
     */
    public Doctor(String code, String name, String specialization, int availability) {
        setCode(code);
        setName(name);
        setSpecialization(specialization);
        setAvailability(availability);
    }

    /**
     * @return the doctor's unique code
     */
    public String getCode() {
        return code;
    }

    /**
     * @return the doctor's name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the doctor's specialization
     */
    public String getSpecialization() {
        return specialization;
    }

    /**
     * @return the doctor's availability count
     */
    public int getAvailability() {
        return availability;
    }

    /**
     * @param code the code to set
     * @throws IllegalArgumentException if code is null or blank
     */
    public void setCode(String code) {
        if (!Validation.isValidCode(code)) {
            throw new IllegalArgumentException("Doctor code must not be blank.");
        }
        this.code = code.trim();
    }

    /**
     * @param name the name to set
     * @throws IllegalArgumentException if name is null or blank
     */
    public void setName(String name) {
        if (!Validation.isValidName(name)) {
            throw new IllegalArgumentException("Doctor name must not be blank.");
        }
        this.name = name.trim();
    }

    /**
     * @param specialization the specialization to set
     * @throws IllegalArgumentException if specialization is null or blank
     */
    public void setSpecialization(String specialization) {
        if (!Validation.isValidSpecialization(specialization)) {
            throw new IllegalArgumentException("Specialization must not be blank.");
        }
        this.specialization = specialization.trim();
    }

    /**
     * @param availability the availability count to set
     * @throws IllegalArgumentException if availability is less than 0
     */
    public void setAvailability(int availability) {
        if (!Validation.isValidAvailability(availability)) {
            throw new IllegalArgumentException("Availability must be >= 0.");
        }
        this.availability = availability;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-15s %-20s %d", code, name, specialization, availability);
    }
}
