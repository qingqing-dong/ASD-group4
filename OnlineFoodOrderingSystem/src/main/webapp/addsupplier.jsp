<%-- 
    Document   : addsupplier
    Created on : 2021-10-20, 20:59:49
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add supplier Page</title>
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
        <div class="wholecontent">
            <%
            String existErr = (String) session.getAttribute("existErr");
            %>
          
            <h2>Add a Supplier</h2>
            <span class="message">
               <%=(existErr != null ? existErr : "")%>
            </span>
                <form id="form" action="localhost:80/supplier.jsp"  method="post">
                <table id="table">

                    <tr><td><input type="text" placeholder="Enter the Contact Name" name="contactname" required="true"></td></tr>
                    <tr><td><input type="text" placeholder="Enter the Company" name="company" required="true"></td></tr>
                    <tr><td><input type="text" placeholder="Enter the Phone Number" name="supplierphonenum" required="true"></td></tr>
                    <tr><td><input type = "text" placeholder="Enter the Status"  name="status" required="true"/></td></tr>
                    
                    

                </table>
                <div>
                    <a href="index.jsp">Cancle</a>  
                    <input class="button" type="submit" value="Add">
                </div>
            </form>
        </div>
    </body>
</html>
