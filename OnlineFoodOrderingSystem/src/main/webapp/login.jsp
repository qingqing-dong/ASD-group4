<%-- 
    Document   : login
    Created on : 2021-10-10, 17:46:18
    Author     : Xin Chen
--%>

<%@page import="com.mycompany.onlinefoodorderingsystem.model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            Customer customer = new Customer(100,"","","","","","","");
            session.setAttribute("customer", customer); 
        %>
    </body>
</html>
