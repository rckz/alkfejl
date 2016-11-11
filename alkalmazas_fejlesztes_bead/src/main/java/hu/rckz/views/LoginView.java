/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.rckz.views;

import hu.rckz.beans.LoginBean;
import hu.rckz.utils.PUtils;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author rckz
 */
@Named(value = "loginView")
@ViewScoped
public class LoginView implements Serializable {

    @EJB
    private LoginBean userBean;
    @Inject
    private HttpServletRequest httpServletRequest;

    @Inject
    private SessionView sessionView;

    public String login(String loginName, String password) throws Exception {
        try {            
            httpServletRequest.login(loginName, password);
            sessionView.setLoggedInUser(userBean.getLoggedInUser());            
            return "candidates.xhtml?faces-redirect=true";
        } catch (ServletException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Contact admin."));
            Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
            return "login.xhtml?faces-redirect=true";
        }
    }

    public String logout() {
        try {            
            httpServletRequest.getSession().invalidate();
            httpServletRequest.logout();
            sessionView.setLoggedInUser(null);
            return "login.xhtml?faces-redirect=true";            
        } catch (Exception ex) {
            Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }
}
