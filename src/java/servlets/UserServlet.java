/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.UserService;
import models.User;



/**
 *
 * @author Group CCC
 */
public class UserServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
      // getting data from database using the UserService
      UserService userServive = new UserService();
      ArrayList<User> user = userServive.getAll();
      request.setAttribute("userList", user);        
        
      getServletContext().getRequestDispatcher("/WEB-INF/users.jsp")
               .forward(request,response);

    }// ends doGet()

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
       String action = request.getParameter("action");
    
       HttpSession session = request.getSession();
       UserService userService = new UserService();
       ArrayList<User> userList;
       User userData = (User) request.getAttribute("user");
      
        if(action.equals("deleteItem")){
            userService.delete(userData.getUsername());
        }
       
        if(action.equals("editItem")){
            
            request.setAttribute("addUser", userData.getUsername());
            request.setAttribute("addFirstName", userData.getFirstname());
            request.setAttribute("addLastName", userData.getLastname());
            request.setAttribute("addPassword", userData.getPassword());
            request.setAttribute("addEmail", userData.getEmail());
           
            session.setAttribute("editing", true);
           
            getServletContext().getRequestDispatcher("/WEB-INF/user.jsp")
               .forward(request,response);
            
            return;
        }
       
        if(action.equals("saveItem")){
            String userName = (String) request.getAttribute("addUser");
            String fname = (String) request.getAttribute("addFirstName");
            String lname = (String) request.getAttribute("addLastName");
            String password = (String) request.getAttribute("addPassword");
            String email = (String) request.getAttribute("addEmail");
            if((boolean)session.getAttribute("editing")){
                int row = 0;
                try {
                    row = userService.update(userName, fname, lname ,password, email);
                } catch (Exception ex) {
                    Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (row == 1){
                    request.setAttribute("message", "Successfully Edit");
                }else{
                    request.setAttribute("message", "Modification Unsuccessful");
                }
                session.setAttribute("editing", false);
            } else {
                int row = userService.insert(userName, fname, lname, password, email);
            }
        }
       
       
       userList = userService.getAll();
       request.setAttribute("userList", userList);
      
       getServletContext().getRequestDispatcher("/WEB-INF/user.jsp")
               .forward(request,response);
    
    
    //    if(action != null && action.equals("deleteItem"))
    //    {
    //        
    //        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp")
    //               .forward(request,response);
    //        return;
    //    }
    //   
    //    if(action != null && action.equals("saveItem"))
    //    {
    //         
    //        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp")
    //               .forward(request,response);
    //        return;
    //    }
    //     if(action != null && action.equals("editItem"))
    //    {
    //        request.setAttribute("message", "Successfully Edit");
    //        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp")
    //               .forward(request,response);
    //        return;
    //    }
    //    getServletContext().getRequestDispatcher("/WEB-INF/users.jsp")
    //               .forward(request,response);
        
    }// ends doPost()
    
}
