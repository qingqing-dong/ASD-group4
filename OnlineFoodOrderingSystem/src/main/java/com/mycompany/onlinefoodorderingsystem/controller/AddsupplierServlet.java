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
 * @author ADMIN
 */
@WebServlet(name = "AddsupplierServlet", urlPatterns = {"/AddsupplierServlet"})
public class AddsupplierServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        
        String contactname = request.getParameter("contactname");
        String company = request.getParameter("company");
        String status = request.getParameter("status");
        int supplierphonenum = Integer.parseInt(request.getParameter("supplierphonenum"));
 
        SupplierManager supplierManager = (SupplierManager) session.getAttribute("supplierManager");
        validator.clear(session);
        
        
            try{
                Supplier exist = supplierManager.readSupplier(company);
                if(exist != null){
                    session.setAttribute("existErr", "Supplier already exists in the Database!");
                    request.getRequestDispatcher("addsupplier.jsp").include(request, response);
                }else{
                    supplierManager.createSupplier(contactname,company,supplierphonenum,status);
                    Supplier supplier = new Supplier(contactname,company,supplierphonenum,status);
                    session.setAttribute("Supplier",supplier);
                    session.setAttribute("resultInfor", "Add was successful");
                    request.getRequestDispatcher("supplier.jsp").include(request, response);
               
                }
            }catch(SQLException ex){
                Logger.getLogger(FindpaymentServlet.class.getName()).log(Level.SEVERE, null, ex);     
                //System.out.println(ex.getMessage()== null ? "Supplier does not exist":"exist");
            }
        
        
    }

}
