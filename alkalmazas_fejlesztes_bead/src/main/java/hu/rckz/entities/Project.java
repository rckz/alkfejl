/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.rckz.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author rckz
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Project.getProjects", query = "select p from Project p")
})

public class Project extends BaseEntity implements Serializable {

    private String projectName;

    @Column(unique = true)
    private int projectNumber;

    @ManyToMany(cascade = CascadeType.REMOVE)
    private List<Candidate> candidates;

    @ManyToOne(cascade = CascadeType.REMOVE)
    private Category category;
    
    @ManyToMany
    private List<User> users;

    public Project(String projectName, int projectNumber, List<Candidate> candidates, Category category) {
        this.projectName = projectName;
        this.projectNumber = projectNumber;
        this.candidates = candidates;
        this.category = category;
    }

    public Project() {
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
   
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(int projectNumber) {
        this.projectNumber = projectNumber;
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
