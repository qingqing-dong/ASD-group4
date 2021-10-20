<%-- 
    Document   : staffUpdate
    Created on : 2021-10-10, 18:26:45
    Author     : Xin Chen
--%>

<%@page import="com.mycompany.onlinefoodorderingsystem.model.Staff"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dis<t/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
        <title>JSP Page</title>
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
                            <a class="nav-link active" href="staffInfo.jsp">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Link</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="staffUpdate.jsp">Update</a>
                        </li>
                    </ul>
                    <form class="d-flex">
                        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>
                </div>
            </div>
        </nav>
        
        <%
            Staff staff = (Staff) session.getAttribute("staff");
            String updated = (String) session.getAttribute("updated");
            String deleted = (String) session.getAttribute("deleted");
            String[] address = staff.getAddress().split("§");
            for (int i = 0; i < 5; i++) {
                if (address[i].equals("null")) {
                    address[i] = "";
                }
            }
        %>
        
         <form action="StaffUpdateServlet" method="post" onsubmit="return check();">
                <h1>Edit User <span class="message"><%=(updated != null ? updated : "")%></span></h1>
                <p class ="head">E-mail</p>
                <input type="text" name="email" placeholder="E-mail" value="<%= staff.geteMail()%>"required>
                <table>
                    <tr><th><p class ="head">First Name</p></th> <th><p class ="head">Last Name</p></th></tr>
                    <tr><td><input type="text" name="first_name" placeholder="first name" value="<%= staff.getFirstName()%>"required></td> <td><input type="text" name="last_name" placeholder="last name" value="<%= staff.getLastName()%>"required></td></tr>
                </table>
                <p class ="head">Password</p>
                <input type="password" name="password" placeholder="Password" value="<%= staff.getPassword()%>"required>
                <p class ="head">Gender</p>
                <select class="select" name="gender">
                    <option value="<%= staff.getGender()%>"><%= staff.getGender()%></option>
                    <option value="male">Male</option>
                    <option value="female">Female</option> 
                    <option value="other">Other</option> 
                </select>
                <p class ="head">Address</p>
                <table class="address">
                    <td><input type="number" name="streetNumber" placeholder="street no" value="<%= address[0]%>"required></td> <td><input type="text" name="streetName" placeholder="street name" value="<%= address[1]%>"required></td> <td><input type="text" name="suburb" placeholder="suburb" value="<%= address[2]%>"required></td> <td><input type="text" name="state" placeholder="state" value="<%= address[3]%>"required></td><td><input type="number" name="zipcode" placeholder="zip code" value="<%= address[4]%>"required></td>
                </table>
                <p class ="head">Phone Number</p>
                <input type="tel" name="phone_number" placeholder="phone number" value="<%= staff.getPhoneNumber()%>"required>
                <input type="submit" name="Register" value="Update">
                <input type="hidden" value="<%= staff.getId()%>" name="submitted">
            </form>
            
            <script>
            function check(){
                    
            var m = document.getElementByName("email");
            m=m.value;
            if(m.indexOf("@")<0){
                alert("Invaild email address!")
                return false;
            }
            
            var p = document.getElementByName("phone");
            p=p.vaule;
                if(isNaN(p))
                {
                    alert("Invauld phone number!")
                    return false;
                }
            }
            </script>
    </body>
</html>
