/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import util.Validation;

/**
 *
 * @author khois
 */
public class Candidate {

    public enum CandidateType {
        EXPERIENCE, FRESHER, INTERN;

        public int getIntValue() {
            switch (this) {
                case EXPERIENCE:
                    return 0;
                case FRESHER:
                    return 1;
                case INTERN:
                    return 2;
                default:
                    throw new AssertionError();
            }
        }

        public static CandidateType getTypeByInt(int type) {
            switch (type) {
                case 0:
                    return EXPERIENCE;
                case 1:
                    return FRESHER;
                case 2:
                    return INTERN;
                default:
                    throw new AssertionError();
            }
        }
    }
    //Id, First Name, Last Name, Birth Date, Address, Phone, Email
    private int id;
    private String firstName;
    private String lastName;
    private int yob;
    private String address;
    private String phone;
    private String email;
    private CandidateType candidateType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (!Validation.isNonEmptyString(firstName)) {
            throw new IllegalArgumentException("Must not be empty");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (!Validation.isNonEmptyString(lastName)) {
            throw new IllegalArgumentException("Must not be empty");
        }
        this.lastName = lastName;
    }

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        if (!Validation.isValidYob(yob)) {
            throw new IllegalArgumentException("YOB Out Of Range");
        }
        this.yob = yob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (!Validation.isNonEmptyString(address)) {
            throw new IllegalArgumentException("Must not be empty");
        }
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (!Validation.isNonEmptyString(phone)) {
            throw new IllegalArgumentException("Must not be empty");
        }
        if (!Validation.isValidPhoneNumber(phone)) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!Validation.isNonEmptyString(email)) {
            throw new IllegalArgumentException("Must not be empty");
        }
        if (!Validation.isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email");
        }
        this.email = email;
    }

    public CandidateType getCandidateType() {
        return candidateType;
    }

    public void setCandidateType(CandidateType candidateType) {
        this.candidateType = candidateType;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return String.format("%-10s%-20s%-15s%-15s%-20s%-1s", getName(), yob, address, phone, email, candidateType.getIntValue());
    }
}
