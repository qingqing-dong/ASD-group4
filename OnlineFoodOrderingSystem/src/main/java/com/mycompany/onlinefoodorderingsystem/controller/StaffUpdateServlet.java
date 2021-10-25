/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.onlinefoodorderingsystem.controller;

import com.mycompany.onlinefoodorderingsystem.dao.DBStaffManager;
import com.mycompany.onlinefoodorderingsystem.dao.StaffDao;
import com.mycompany.onlinefoodorderingsystem.model.Staff;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Xin Chen
 */
@WebServlet(name = "StaffUpdateServlet", urlPatterns = {"/StaffUpdateServlet"})
public class StaffUpdateServlet extends HttpServlet {

    StaffDao staffDao = new StaffDao();
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
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        Staff staff = staffDao.getStaffById(Integer.parseInt(request.getParameter("id")));
        System.out.println(staff);
        request.setAttribute("staff", staff);
        request.getRequestDispatcher("staffUpdate.jsp").forward(request, response);
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
         Staff newStaff = new Staff();
         newStaff.setId(Integer.parseInt(request.getParameter("id")));
         newStaff.setFirstName(request.getParameter("firstname"));
         newStaff.setLastName(request.getParameter("lastname"));
         newStaff.seteMail(request.getParameter("email"));
         newStaff.setGender(request.getParameter("gender"));
         newStaff.setAddress(request.getParameter("address")); 
         newStaff.setPhoneNumber(request.getParameter("phone"));
         newStaff.setPassword(request.getParameter("password"));
         newStaff.setPosition(request.getParameter("position"));
         
        staffDao.updateStaff(newStaff);
        
        request.setAttribute("staff", newStaff);
        request.getRequestDispatcher("staffInfo.jsp").forward(request, response);
    }
   
}
