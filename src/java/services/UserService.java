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
        UserService service = new UserService();
        String preparedQuery = 
                "INSERT INTO users "
                + "(username, password, firstname, lastname,email) "
                + "VALUES "
                + "(?, ?, ?, ?, ?)";
        PreparedStatement ps = 
        NotesDB.prepareStatement(preparedQuery);
        ps.setString(1, service.getUsername());
        ps.setString(2, service.getPassword());
        ps.setString(3, service.getFirstname());
        ps.setString(4, service.getLastname());
        ps.setString(5, service.getEmail());
        int rows = ps.executeUpdate(); 
    }
    
    public int delete(String username) throws Exception{
        //get connection
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
        //prepare Delete statement
        String deleteQuery = "DELETE FROM users "
                + "WHERE username = ?";
        PreparedStatement delete = connection.prepareStatement(deleteQuery);
        
        //set the value and excute
        delete.setString(0, username);
        int rows = delete.executeUpdate();
        
        //release the connection and retrun the number of rows
        pool.freeConnection(connection);
        return rows;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
}

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
