/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.LoginEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rckz
 */
@Stateless
public class LoginBean {
    @PersistenceContext(unitName = "alkfejl")
    EntityManager em;
    public LoginEntity login(String username,String password) {
        LoginEntity singleResult = null;
        try{
            singleResult = em.createNamedQuery("LoginEntity.login", LoginEntity.class).setParameter("username", username).setParameter("password", password).getSingleResult();
        }catch(NoResultException ex){
            return null;
        }        
        return singleResult;
    }
    
}
