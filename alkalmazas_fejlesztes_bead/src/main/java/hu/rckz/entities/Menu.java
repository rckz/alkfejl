/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.rckz.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author rckz
 */
@Entity
@Table(name = "MENU")
public class Menu extends BaseEntity{
    
    private String url;    
    private String icon;
    private String text;

    public Menu() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    
}
