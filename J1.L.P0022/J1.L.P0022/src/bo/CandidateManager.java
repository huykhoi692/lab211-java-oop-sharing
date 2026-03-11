/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.Candidate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author khois
 */
public class CandidateManager {
    private List<Candidate> candidates = new ArrayList<>();
    private int lastId;
    
    public CandidateManager() {
        lastId = 0;
    }
    
    public boolean addCandidate(Candidate c) {
        c.setId(++lastId);
        return candidates.add(c);
    }
    
    public List<Candidate> searchCandidate(String name, Candidate.CandidateType type) {
        List<Candidate> list = new ArrayList<>();
        for (Candidate candidate : candidates) {
            if (candidate.getLastName().toLowerCase().equalsIgnoreCase(name.toLowerCase())
                    || candidate.getFirstName().toLowerCase().equalsIgnoreCase(name.toLowerCase())
                    || candidate.getCandidateType().equals(type)) {
                list.add(candidate);
            }
        }
        return list;
    }
}
