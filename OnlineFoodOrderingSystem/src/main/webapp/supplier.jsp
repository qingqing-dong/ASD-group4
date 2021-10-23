<%-- 
    Document   : supplier
    Created on : 2021-10-20, 22:19:31
    Author     : ADMIN
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.onlinefoodorderingsystem.model.Supplier"%>
<%@page import="com.mycompany.onlinefoodorderingsystem.dao.SupplierManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Supplier Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
    </head>
    <body>
         <div class="nav">
              <img class="img1" src="css/title.png" alt="background" width=300px height=70px>
              <span id="links"> <a href="index.jsp" style="text-decoration:none;"> Back</a> | <a href="logout.jsp" style="text-decoration:none;">Logout </a></span>
           
        </div>
        <hr style="margin-top: 25px;"/>
        <div class="wholecontent">
          
              <%
                SupplierManager supplierManager =(SupplierManager)session.getAttribute("supplierManager");
                ArrayList<Supplier> list = supplierManager.fecthSuppliers();
                 String resultInfor = (String) session.getAttribute("resultInfor");
              %>
            <center>
                <h1>Supplier Management</h1>
                <h2>
                    <a href="addsupplier.jsp">Create New Supplier</a>
                 
                    &nbsp;&nbsp;&nbsp;
                    <a href="findsupplier.jsp">Find a Supplier</a>
             
                </h2>
            </center>
            
            <table border="1" cellpadding="5" align="center">
                <caption><h2>List of Suppliers</h2></caption><small><%=(resultInfor != null ? resultInfor : "")%></small>
                <tr>
                    <th>SupplierID</th>
                    <th>Contact Name</th>
                    <th>Company</th>
                    <th>Phone Number</th>
                    <th>Status</th>
                   
                   
                    
                </tr>
             
               <%
                   for(Supplier supplier : list){
               %>
                    <tr>
                        
                        <td><%=supplier.getSupplierID()%></td>
                        <td><%=supplier.getContactName()%></td>
                        <td><%=supplier.getCompany()%></td>
                        <td><%=supplier.getSupplierPhoneNum()%></td>
                        <td><%=supplier.getStatus()%></td>
                        
                       
                    </tr>
                   <%}%>
            
            </table>
               
        </div> 
             <jsp:include page="/ConnServlet" flush="true" />
    </body>
</html>
