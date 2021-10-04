<%-- 
    Document   : customerInfo
    Created on : 2021-10-2, 16:23:53
    Author     : Xin Chen
--%>
<%@ page import="com.mycompany.onlinefoodorderingsystem.model.Customer"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Infomation</title>
    </head>
    <body>
        <%
        Customer customer = (Customer) session.getAttribute("customer");
        %>
         
        <table>
            <tr><td>ID</td><td><%=customer.getId()%></td></tr>
            <tr><td>First Name:</td><td><%=customer.getName()%></td></tr>
            <tr><td>Last Name:</td><td><%=customer.getName()%></td></tr>
            <tr><td>Gender:</td><td><%=customer.getGender()%></td></tr>
            <tr><td>Phone number:</td><td><%=customer.getPhone()%></td></tr>
            <tr><td>Date of birth:</td><td><%=customer.getDob()%></td></tr>
            <tr><td>Email</td></td><%=customer.getEmail()%></td></tr>
            <tr><td>Password</td><td><%=customer.getPassword()%></td></tr>
            <tr><td><a href="#">back</a></td></tr><tr><td><a href="customerUpdate.jsp">Update</a></td></tr>
        </table>
    </form>
    </body>
</html>
