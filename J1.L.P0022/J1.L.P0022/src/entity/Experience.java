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
public class Experience extends Candidate{
    private int expInYear;
    private String proSkill;

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        if (!Validation.isValidYearOfExp(expInYear)) {
            throw new IllegalArgumentException("Invalid exp in year");
        }
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        if (!Validation.isNonEmptyString(proSkill)) {
            throw new IllegalArgumentException("Invalid exp in year");
        }
        this.proSkill = proSkill;
    }
}
