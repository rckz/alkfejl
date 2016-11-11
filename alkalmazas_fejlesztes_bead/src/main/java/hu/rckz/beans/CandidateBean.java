/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.rckz.beans;

import hu.rckz.entities.Project;
import hu.rckz.entities.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rckz
 */
@Stateless
public class CandidateBean {
    
    @PersistenceContext
    EntityManager em;
    
    public List<Project> getProjectsForUser(User user) {
        List<Project> resultList = em.createNamedQuery("Project.getProjects",Project.class).getResultList();
        Project currentProject;
        for(int i = 0;i<resultList.size();++i){
           currentProject = resultList.get(i);
//           if(currentProject.getUser().)
        }
        return resultList;
    }
    
}
