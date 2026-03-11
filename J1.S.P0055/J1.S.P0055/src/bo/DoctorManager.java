package bo;

import entity.Doctor;
import java.util.HashMap;

public class DoctorManager {

    private HashMap<String, Doctor> db;

    public DoctorManager() {
        db = new HashMap<>();
    }

    /**
     * Returns all doctors in the database.
     *
     * @return the HashMap containing all Doctor entries
     */
    public HashMap<String, Doctor> getAll() {
        return db;
    }

    /**
     * Adds a new doctor to the database.
     *
     * @param doctor the Doctor object to add
     * @return true if the doctor was added successfully
     * @throws Exception if the database is null, doctor is null, or the code is duplicate
     */
    public boolean addDoctor(Doctor doctor) throws Exception {
        if (db == null) {
            throw new Exception("Database does not exist");
        }
        if (doctor == null) {
            throw new Exception("Data does not exist");
        }
        if (db.containsKey(doctor.getCode())) {
            throw new Exception("Doctor code [" + doctor.getCode() + "] is duplicate");
        }
        db.put(doctor.getCode(), doctor);
        return true;
    }

    /**
     * Updates an existing doctor's information.
     *
     * @param doctor the Doctor object containing updated information
     * @return true if the doctor was updated successfully
     * @throws Exception if the database is null, doctor is null, or the code does not exist
     */
    public boolean updateDoctor(Doctor doctor) throws Exception {
        if (db == null) {
            throw new Exception("Database does not exist");
        }
        if (doctor == null) {
            throw new Exception("Data doesn't exist");
        }
        if (!db.containsKey(doctor.getCode())) {
            throw new Exception("Doctor code doesn't exist");
        }
        db.put(doctor.getCode(), doctor);
        return true;
    }

    /**
     * Deletes a doctor from the database by code.
     *
     * @param code the unique code of the doctor to delete
     * @return true if the doctor was deleted successfully
     * @throws Exception if the database is null, code is null, or the code does not exist
     */
    public boolean deleteDoctor(String code) throws Exception {
        if (db == null) {
            throw new Exception("Database does not exist");
        }
        if (code == null) {
            throw new Exception("Data doesn't exist");
        }
        if (!db.containsKey(code)) {
            throw new Exception("Doctor code doesn't exist");
        }
        db.remove(code);
        return true;
    }

    /**
     * Searches doctors by any field containing the input string (case-insensitive).
     *
     * @param input the keyword to search across all doctor fields
     * @return a HashMap of matching doctors
     * @throws Exception if the database is null
     */
    public HashMap<String, Doctor> searchDoctor(String input) throws Exception {
        if (db == null) {
            throw new Exception("Database does not exist");
        }
        HashMap<String, Doctor> result = new HashMap<>();
        String keyword = (input == null) ? "" : input.trim().toLowerCase();
        for (Doctor d : db.values()) {
            if (d.getCode().toLowerCase().contains(keyword)
                    || d.getName().toLowerCase().contains(keyword)
                    || d.getSpecialization().toLowerCase().contains(keyword)
                    || String.valueOf(d.getAvailability()).contains(keyword)) {
                result.put(d.getCode(), d);
            }
        }
        return result;
    }

    /**
     * Checks whether a doctor with the given code already exists.
     *
     * @param code the code to check
     * @return true if the code exists in the database, false otherwise
     */
    public boolean existsByCode(String code) {
        return db.containsKey(code);
    }

    /**
     * Retrieves a doctor by code.
     *
     * @param code the code of the doctor to retrieve
     * @return the Doctor object, or null if not found
     */
    public Doctor getByCode(String code) {
        return db.get(code);
    }
}
