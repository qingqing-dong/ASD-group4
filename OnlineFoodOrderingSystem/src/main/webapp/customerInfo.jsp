<%-- 
    Document   : customerInfo
    Created on : 2021-10-10, 16:58:44
    Author     : Xin Chen
--%>

<%@page import="com.mycompany.onlinefoodorderingsystem.dao.CustomerDao"%>
<%@page import="com.mycompany.onlinefoodorderingsystem.model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dis<t/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="css/info.css">
        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Navbar</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" href="#">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Payment</a>
                        </li>
                    </ul>
                    <form class="d-flex">
                        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>
                </div>
            </div>
        </nav>
        
        <%--Load customer from session, this should be pased from previous page--%>
        <% 
            
       //Customer customer = (Customer) request.getAttribute("customer");
           /* Customer customer = new Customer();
            customer.setId(100);
            customer.setFirstname("Justiney");
            customer.setLastname("Jithin");
            customer.setEmail("justiney@gdk.com");
            customer.setPassword("00002");
            customer.setPhone("0123456789");
            customer.setGender("female");
            customer.setAddress("2 willis st");*/
           
           CustomerDao customerDao = new CustomerDao();
           Customer customer = customerDao.getCustomerById(100);
            
            
        %>
        
        <%---This is table to show the info of a customer, only ---%>
        <div class="info">
            <table>
            <tr><th>Name</th> <td><%=customer.getFirstName()%> <%=customer.getLastName()%></td></tr>
            <tr><th>Email</th> <td><%=customer.geteMail()%></td></tr>
            <tr><th>Password</th> <td><%=customer.getPassword()%></td></tr>
            <tr><th>Gender</th> <td><%=customer.getGender()%></td></tr>
            <tr><th>Address</th> <td><%=customer.getAddress()%></td></tr>
            <tr><th>Phone Number</th> <td><%=customer.getPhoneNumber()%></td></tr>
        </table>
        
        <a typr="Edit" href="customerUpdateInfo?id=<%= customer.getId()%>"> 
        Edit
        </a>
        
        </div>
        
    </body>
</html>
