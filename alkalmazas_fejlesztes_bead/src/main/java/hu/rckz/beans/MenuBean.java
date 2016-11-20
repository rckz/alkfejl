/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.rckz.beans;

import hu.rckz.entities.Menu;
import hu.rckz.views.SessionView;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author rckz
 */
@Stateless
@Named
public class MenuBean {
    
    private MenuModel model;
    
    @Inject
    SessionView sessionView;    
    
    @PostConstruct
    private void init(){
        model = new DefaultMenuModel();
        for(Menu x:sessionView.getLoggedInUser().getMenu()){
            DefaultMenuItem item = new DefaultMenuItem(x.getText());
            item.setUrl(x.getUrl());
            item.setIcon(x.getIcon());
            model.addElement(item);
        }
    }

    public MenuModel getModel() {
        return model;
    }
    
}
