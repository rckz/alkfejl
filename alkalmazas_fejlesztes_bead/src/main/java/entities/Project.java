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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author rckz
 */
@Entity
public class Project extends BaseIdentity implements Serializable {

    private String name;
    private int projectNumber;
    private String description;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Person")
    private List<Person> people;
    
    public Project() {
    }

    public Project(String name, int projectNumber, String description) {
        this.name = name;
        this.projectNumber = projectNumber;
        this.description = description;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
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
    
    
    
}
