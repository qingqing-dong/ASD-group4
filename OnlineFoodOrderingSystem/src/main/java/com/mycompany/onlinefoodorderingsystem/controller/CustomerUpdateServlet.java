/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.onlinefoodorderingsystem.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.mycompany.onlinefoodorderingsystem.dao.CustomerDao;
import com.mycompany.onlinefoodorderingsystem.model.Customer;
import javax.servlet.annotation.WebServlet;
/**
 *
 * @author Xin Chen
 */
@WebServlet(name = "CustomerUpdateServlet", urlPatterns = {"/customerUpdateInfo"})
public class CustomerUpdateServlet extends HttpServlet {
    
    CustomerDao customerDao = new CustomerDao();
    
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        Customer customer = customerDao.getCustomerById(Integer.parseInt(request.getParameter("id")));
        System.out.println(customer);
        request.setAttribute("customer", customer);
        request.getRequestDispatcher("customerUpdate.jsp").forward(request, response);
    }
   
   
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        /*String sid = request.getParameter("id");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");

        int id = Integer.parseInt(sid);
        Customer newCustomer = new Customer(id, firstname, lastname, email, gender, address, phone, password);
        */
         Customer newCustomer = new Customer();
         newCustomer.setId(Integer.parseInt(request.getParameter("id")));
         newCustomer.setFirstName(request.getParameter("firstname"));
         newCustomer.setLastName(request.getParameter("lastname"));
         newCustomer.seteMail(request.getParameter("email"));
         newCustomer.setGender(request.getParameter("gender"));
         newCustomer.setAddress(request.getParameter("address")); 
         newCustomer.setPhoneNumber(request.getParameter("phone"));
         newCustomer.setPassword(request.getParameter("password"));
         
        customerDao.updateCustomer(newCustomer);
        
        request.setAttribute("customer", newCustomer);
        request.getRequestDispatcher("customerInfo.jsp").forward(request, response);

    }
   

}
