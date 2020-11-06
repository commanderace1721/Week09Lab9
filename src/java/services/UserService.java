/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import dataaccess.DBUtil;
import dataaccess.UserDB;
import java.util.List;
import javax.persistence.EntityManager;
import models.Users;

/**
 *
 * @author Group CCC
 */
public class UserService 
{
 private UserDB userDB;
 private Users user;

    public UserService() {
        userDB = new UserDB();
        user = new Users();
    }

    
    public Users get(String username) throws Exception {
        return userDB.getUsername(username);
    }

    public List<Users> getAll(String username) throws Exception {
        return userDB.getAll();
    }

    public int update(String username, String password, String firstname, String lastname, String email) throws Exception {
        Users user = get(username);
        user.setPassword(password);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setEmail(email);
        return userDB.update(user);
    }

    public int delete(String username) throws Exception {
        Users user = new Users();
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        Users deletedUser = em.find(Users.class, username);
        // do not allow the admin to be deleted
        
        try{
            if (deletedUser.getUsername().equals("admin")) {
            return 0;
        }
        return userDB.delete(deletedUser);
        }finally{
            em.close();
        }
    
        
    }

    public int insert(String username, String password, String firstname, String lastname, String email) throws Exception {
        Users user = new Users(username, password, firstname, lastname, email);
        return userDB.insert(user);
    }

   
}
