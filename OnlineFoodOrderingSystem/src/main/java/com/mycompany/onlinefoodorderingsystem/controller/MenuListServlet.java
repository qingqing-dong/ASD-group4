/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.onlinefoodorderingsystem.controller;

import com.mycompany.onlinefoodorderingsystem.dao.MenuDao;
import com.mycompany.onlinefoodorderingsystem.model.MenuItem;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/staffMenu")
public class MenuListServlet extends HttpServlet {

    MenuDao menuDao = new MenuDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("keyword") != null) {
            request.setAttribute("menuItems", menuDao.searchMenuItem(request.getParameter("keyword")));
        } else {
            request.setAttribute("menuItems", menuDao.getMenu());
        }
        request.getRequestDispatcher("staffMenu.jsp").forward(request, response);
    }
}
