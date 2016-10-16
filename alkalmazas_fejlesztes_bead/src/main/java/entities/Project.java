/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author rckz
 */
@Entity
@Table(name = "Project")
@NamedQueries({
@NamedQuery(name = "Project.getProjectsByCategory",query = "select p from Project p where p.category = :category")
})
public class Project extends BaseIdentity implements Serializable {

    private String name;
    private int projectNumber;
    private String description;
    
    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "Candidate")
    private List<Candidate> candidates;
    @ManyToOne
    private Category category;
    
    public Project() {
    }

    public Project(String name, int projectNumber, String description, Category category) {
        this.name = name;
        this.projectNumber = projectNumber;
        this.description = description;
        this.category = category;
    }    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.projectNumber;
        return hash;
    }    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Project other = (Project) obj;
        if (this.projectNumber != other.projectNumber) {
            return false;
        }
        return true;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(int projectNumber) {
        this.projectNumber = projectNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
