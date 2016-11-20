/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.rckz.views;

import hu.rckz.beans.UsersBean;
import hu.rckz.entities.Project;
import hu.rckz.entities.Role;
import hu.rckz.entities.User;
import hu.rckz.utils.PUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.model.DualListModel;

/**
 *
 * @author rckz
 */
@Named
@ViewScoped

public class UsersView implements Serializable {

    @EJB
    private UsersBean usersBean;

    private User selectedRegisteredUser;

    private List<User> registeredUsers;

    private DualListModel<Role> rolesDualList;
    
    private DualListModel<Project> projectDualList;   

    @PostConstruct
    public void init() {    
        
        registeredUsers = usersBean.getRegisteredUsers(); 
        rolesDualList = new DualListModel<>(new ArrayList<Role>(), new ArrayList<Role>());
        projectDualList = new DualListModel<>(new ArrayList<Project>(), new ArrayList<Project>());        
    }
    
    public void registerNewProject(String name,String number) {
        usersBean.saveNewProject(name,number);
    }
    
    public void saveRoles(){
        usersBean.saveRoles(selectedRegisteredUser,rolesDualList.getTarget());
    }
    public void saveProjects() {
        usersBean.saveProjects(selectedRegisteredUser,projectDualList.getSource(),projectDualList.getTarget());
    }
    
    public void setSelectedUser(){
        registeredUsers = usersBean.getRegisteredUsers();
        List<Role> sourceRole = usersBean.getAvailableRoles(selectedRegisteredUser);        
        List<Role> targetRole = usersBean.getRolesForUser(selectedRegisteredUser);
        
        List<Project> sourceProject = usersBean.getAvailableProjects(selectedRegisteredUser);
        List<Project> targetProject = usersBean.getProjectsForUser(selectedRegisteredUser);
        rolesDualList = new DualListModel<>(sourceRole, targetRole);
        projectDualList = new DualListModel<>(sourceProject, targetProject);
    }

    public void registerNewUser(String username, String password, String name) {
        usersBean.registerNewUser(username, PUtils.hash(password), name);
        init();
        PUtils.updateComponent(":registeredUsersForm");
    }

    public void deleteUser() {
        usersBean.deleteUser(selectedRegisteredUser);
        init();
        PUtils.updateComponent(":registeredUsersForm");
    }

    public DualListModel<Role> getRolesDualList() {
        return rolesDualList;
    }

    public void setRolesDualList(DualListModel<Role> rolesDualList) {
        this.rolesDualList = rolesDualList;
    }

    public List<User> getRegisteredUsers() {
        return registeredUsers;
    }

    public void setRegisteredUsers(List<User> registeredUsers) {
        this.registeredUsers = registeredUsers;
    }

    public User getSelectedRegisteredUser() {
        return selectedRegisteredUser;
    }

    public void setSelectedRegisteredUser(User selectedRegisteredUser) {
        this.selectedRegisteredUser = selectedRegisteredUser;
    }

    public DualListModel<Project> getProjectDualList() {
        return projectDualList;
    }

    public void setProjectDualList(DualListModel<Project> projectDualList) {
        this.projectDualList = projectDualList;
    }
    

}
