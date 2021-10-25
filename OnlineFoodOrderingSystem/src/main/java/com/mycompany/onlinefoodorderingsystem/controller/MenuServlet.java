/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.onlinefoodorderingsystem.controller;

import com.mycompany.onlinefoodorderingsystem.dao.MenuDao;
import com.mycompany.onlinefoodorderingsystem.model.MenuItem;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/menu")
@MultipartConfig
public class MenuServlet extends HttpServlet {
    
    MenuDao menuDao = new MenuDao();
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("keyword") != null) {
            request.setAttribute("menu", menuDao.searchMenuItem(request.getParameter("keyword")));
        } else {
            request.setAttribute("menu", menuDao.getMenu());
        }
        request.getRequestDispatcher("menu.jsp").forward(request, response);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MenuItem item = new MenuItem();
        item.setName(request.getParameter("name"));
        item.setDescription(request.getParameter("description"));
        item.setType(request.getParameter("type"));
        item.setUnit(request.getParameter("unit"));
        item.setPrice(Double.parseDouble(request.getParameter("price")));
        Part filePart = request.getPart("picture");
        String fileName = filePart.getSubmittedFileName();
        item.setPicture(fileName);
        if (!fileName.isEmpty()) {
            String uploadPath = getServletContext().getRealPath("") + File.separator + "menu_pictures";
            File outputFilePath = new File(uploadPath + File.separator + fileName);
            InputStream inputStream = filePart.getInputStream();
            OutputStream outputStream = new FileOutputStream(outputFilePath);
            int read = 0;
            final byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
            outputStream.close();
            inputStream.close();
        } else {
            item.setPicture("noImage.png");
        }
        menuDao.createMenuItem(item);
        response.sendRedirect("staffMenu");
    }
}
