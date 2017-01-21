
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.embeddable.EJBContainer;
import com.sun.enterprise.security.ee.auth.login.ProgrammaticLogin;
import hu.rckz.beans.LoginBean;
import hu.rckz.beans.UsersBean;
import hu.rckz.entities.Project;
import hu.rckz.entities.User;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rckz
 */
public class UnitTest {

    protected static EJBContainer container;

    public static void createEjbContainer() throws Exception {
        String glassfish = "/home/rckz/glassfish4";
        Map<String, Object> properties = new HashMap<>();
        properties.put(EJBContainer.MODULES, new File("target/classes"));
        properties.put("org.glassfish.ejb.embedded.glassfish.installation.root", glassfish + "/glassfish");
        System.out.println(glassfish + "/glassfish");
        properties.put("configuration.file", glassfish + "/glassfish/domains/domain1/config/domain.xml");
        
        container = EJBContainer.createEJBContainer(properties);
        ProgrammaticLogin login = new ProgrammaticLogin();
        login.login("admin", "admin".toCharArray(), "jdbcRealm", true);
    }

    @BeforeClass
    public static void init() throws Exception {
        createEjbContainer();
    }

    @AfterClass
    public static void destroy() {
        container.close();
    }

    @Test
    public void testLogin() throws Exception {
        LoginBean loginBean = (LoginBean) container.getContext().lookup("java:global/classes/LoginBean");
        User loggedInUser = loginBean.getLoggedInUser();
        Assert.assertEquals("admin", loggedInUser.getUsername());
    }

    @Test
    public void testRegistration() throws Exception {
        UsersBean usersBean = (UsersBean) container.getContext().lookup("java:global/classes/UsersBean");
        String testerString = "teszt6";
        User newUser = usersBean.registerNewUser(testerString, testerString, testerString);
        //teszt sikeres regisztrációt
        Assert.assertEquals(testerString, usersBean.getRegisteredUsers().get(usersBean.getRegisteredUsers().size()-1).getUsername());   
        
        //teszt user szerepkör
        Assert.assertEquals("commonuser", usersBean.getRegisteredUsers().get(usersBean.getRegisteredUsers().size()-1).getRoles().get(0).getName());
        //teszt projektek
        Assert.assertEquals("Projektnev", usersBean.getAvailableProjects(newUser).get(0).getProjectName());
    }
    
    

}
