/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UsersDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Users;

/**
 *
 * @author QUOC-TRONG
 */
public class UsersServlet extends HttpServlet {

    
    
        
    UsersDAO usersDAO = new UsersDAO();

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String command = request.getParameter("command");
        String url = "";
        HttpSession session = request.getSession();
        switch(command){
            case "insert":
                Users users = new Users(new java.util.Date().getTime(), request.getParameter("email"), request.getParameter("pass"),false );
                //xem laij sao laij laays id laf date ??? 
                //t xem video no huong dan roi lam theo thoi ak
                
               
                if (usersDAO.insertUser(users)==true) {
                   session.setAttribute("user", users);
                url = "/index.jsp";  
                }
                
                
               
                break;
            case "login":
                users = usersDAO.login(request.getParameter("email"), request.getParameter("pass"));
              url = "/index.jsp";

                    session.setAttribute("user", users);
                
                break;
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
    }


}