/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.rckz.views;

import hu.rckz.beans.CandidateBean;
import java.util.List;
import hu.rckz.entities.Candidate;
import hu.rckz.entities.Project;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author rckz
 */
@Named
@RequestScoped
@DeclareRoles(value = {"admin","user"})
@RolesAllowed("user")
public class CandidateView {
    private List<Candidate> candidates;
    private List<Project> projects;
    private Project selectedProject;
    
    @EJB
    CandidateBean candidateBean;
    
    @Inject
    SessionView sessionView;
    
    @PostConstruct
    public void init() {
        projects = candidateBean.getProjectsForUser(sessionView.getLoggedInUser());
    }
    
    public CandidateView() {
    }    
    
    public void onRowEdit() {
        
    }
    public void onRowEditCancel() {
        
    }
    public void saveNewCandidate(String name,String email,String phoneNumber,String age,String currentJob) {
        try{
            candidateBean.saveNewCandidate(name,email,phoneNumber,age,currentJob);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void onRowSelect() {
        projects = candidateBean.getProjectsForUser(sessionView.getLoggedInUser());
    }
    public void onRowUnselect() {
        selectedProject = null;
        projects = null;
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
