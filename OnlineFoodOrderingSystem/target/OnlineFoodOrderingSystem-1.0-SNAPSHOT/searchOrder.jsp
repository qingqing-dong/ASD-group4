<%-- 
    Document   : searchOrder
    Created on : 2021-10-4, 20:31:05
    Author     : 47288
--%>

<%@page import="com.mycompany.onlinefoodorderingsystem.model.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%        
            Order order =(Order) session.getAttribute("order");
            String typeErr = (String) session.getAttribute("typeErr");
            String existErr = (String) session.getAttribute("existErr");
        %>
        <title>Search Order</title>
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
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
                            <a class="nav-link active" href="menu">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="menu">back</a>
                        </li>
                    </ul>
                    <form class="d-flex">
                        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>
                </div>
            </div>
        </nav>
        
        <div class="wholecontent">
            <div class="content">
                <h2>Search Order by Customer ID</h2>
                <small><%=(existErr != null ? existErr : "")%></small>
              <form method="post" action="searchOrderServlet">
                    <table>
                        <tr><td>customer ID </td><td><input type="text" placeholder="<%=(typeErr != null ? typeErr: "Enter type")%>" name="customerID" required="true"></td></tr>
                  </table>
                  <div>
                     <input class="button" type="submit" value="Search">
                  </div>
                </form>
            </div>
            
        </div>
                  
                  
                   <% if (order != null) { %>
            <div>                        
            <table class="table table-bordered text-nowrap">
                <tbody>
                    <tr>
                        <th class="">Name: </th>
                        <td>${order.ID}</td>
                    </tr>
                    <tr>
                        <th class="">Name: </th>
                        <td>${order.dishID}</td>
                    </tr>
                    <tr>
                        <th class="">Name: </th>
                        <td>${order.customerID}</td>
                    </tr>
                    <tr>
                        <th class="">Type: </th>
                        <td>${order.quantity}</td>
                    </tr>
                    <tr>
                        <th class="">Price: </th>
                        <td>${order.amount}</td>
                    </tr>
                    <tr>
                        <th class="">Stock: </th>
                        <td>${order.orderDate}</td>
                    </tr>
                </tbody>                                                        
            </table>
        </div>
            <% } else { %>
            <div></div>
            <% }%>
        
         </div>
    </body>
</html>
