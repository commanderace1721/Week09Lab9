/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.PreparedStatement;

/**
 *
 * @author Group CCC
 */
public class UserService {
    
    public int update(String username, String password, String firstname, String lastname, String email) throws Exception {
        int rowUpdated = 0;
        
        String preparedSQL = "UPDATE users SET "
                            + "   username = ?," 
                            + "   firstname = ?, "
                            + "   lastname = ?,"
                            + "   email = ?"
                            + "WHERE username = ?";
        
        PreparedStatement ps = connection.prepareStatement(preparedSQL);
        
        ps.setString(1, username);
        ps.setString(2, password);
        ps.setString(3, firstname);
        ps.setString(4, lastname);
        ps.setString(6, email);
        ps.setString(7, username);
        
        rowUpdated = ps.executeUpdate();

        return rowUpdated;
    }
    
}
