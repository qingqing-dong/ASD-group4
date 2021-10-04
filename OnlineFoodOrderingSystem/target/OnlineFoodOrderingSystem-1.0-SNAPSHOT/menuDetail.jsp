<%-- 
    Document   : menu.jsp
    Created on : 22 Sept 2021, 3:11:25 pm
    Author     : Jiahong Li
--%>

<%@page import="java.util.List"%>
<%@page import="com.mycompany.onlinefoodorderingsystem.model.MenuItem"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
            <div class="row">
                <% MenuItem item = (MenuItem) request.getAttribute("menuItem"); %>
                <div class="col-12">
                        <img src="menu_pictures/<%= item.getPicture()%>" class="card-img-top" style="width: 100%;">
                        <div class="card-body">
                            <h5 class="card-title"><%= item.getName()%></h5>
                            <p class="card-text"><%= item.getDescription()%></p>
                            <h5 class="card-text text-danger">$<%= item.getPrice()%></h5>
                            <a href="#" class="btn btn-primary">Add to Order</a>
                            <div class="btn-group btn-group-sm float-end mt-1" role="group" aria-label="Basic mixed styles example">
                                <a type="button" class="btn btn-outline-warning">Edit</a>
                                <a type="button" class="btn btn-outline-danger">Remove</a>
                            </div>
                        </div>
                </div>
            </div>

        </div>

    </body>
</html>
