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
                <a class="navbar-brand" href="#">Staff Menu</a>
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
                    <form class="d-flex" action="staffMenu">
                        <input class="form-control me-2" type="search" placeholder="Search" name="keyword">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>
                </div>
            </div>
        </nav>
        <div class="container-md">
            <div class="row">
                <div class="col-12 mt-3">
                    <a class="btn btn-outline-success float-end" href="createMenuItem.jsp">+ Add New Menu Item</a>
                </div>
            </div>
            <div class="row">
                <table class="table table-striped">
                    <tr>
                        <th>#</th>
                        <th>Name</th>
                        <th>Type</th>
                        <th>Picture</th>
                        <th>Price</th>
                        <th>Actions</th>
                    </tr>
                    <% List<MenuItem> menu = (List<MenuItem>) request.getAttribute("menuItems");
                    int id = 1;%>
                    <%for (MenuItem item : menu) {
                    %>
                    <tr>
                        <td><%= id++%></td>
                        <td><%= item.getName()%></td>
                        <td><%= item.getType()%></td>
                        <td><img src="menu_pictures/<%= item.getPicture()%>" style="height: 100px;"></td>
                        <td>$<%= item.getPrice()%></td>
                        <td>
                            <div class="btn-group btn-group-sm">
                                <a class="btn btn-outline-secondary" href="updateMenuItem?id=<%= item.getId()%>">Edit</a>
                                <a class="btn btn-outline-secondary" href="deleteMenuItem?id=<%= item.getId()%>">Remove</a>
                            </div>
                        </td>
                    </tr>
                    <%
                    }%>
                </table>
            </div>

        </div>

    </body>
</html>