/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.rckz.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author rckz
 */
@Entity
public class Category extends BaseEntity implements Serializable{
    private String name;
    
    @OneToMany
    private List<Project> projects;

    public Category(String name, List<Project> projects) {
        this.name = name;
        this.projects = projects;
    }

    public Category() {
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
    
    
}
