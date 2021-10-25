<%-- 
    Document   : menu.jsp
    Created on : 22 Sept 2021, 3:11:25 pm
    Author     : bhan
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
                <a class="navbar-brand" href="#">Customer Menu</a>
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
                    <a class="btn btn-secondary float-end my-3" href="staffMenu">Back</a>
                </div>
            </div>
            <% MenuItem item = (MenuItem) request.getAttribute("menuItem");%>
            <div class="row">
                <div class="col-12">
                    <form action="updateMenuItem" method="post" enctype="multipart/form-data">
                        <h3 class="text-primary text-center mb-3">Update Menu Item</h3>
                        <div class="row mb-3">
                            <label class="col-sm-2 col-form-label">Name</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="name" value="<%= item.getName() %>" required>
                                <input type="hidden" class="form-control" name="id" value="<%= item.getId() %>">
                            </div>
                        </div>
                        <div class="row mb-3">
                            <label class="col-sm-2 col-form-label">Description</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="description" value="<%= item.getDescription() %>">
                            </div>
                        </div>
                        <div class="row mb-3">
                            <label class="col-sm-2 col-form-label">Type</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="type" value="<%= item.getType() %>" required>
                            </div>
                        </div>
                        <div class="row mb-3">
                            <label class="col-sm-2 col-form-label">Unit</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="unit" value="<%= item.getUnit() %>" required>
                            </div>
                        </div>
                        <div class="row mb-3">
                            <label class="col-sm-2 col-form-label">Price</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="price" value="<%= item.getPrice() %>" required>
                            </div>
                        </div>
                        <div class="row mb-3">
                            <label class="col-sm-2 col-form-label">Picture</label>
                            <div class="col-sm-10">
                                <input type="file" class="form-control" name="picture">
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">Update Menu Item</button>
                    </form>
                </div>
            </div>

        </div>

    </body>
</html>
