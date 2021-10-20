<%-- 
    Document   : customerInfo
    Created on : 2021-10-10, 16:58:44
    Author     : Xin Chen
--%>

<%@page import="com.mycompany.onlinefoodorderingsystem.model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dis<t/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
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
            Customer customer = (Customer) session.getAttribute("customer"); 
            
            String[] address = customer.getAddress().split("§");
            for (int i = 0; i < 5; i++) {
                if (address[i].equals("null")) {
                    address[i] = "";
                }
            }
        %>
        
        <%---This is table to show the info of a customer, only ---%>
        <div>
            <table>
            <tr><th>Name</th> <td>${customer.firstName} ${customer.lastName}</td></tr>
            <tr><th>Email</th> <td>${customer.eMail}</td></tr>
            <tr><th>Password</th> <td>${customer.password}</td></tr>
            <tr><th>Gender</th> <td>${customer.gender}</td></tr>
            <tr><th>Address</th> <td><table class ="address">
                        <tr><th>street number</th> <td><%=address[0]%></td></tr>
                        <tr><th>Street name</th> <td><%=address[1]%></td></tr>
                        <tr><th>Suburb</th> <td><%=address[2]%></td></tr>
                        <tr><th>State</th> <td><%=address[3]%></td></tr>
                        <tr><th>Zip code</th> <td><%=address[4]%></td></tr>
                    </table></td></tr>
            <tr><th>Phone Number</th> <td>${customer.phoneNumber}</td></tr>
        </table>
        
        <a href="CustomerUpdateServlet?email='<%= customer.geteMail()%>'
                             &password='<%=customer.getPassword()%>'
                             &first_name='<%=customer.getFirstName()%>'
                             &last_name='<%=customer.getLastName()%>'
                             &gender='<%=customer.getGender()%>'
                             &address='<%=customer.getAddress()%>'
                             &phone_number='<%=customer.getPhoneNumber()%>'"> 
        Edit
        </a>
        
        </div>
        
    </body>
</html>
