<%-- 
    Document   : findsupplier
    Created on : 2021-10-20, 21:37:42
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Find supplier Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="nav">
              <img class="img1" src="css/title.png" alt="background" width=300px height=70px>
              <span id="links"> <a href="supplier.jsp" style="text-decoration:none;"> Back</a> | <a href="logout.jsp" style="text-decoration:none;">Logout </a></span>
           
        </div>
        <hr style="margin-top: 25px;"/>
       
        
        <div class="wholecontent">
             
        <%
            String existErr = (String) session.getAttribute("existErr");
        %>
            <h1>Search for supplier<span class="message"><%=(existErr != null ? existErr : "")%></span></h1>
            <form id="form" action="FindsupplierServlet" method="post">
                <table id="table">
                      <tr><td><input type="text" placeholder="Enter the Company" name="company" required="true"></td></tr>
                      
                      
                </table>           
                <div>
                    <input class="button" type="submit" value="Search">
                </div>
            </form>
        
        </div>
    </body>
</html>
