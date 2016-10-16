/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author rckz
 */
@Entity
@Table(name = "Candidate")
@NamedQueries({
    @NamedQuery(name = "Candidate.getCandidates", query = "select c from Candidate c")
})
public class Candidate extends BaseIdentity implements Serializable {

    private String name;
    private int age;
    private String currentPosition;
    private String address;
    private String phoneNumber;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "candidates")
    private List<Project> projects;
    @Lob
    private byte[] image;

    public Candidate(String name, int age, String currentPosition, String address, String phoneNumber, List<Project> projects) {
        this.name = name;
        this.age = age;
        this.currentPosition = currentPosition;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.projects = projects;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Candidate other = (Candidate) obj;
        if (this.age != other.age) {
            return false;
        }
        if(!Objects.equals(this.id, other.id)){
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    

    public Candidate() {
        super();
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(String currentPosition) {
        this.currentPosition = currentPosition;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
