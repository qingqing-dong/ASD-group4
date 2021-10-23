<%-- 
    Document   : payment
    Created on : 2021-10-4, 0:15:44
    Author     : ADMIN
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.onlinefoodorderingsystem.dao.PaymentManager;"%>
<%@page import="com.mycompany.onlinefoodorderingsystem.model.Payment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>payment Page</title>
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
                            <a class="nav-link active" href="#">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Link</a>
                        </li>
                    </ul>
                    <form class="d-flex">
                        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>
                </div>
            </div>
        </nav>
        <div class="container" style="width: 800px;" >
            <div class="row">
                <div class="col-12 mt-3">
                    <a class="btn btn-secondary float-end my-3" href="menu">Back</a>
                </div>
            </div>
        <hr style="margin-top: 25px;"/>
        <div class="wholecontent">
          /*
              <%
                PaymentManager paymentManager =(PaymentManager)session.getAttribute("paymentManager");
                ArrayList<Payment> list = paymentManager.fecthPayments();
                 String resultInfor = (String) session.getAttribute("resultInfor");
              %>
             */ 
            <center>
                <h1>Payment Management</h1>
                <h2>
                    <a href="addpayment.jsp">Create New Payment</a>
                 
                    &nbsp;&nbsp;&nbsp;
                    <a href="findpayment.jsp">Find a Payment</a>
             
                </h2>
            </center>
            
            <table border="1" cellpadding="5" align="center">
                <caption><h2>List of Payments</h2></caption><small><%=(resultInfor != null ? resultInfor : "")%></small>
                <tr>
                    <th>PaymentID</th>
                    <th>OrderID</th>
                    <th>PaymentMethod</th>
                    <th>CardNumber</th>
                    <th>Amount</th>
                    <th>Date</th>
                   
                    
                </tr>
             
               <%
                   for(Payment payment : list){
               %>
                    <tr>
                        
                        <td><%=payment.getPaymentID()%></td>
                        <td><%=payment.getOrderID()%></td>
                        <td><%=payment.getPaymentMethod()%></td>
                        <td><%=payment.getCardnumber()%></td>
                        <td><%=payment.getAmount()%></td>
                        <td><%=payment.getPaymentDate()%></td>
                       
                    </tr>
                   <%}%>
            
            </table>
               
        </div> 
             <jsp:include page="/ConnServlet" flush="true" />
             
    </body>
</html>
