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
public class Intern extends Candidate{
    private String major;
    private int semester;
    private String universityName;

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        if (!Validation.isNonEmptyString(major)) {
            throw new IllegalArgumentException("Must not be empty");
        }
        this.major = major;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        if (semester < 0) {
            throw new IllegalArgumentException("Invalid semester");
        }
        this.semester = semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        if (!Validation.isNonEmptyString(universityName)) {
            throw new IllegalArgumentException("Must not be empty");
        }
        this.universityName = universityName;
    }
    
    
}
