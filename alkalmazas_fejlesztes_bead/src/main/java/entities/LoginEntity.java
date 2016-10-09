/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author rckz
 */
@NamedQuery(name = "LoginEntity.login", query = "select t from LoginEntity t where t.username = :username and t.password = :password")
@Entity
@Table(name = "LoginCredentials")
public class LoginEntity extends BaseIdentity implements Serializable {
    private String username;
    private String password;

    public LoginEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public LoginEntity() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
