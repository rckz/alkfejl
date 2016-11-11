/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.rckz.views;

import java.util.List;
import hu.rckz.entities.Candidate;
import hu.rckz.entities.Project;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author rckz
 */
@Named
@RequestScoped
public class CandidateView {
    private List<Candidate> candidates;
    private List<Project> projects;
    private Project selectedProject;
    
    @EJB
    
    
    @PostConstruct
    public void init() {
        projects = new ArrayList<>();
        
    }
    
    public CandidateView() {
    }    
    
    public void onRowEdit() {
        
    }
    public void onRowEditCancel() {
        
    }
    public void onRowSelect() {
        
    }
    public void onRowUnselect() {
        selectedProject = null;
    }    

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Project getSelectedProject() {
        return selectedProject;
    }

    public void setSelectedProject(Project selectedProject) {
        this.selectedProject = selectedProject;
    }
    

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }
    
    
}
