/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.Users;
import static models.Users_.username;

/**
 *
 * @author 826847
 */
public class UserDB {
    
    public Users getUsername(String username){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try{
            
            Users user = em.find(Users.class, username);
            return user;
        }finally{
            em.close();
        }
       
}
    
    
    public List<Users> getAll() throws Exception {
      EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String username = null;
        try {
          // this will get all the notes in the database (might work, not what we want)
           // List<Note> notes = em.createNamedQuery("Note.findAll", Note.class).getResultList();
           //Get the notes from a particular user
           
           Users user = em.find(Users.class, username);
           List<Users> test = null;
           test.add(user);
            return test;
        } finally {
        em.clear();
        }

    }


    public int insert(Users user) throws Exception {
       EntityManager em  = DBUtil.getEmFactory().createEntityManager();
            EntityTransaction trans = em.getTransaction();
        
        try {
            //to get the user object we do this
            
        //getting all the notes for a user
        //service class will take care of any business logic
        //we want to add the entity to the database
        //we then add the note to the list
        
        //this will start our transaction properly
        trans.begin();
        em.persist(em.find(Users.class, user));
        em.merge(user);
        trans.commit();
        }catch(Exception ex)
        {
            trans.rollback();
        }finally {
           em.close();
            
        }
        return 0;
    }


    public int delete(Users user) throws Exception {
      EntityManager em = DBUtil.getEmFactory().createEntityManager();
      EntityTransaction trans = em.getTransaction();
        
        try {
          
           
           trans.begin();
           em.remove(em.merge(user.getUsername()));
           em.merge(user);
           trans.commit();
        } 
        catch(Exception ex)
        {
           trans.rollback();
        }
        finally {
           em.close();
        }
        return 0;
    }

    public int update(Users user) {
           EntityManager em = DBUtil.getEmFactory().createEntityManager();
       EntityTransaction trans = em.getTransaction();
        
        try {
          trans.begin();
          em.merge(user);
          trans.commit();
        } catch(Exception ex)
        {
            trans.rollback();
        }
        finally {
           em.close();
        }
        return 0;
    }


    
   
}
