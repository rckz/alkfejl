/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import beans.LoginBean;
import entities.LoginEntity;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author rckz
 */
@Named
@SessionScoped
public class SessionView implements Serializable {

    @EJB
    private LoginBean loginBean;

    private LoginEntity loggedInUser;

    public void login(String username, String password) {
        try {
            loggedInUser = loginBean.login(username, password);
            System.out.println(loggedInUser.getUsername()+" "+loggedInUser.getPassword());
        } catch (NullPointerException ex) {                
            System.out.println("sikertelen bejelentkezés");
        }

    }

    public SessionView() {
    }

    public LoginEntity getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(LoginEntity loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

}
