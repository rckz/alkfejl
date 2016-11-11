/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.rckz.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 *
 * @author rckz
 */
@Entity
public class Candidate extends BaseEntity implements Serializable{
    
    private String name;
    private String currentJob;
    private String phoneNumber;
    private String email;
    private int age;
    @ManyToMany
    private List<Project> project;

    public Candidate(String name, String currentJob, String phoneNumber, String email, int age, List<Project> project) {
        this.name = name;
        this.currentJob = currentJob;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.age = age;
        this.project = project;
    }

    public Candidate() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrentJob() {
        return currentJob;
    }

    public void setCurrentJob(String currentJob) {
        this.currentJob = currentJob;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Project> getProject() {
        return project;
    }

    public void setProject(List<Project> project) {
        this.project = project;
    }
    
    
}
