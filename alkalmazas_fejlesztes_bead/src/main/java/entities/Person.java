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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author rckz
 */
@Entity
@Table(name = "Person")
public class Person extends BaseIdentity implements Serializable {
    private String name;
    private int age;
    private String currentPosition;
    private String address;
    private String phoneNumber;
    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "people")
    private List<Project> projects;
    @Lob
    private byte[] image;

    public Person(String name, int age, String currentPosition, String address, String phoneNumber, List<Project> projects) {
        this.name = name;
        this.age = age;
        this.currentPosition = currentPosition;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.projects = projects;
    }

    public Person() {
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
