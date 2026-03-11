/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.Candidate;
import entity.Experience;
import entity.Fresher;
import entity.Intern;

/**
 *
 * @author khois
 */
public class CandidateInputer {

    private Candidate c;

    public CandidateInputer(Candidate.CandidateType type) {
        switch (type) {
            case EXPERIENCE:
                c = new Experience();
                break;
            case FRESHER:
                c = new Fresher();
                break;
            case INTERN:
                c = new Intern();
                break;
            default:
                throw new AssertionError();
        }
    }

}
