/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.rckz.beans;

import hu.rckz.entities.Project;
import hu.rckz.entities.Role;
import hu.rckz.entities.User;
import hu.rckz.utils.PUtils;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rckz
 */
@Stateless
public class UsersBean {

    @PersistenceContext
    private EntityManager em;

    public void registerNewUser(String username, String password, String name) {
        try {
            User newUser = new User(username, password, name);
            em.persist(newUser);
            PUtils.addInfoMsg("Regisztrálás", "Az felhasználó regisztrálása sikeres volt!");
        } catch (Exception ex) {
            
        }

    }

    public void deleteUser(User user) {
        try {
            User found = em.find(User.class, user.getId());
            em.remove(found);
            PUtils.addInfoMsg("Törlés", "A törlés sikeres volt!");
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    public List<Project> getProjectsForUser(User user){
        return em.find(User.class,user.getId()).getProjects();
    }
    public List<Project> getAvailableProjects(User user){
        List<Project> resultList = em.createNamedQuery("Project.getProjects", Project.class).getResultList();
        List<Project> returnList = new ArrayList<>();        
        for(Project x:resultList){
            boolean found = false;
            for(int i = 0;i<user.getProjects().size() && !found;++i){
                if(user.getProjects().get(i).equals(x)){
                    found = true;
                }
            }
            if(!found){
                returnList.add(x);
            }
        }
        return returnList;
    }
    public List<User> getRegisteredUsers() {
        return em.createNamedQuery("User.getRegisteredUsers", User.class).getResultList();
    }
    public List<Role> getAllRoles(){
        return em.createNamedQuery("Role.getRoles",Role.class).getResultList();
    }

    public List<Role> getAvailableRoles(User user) {
        List<Role> resultList = em.createNamedQuery("Role.getRoles", Role.class).getResultList();
        List<Role> returnList = new ArrayList<>();        
        for(Role x:resultList){
            boolean found = false;
            for(int i = 0;i<user.getRoles().size() && !found;++i){
                if(user.getRoles().get(i).equals(x)){
                    found = true;
                }
            }
            if(!found){
                returnList.add(x);
            }
        }
        return returnList;
    }

    public List<Role> getRolesForUser(User user) {
        try{
            List<Role> roles = user.getRoles();
            return roles;
        }catch(NullPointerException ex){
            return new ArrayList<>();
        }
        
    }

    public void saveRoles(User user,List<Role> roles) {
        User found = em.find(User.class, user.getId());
        found.setRoles(roles);
    }

    public void saveProjects(User user, List<Project> projects) {
        User found = em.find(User.class, user.getId());
        found.setProjects(projects);
    }

}
