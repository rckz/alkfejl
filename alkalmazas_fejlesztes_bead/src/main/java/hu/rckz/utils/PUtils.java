/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.rckz.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author rckz
 */
public class PUtils {

    public static void updateComponent(String... compNames) {
        RequestContext rcontext = RequestContext.getCurrentInstance();
        for (String compName : compNames) {
            rcontext.update(compName);
        }
    }

    public static void addInfoMsg(String title, String detail) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(title, detail));
    }

}
