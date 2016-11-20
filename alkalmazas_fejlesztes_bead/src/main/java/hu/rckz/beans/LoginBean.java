/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.rckz.beans;

import hu.rckz.entities.User;
import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rckz
 */
@Stateful
@DeclareRoles(value = {"admin","user"})
@RolesAllowed({"admin","user"})
public class LoginBean {
    @PersistenceContext
    private EntityManager em;
    
    @Resource
    protected SessionContext sessionContext;
    
    public User getLoggedInUser() {        
        return User.findByLoginName(em, sessionContext.getCallerPrincipal().getName());
    }    
     
}
