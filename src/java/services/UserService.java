/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Group CCC
 */
public class UserService {
    
    public int update(String username, String password, String firstname, String lastname, String email) throws Exception {
        int rowUpdated = 0;
        
        String preparedSQL = "UPDATE users SET "
                            + "   username = ?," 
                            + "   password = ?," 
                            + "   firstname = ?, "
                            + "   lastname = ?,"
                            + "   email = ?"
                            + "WHERE username = ?";
        
        PreparedStatement ps = connection.prepareStatement(preparedSQL);
        
        ps.setString(1, username);
        ps.setString(2, password);
        ps.setString(3, firstname);
        ps.setString(4, lastname);
        ps.setString(5, email);
        ps.setString(6, username);
        
        rowUpdated = ps.executeUpdate();

        return rowUpdated;
    }
    
           
   private String username;
   private String firstname;
   private String lastname;
   private String password;
   private String email;
   
    public int insert(String username, String firstname, String lastname, String password, String email) throws SQLException
    {
  
String preparedQuery =
        "INSERT INTO users "
+ "(username, password, firstname, lastname,email) "
+ "VALUES "
+ "(?, ?, ?, ?, ?)";
PreparedStatement ps = 
connection.prepareStatement(preparedQuery);
ps.setString(1, username);
ps.setString(2, password);
ps.setString(3, firstname);
ps.setString(4, lastname);
ps.setString(5, email);
int rows = ps.executeUpdate(); 
return rows;
    }
    
}
