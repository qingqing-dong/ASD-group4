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
import com.mycompany.onlinefoodorderingsystem.dao.DBCustomerManager;
import com.mycompany.onlinefoodorderingsystem.dao.DBStaffManager;
import com.mycompany.onlinefoodorderingsystem.model.*;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
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
        String startDate = " ";
        String endDate = " ";
        String position = " ";
        String role = request.getParameter("role");
        DBCustomerManager manager = (DBCustomerManager) session.getAttribute("manager");
        DBStaffManager manager1 = (DBStaffManager) session.getAttribute("manager1");
        validator.clear(session);

        if (!validator.validateEmail(email)) {
            session.setAttribute("emailErr", "Error: Email format incorrect");
            request.getRequestDispatcher("register.jsp").include(request, response);
        } else if (!validator.validatePassword(password)) {
            session.setAttribute("passErr", "Error: Password format incorrect");
            request.getRequestDispatcher("register.jsp").include(request, response);
        } else if (!validator.validateFirstName(first_name)) {
            session.setAttribute("firstnameErr", "Error: First Name format incorrect");
            request.getRequestDispatcher("register.jsp").include(request, response);
        }else if (!validator.validateLastName(last_name)) {
            session.setAttribute("lastnameErr", "Error: Last Name format incorrect");
            request.getRequestDispatcher("register.jsp").include(request, response); 
        }else {
            if(role.equals("customer")){
                try {
                    Customer exist = manager.findCustomer(email, password);
                    if (exist != null) {
                        session.setAttribute("existErr", "Customer already exists in the database!");
                        request.getRequestDispatcher("register.jsp").include(request, response);
                    } else {
                        manager.addCustomer(first_name, last_name, email, password, gender, address, phone_number);
                        Customer customer = manager.findCustomer(email, password);
                        session.setAttribute("customer", customer);
                        request.getRequestDispatcher("welcome.jsp").include(request, response);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                try {
                    Staff exist = manager1.findStaff(email, password);
                    if (exist != null) {
                        session.setAttribute("existErr", "Staff already exists in the database!");
                        request.getRequestDispatcher("register.jsp").include(request, response);
                    } else {
                        manager1.addStaff(first_name, last_name, email, password, gender, address, phone_number, startDate, endDate, position);
                        Staff staff = manager1.findStaff(email, password);
                        session.setAttribute("staff", staff);
                        request.getRequestDispatcher("welcome.jsp").include(request, response);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
