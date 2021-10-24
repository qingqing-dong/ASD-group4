/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.onlinefoodorderingsystem.controller;

import com.mycompany.onlinefoodorderingsystem.dao.SupplierManager;
import com.mycompany.onlinefoodorderingsystem.model.Supplier;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "FindsupplierServlet", urlPatterns = {"/FindsupplierServlet"})
public class FindsupplierServlet extends HttpServlet {

     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        HttpSession session = request.getSession();
        //Validator validator = new Validator();
        
        String company = request.getParameter("company");
        SupplierManager supplierManager = (SupplierManager) session.getAttribute("supplierManager");
        Supplier supplier = null;
        //validator.clear(session);
        
        /*if(!validator.validateDate(date)){
            session.setAttribute("dateErr","Date format incorrect");
            request.getRequestDispatcher("findpayment.jsp").include(request, response);
            
        }else{*/
            try{
                supplier = supplierManager.readSupplier(company);
                if(supplier != null){
                    session.setAttribute("supplier", supplier);
                    request.getRequestDispatcher("viewsearchsupplier.jsp").include(request, response);
                }else{
                    session.setAttribute("ExistErr","Supplier does not exist in the Database");
                    request.getRequestDispatcher("findsupplier.jsp").include(request, response);
                }
            }catch(SQLException | NullPointerException ex){
               // Logger.getLogger(FindpaymentServlet.class.getName()).log(Level.SEVERE, null, ex);     
                System.out.println(ex.getMessage()== null ? "Supplier does not exist":"exist");
            }
        
        //}
        
    }

}
