/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.onlinefoodorderingsystem.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mycompany.onlinefoodorderingsystem.dao.CustomerDao;
import com.mycompany.onlinefoodorderingsystem.model.Customer;

/**
 *
 * @author Xin Chen
 */
@WebServlet(name = "CustomerInfoServlet", urlPatterns = {"/customerInfo"})
public class CustomerInfoServlet extends HttpServlet {
   

    CustomerDao customerDao = new CustomerDao();
   
    /*
   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer customer = customerDao.getCustomerById(100);
        request.setAttribute("customer", customer);
        request.getRequestDispatcher("customerInfo.jsp").forward(request, response);
    }
    */
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        Customer customer = customerDao.getCustomerById(Integer.parseInt(request.getParameter("id")));
        System.out.println(customer);
        request.setAttribute("customer", customer);
        request.getRequestDispatcher("customerInfo.jsp").forward(request, response);
    }

}
