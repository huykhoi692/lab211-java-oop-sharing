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
public class Fresher extends Candidate{

    public enum GraduationRank {
        Excellence, Good, Fair, Poor;

        public int getIntValue() {
            switch (this) {
                case Excellence:
                    return 0;
                case Good:
                    return 1;
                case Fair:
                    return 2;
                case Poor:
                    return 3;
                default:
                    throw new AssertionError();
            }
        }

        public static GraduationRank getTypeByInt(int type) {
            switch (type) {
                case 0:
                    return Excellence;
                case 1:
                    return Good;
                case 2:
                    return Fair;
                case 3:
                    return Poor;
                default:
                    throw new AssertionError();
            }
        }
    }

    private int graduateYear;
    private String education;
    private GraduationRank graduationRank;

    public int getGraduateYear() {
        return graduateYear;
    }

    public void setGraduateYear(int graduateYear) {
        this.graduateYear = graduateYear;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        if (!Validation.isNonEmptyString(education)) {
            throw new IllegalArgumentException("Must not be empty");
        }
        this.education = education;
    }

    public GraduationRank getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(GraduationRank graduationRank) {
        this.graduationRank = graduationRank;
    }

}
