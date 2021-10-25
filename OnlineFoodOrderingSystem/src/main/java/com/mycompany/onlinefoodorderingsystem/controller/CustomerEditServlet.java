/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.onlinefoodorderingsystem.controller;


import com.mycompany.onlinefoodorderingsystem.dao.DBCustomerManager;
import com.mycompany.onlinefoodorderingsystem.model.Customer;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.SQLException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Xin Chen
 */
@WebServlet(name = "CustomerEditServlet", urlPatterns = {"/CustomerEditServlet"})
public class CustomerEditServlet extends HttpServlet {

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String gender = request.getParameter("gender");
        String streetNumber = request.getParameter("streetNumber");
        String streetName = request.getParameter("streetName");
        String suburb = request.getParameter("suburb");
        String state = request.getParameter("state");
        String zipcode = request.getParameter("zipcode");
        String address = streetNumber + "§" + streetName + "§" + suburb + "§" + state + "§" + zipcode;
        String phone_number = request.getParameter("phone_number");
        DBCustomerManager manager = (DBCustomerManager) session.getAttribute("manager");
        
        Customer customer = null;
        try {
            customer = manager.findCustomer(email, password);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerEditServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(customer != null){
            session.setAttribute("customer", customer);
            request.getRequestDispatcher("customerUpdate.jsp").include(request, response);
        }else{
            session.setAttribute("existErr", "Customer does not exist in the database!");
            request.getRequestDispatcher("customerUpdate.jsp").include(request, response);
        }
        request.getRequestDispatcher("customerUpdate.jsp").include(request, response);
    }

}



