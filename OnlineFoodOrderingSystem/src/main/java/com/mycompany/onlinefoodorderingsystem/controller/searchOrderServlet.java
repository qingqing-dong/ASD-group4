/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.onlinefoodorderingsystem.controller;
import com.mycompany.onlinefoodorderingsystem.dao.MenuDao;
import com.mycompany.onlinefoodorderingsystem.dao.OrderDao;
import com.mycompany.onlinefoodorderingsystem.model.Order;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 47288
 */
public class searchOrderServlet extends HttpServlet {
    private Connection conn;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        request.getRequestDispatcher("searchOrder.jsp").include(request, response);
     
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String customerID = request.getParameter("customerID");
        Order order =(Order) session.getAttribute("order");
       OrderDao orderDao = (OrderDao) session.getAttribute("orderDao");
      
           Validator validator = new Validator();
        
         if(!validator.validateOrderInt(customerID)){
            session.setAttribute("typeErr", "Error: type format incorrect");
            request.getRequestDispatcher("searchOrder.jsp").include(request, response);
        }
        else{
            try{    
               
                    order = orderDao.findOrder(Integer.parseInt(customerID));
                    session.setAttribute("order", order);
                    request.getRequestDispatcher("searchOrder.jsp").include(request, response);
            } catch (SQLException ex){
                Logger.getLogger(searchOrderServlet.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
       
    }

    

}
