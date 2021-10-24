<%-- 
    Document   : viewsearchsupplier
    Created on : 2021-10-20, 22:31:11
    Author     : ADMIN
--%>

<%@page import="com.mycompany.onlinefoodorderingsystem.model.Supplier"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View search supplier Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
    </head>
    <body>
         <div class="nav">
              <img class="img1" src="css/title.png" alt="background" width=300px height=70px>
              <span id="links"> <a href="payment.jsp" style="text-decoration:none;"> Paymentlist</a> | <a href="logout.jsp" style="text-decoration:none;">Logout </a></span>
           
        </div>
        <hr style="margin-top: 25px;"/>
        <div class="wholecontent">
             <%
                Supplier supplier = (Supplier) session.getAttribute("supplier"); 
                String existErr = (String) session.getAttribute("existErr");
                
                String resultInfor = (String) session.getAttribute("resultInfor");
            %>
            <h2>Update a Supplier</h2><small><%=(resultInfor != null ? resultInfor : "")%></small>
            
                <form id="form" action="UpdatesupplierServlet"  method="post">
                <table id="table">
                    <tr><td>SupplierID:<input type="text" placeholder="<%=supplier.getSupplierID()%>" name="supplierid" required="true"></td></tr>
                    <tr><td>Contact Name:<input type="text" placeholder="<%=supplier.getContactName()%>" name="contactname" required="true"></td></tr>
                    <tr><td>Company:<input type="text" placeholder="<%=supplier.getCompany()%>"name="company"></td></tr>
                    <tr><td>Phone Number:<input type="text" placeholder="<%=supplier.getSupplierPhoneNum()%>" name="supplierphonenum" required="true"></td></tr>
                    <tr><td>Status:<input type = "text" placeholder="<%=supplier.getStatus()%>"  name="status" required="true"/></td></tr>
                    
                 
                </table>
                <div>
                    <a href="index.jsp">Cancle</a>  
                    <input class="button" type="submit" value="Update">
                </div>
                    
                    
            </form>
                     <h2>Delete a Payment</h2><small><%=(resultInfor != null ? resultInfor : "")%></small>
            <span class="message">
                <%=(existErr != null ? existErr : "")%>
            </span>
                     <form id="form" action="DeletesupplierServlet"  method="post">
                <table id="table">
                    <tr><td>SupplierID:<input type="text" placeholder="<%=supplier.getSupplierID()%>" name="supplierid" required="true"></td></tr>
                    
                 
                </table>
                <div>
                    <a href="index.jsp">Cancle</a>  
                    <input class="button" type="submit" value="Delete">
                </div>
            </form>
        </div>
    </body>
</html>
