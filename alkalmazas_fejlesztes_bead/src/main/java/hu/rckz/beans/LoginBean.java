/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.rckz.beans;

import hu.rckz.entities.Role;
import hu.rckz.entities.User;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rckz
 */
@Stateless
public class LoginBean {
    @PersistenceContext
    private EntityManager em;
    
    @Resource
    protected SessionContext sessionContext;
    
    public User getLoggedInUser() {
        return User.findByLoginName(em, sessionContext.getCallerPrincipal().getName());
    }
    
     
}
