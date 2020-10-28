/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import models.User;

/**
 *
 * @author Group CCC
 */
public class UserService 
{

    public int update(String username, String password, String firstname, String lastname, String email) throws Exception {
        int rowUpdated = 0;
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
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
    
        
       public User get(String username) throws Exception {
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
        
        String preparedSQL ="SELECT * " 
                   + "FROM users WHERE username = ?";

        
        PreparedStatement ps = connection.prepareStatement(preparedSQL);
        
        ps.setString(1, username);
        
        ResultSet p1 = ps.executeQuery();

          User u1 = new User(p1.getString("username"),p1.getString("password"),
                  p1.getString("firstname"), p1.getString("lastname"),p1.getString("email"));
          
          connection.close();

        return u1;
     }
    
  
    
}
