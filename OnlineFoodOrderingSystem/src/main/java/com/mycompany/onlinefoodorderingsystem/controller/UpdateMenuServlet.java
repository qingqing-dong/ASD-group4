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

@WebServlet("/updateMenuItem")
@MultipartConfig
public class UpdateMenuServlet extends HttpServlet {

    MenuDao menuDao = new MenuDao();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MenuItem item = menuDao.getMenuItemById(Integer.parseInt(request.getParameter("id")));
        System.out.println(item);
        request.setAttribute("menuItem", item);
        request.getRequestDispatcher("updateMenuItem.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MenuItem item = new MenuItem();
        item.setId(Integer.parseInt(request.getParameter("id")));
        item.setName(request.getParameter("name"));
        item.setDescription(request.getParameter("description"));
        item.setType(request.getParameter("type"));
        item.setUnit(request.getParameter("unit"));
        item.setPrice(Double.parseDouble(request.getParameter("price")));
        Part filePart = request.getPart("picture");
        if(filePart != null){
            String fileName = filePart.getSubmittedFileName();
            item.setPicture(fileName);
            String uploadPath = getServletContext().getRealPath("") + File.separator + "menu_pictures";
            File outputFilePath = new File(uploadPath + File.separator +fileName);
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
        menuDao.updateMenuItem(item);
        response.sendRedirect("staffMenu");
    }
}
