/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package za.ac;

import java.sql.SQLException;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 *
 * @author letso
 */
@Stateless
@LocalBean
public class UserService {
    @Resource(name="jdbc/it") private DataSource ds;
    public void addUser(String username, String password, String role){
        try {
            String query = "INSERT INTO USERS VALUES('"+ username +"', '"+ password +"')";
            ds.getConnection().createStatement().executeUpdate(query);
            query = "INSERT INTO GROUPS VALUES('"+ role +"', '"+ username +"')";
            ds.getConnection().createStatement().executeUpdate(query);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }
}
