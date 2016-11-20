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
import javax.persistence.EntityManager;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author rckz
 */
@Entity
@Table(name = "USER")
@NamedQueries({
    @NamedQuery(name = "User.byLoginName", query = "select u from User u where u.username = :loginName")
    ,
    @NamedQuery(name = "User.getRegisteredUsers", query = "select u from User u")
})
public class User extends BaseEntity implements Serializable {

    @Column(name = "USERNAME", unique = true)
    private String username;
    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "NAME")
    private String name;

    @ManyToMany(cascade = CascadeType.REMOVE)
    private List<Role> roles;

    @ManyToMany(cascade = CascadeType.REMOVE)
    private List<Project> projects;
    
    @ManyToMany
    private List<Menu> menu;

    public User(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public static User findByLoginName(EntityManager em, String loginName) {
        List<User> list = em.createNamedQuery("User.byLoginName", User.class).setParameter("loginName", loginName).setMaxResults(1).getResultList();
        return list.isEmpty() ? null : list.get(0);
    }

    public User() {
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Menu> getMenu() {
        return menu;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }
    

}
