/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        
      // getting data from database using the User
      UserService userServive = new UserService();
      
             
      // getting data from database using the User
      ArrayList<User> user = userServive.getAll();
      request.setAttribute("userList", user);
        
        
      getServletContext().getRequestDispatcher("/WEB-INF/user.jsp")
               .forward(request,response);

        
        
      getServletContext().getRequestDispatcher("/WEB-INF/users.jsp")
               .forward(request,response);

    }// ends doGet()

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    String action = request.getParameter("action");
    
    if(action != null && action.equals("deleteItem"))
    {
        request.setAttribute("message", "this is a test");
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp")
               .forward(request,response);
        return;
    }
   
    if(action != null && action.equals("saveItem"))
    {
        request.setAttribute("message", "Successfully Saved");
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp")
               .forward(request,response);
        return;
    }
     if(action != null && action.equals("editItem"))
    {
        request.setAttribute("message", "Successfully Edit");
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp")
               .forward(request,response);
        return;
    }
    getServletContext().getRequestDispatcher("/WEB-INF/users.jsp")
               .forward(request,response);
        
    }// ends doPost()
    
}
