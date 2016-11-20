/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.rckz.beans;

import hu.rckz.entities.Candidate;
import hu.rckz.entities.Project;
import hu.rckz.entities.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rckz
 */
@Stateless
@DeclareRoles(value = {"admin","user"})
@RolesAllowed({"admin","user"})
public class CandidateBean {
    
    @PersistenceContext
    EntityManager em;
    
    public List<Project> getProjectsForUser(User user) {
        List<Project> resultList = em.createNamedQuery("Project.getProjects",Project.class).getResultList();
        List<Project> returnList = new ArrayList<>();
        Project currentProject;
        for(int i = 0;i<resultList.size();++i){
           currentProject = resultList.get(i);
           if(currentProject.getUsers().contains(user)){
               returnList.add(currentProject);
           }
        }
        return returnList;
    }

    public void saveNewCandidate(String name, String email, String phoneNumber, String age, String currentJob) {
        try{            
            em.persist(new Candidate(name,currentJob,phoneNumber,email,Integer.parseInt(age)));
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
