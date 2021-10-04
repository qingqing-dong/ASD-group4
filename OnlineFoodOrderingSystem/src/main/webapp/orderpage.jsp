<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.onlinefoodorderingsystem.model.Order"%>
<%@page import="com.mycompany.onlinefoodorderingsystem.dao.OrderDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
    </head>
    <body>
        <%
            
            OrderDao orderDao = (OrderDao) session.getAttribute("orderDao");
            ArrayList<Order> orderLists = orderDao.listAllOrder();
        %>
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
                            <a class="nav-link" href="index.html">back</a>
                        </li>
                    </ul>
                    <form class="d-flex">
                        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>
                </div>
            </div>
        </nav>                               
         </div>
        <div class="container">
                        <h4>All Device</h4>
                    </div>
        <table>
            <thead>
                <tr>
                    <th width="300">ID</th>
                    <th width="150">dishID</th>
                    <th width="70">customerID</th>
                    <th width="70">Quantity</th>
                    <th width="70">Amount</th>
                    <th width="70">orderDate</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for(Order order1:orderLists){
                %>
                    <tr>
                        <td width="100"><%=order1.getID()%></td>
                        <td width="100"><%=order1.getDishID()%></td>
                        <td width="100"><%=order1.getCustomerID()%></td>
                        <td width="100"><%=order1.getQuantity()%></td>
                        <td width="100"><%=order1.getAmount()%></td>
                        <td width="100"><%=order1.getOrderDate()%></td>                      
                    </tr>
                    <%}%>
                    
            </tbody>
        </table>
        
    </body>
</html>
