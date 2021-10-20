<%-- 
    Document   : staffInfo
    Created on : 2021-10-10, 18:25:37
    Author     : Xin Chen
--%>

<%@page import="com.mycompany.onlinefoodorderingsystem.model.Staff"%>
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
                            <a class="nav-link active" href="staffInfo.jsp">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Link</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="staffUpdate.jsp">Update</a>
                        </li>
                    </ul>
                    <form class="d-flex">
                        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>
                </div>
            </div>
        </nav>
        
        
        <% 
            Staff staff = (Staff) session.getAttribute("staff"); 
            
            String[] address = staff.getAddress().split("§");
            for (int i = 0; i < 5; i++) {
                if (address[i].equals("null")) {
                    address[i] = "";
                }
            }
        %>
        
        <div>
            <table>
            <tr><th>Name</th> <td>${staff.firstName} ${staff.lastName}</td></tr>
            <tr><th>Position</th> <td>${staff.position}</td></tr>
            <tr><th>Email</th> <td>${staff.eMail}</td></tr>
            <tr><th>Password</th> <td>${staff.password}</td></tr>
            <tr><th>Gender</th> <td>${staff.gender}</td></tr>
            <tr><th>Address</th> <td><table class ="address">
                        <tr><th>street number</th> <td><%=address[0]%></td></tr>
                        <tr><th>Street name</th> <td><%=address[1]%></td></tr>
                        <tr><th>Suburb</th> <td><%=address[2]%></td></tr>
                        <tr><th>State</th> <td><%=address[3]%></td></tr>
                        <tr><th>Zip code</th> <td><%=address[4]%></td></tr>
                    </table></td></tr>
            
            <tr><th>Phone Number</th> <td>${staff.phoneNumber}</td></tr>
        </table>
        
        <a href="CustomerUpdateServlet?email='<%= staff.geteMail()%>'
                             &password='<%=staff.getPassword()%>'
                             &first_name='<%=staff.getFirstName()%>'
                             &last_name='<%=staff.getLastName()%>'
                             &gender='<%=staff.getGender()%>'
                             &address='<%=staff.getAddress()%>'
                             &phone_number='<%=staff.getPhoneNumber()%>'"> 
        Edit
        </a>
        
        </div>
    </body>
</html>
