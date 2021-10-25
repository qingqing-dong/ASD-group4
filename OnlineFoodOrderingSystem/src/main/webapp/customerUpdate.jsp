
<%@page import="com.mycompany.onlinefoodorderingsystem.model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dis<t/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="css/layout.css">
        <link rel="stylesheet" href="css/register.css">
        
        <title>Update Page</title>
    </head>
    <body>
        <%
            /*
            Customer customer = (Customer) session.getAttribute("customer");
            String updated = (String) session.getAttribute("updated");
            String deleted = (String) session.getAttribute("deleted");
            String[] address = customer.getAddress().split("§");
            for (int i = 0; i < 5; i++) {
                if (address[i].equals("null")) {
                    address[i] = "";
                }
            }*/
            Customer customer = (Customer) request.getAttribute("customer");
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
                            <a class="nav-link" href="#">Payment</a>
                        </li>
                    </ul>
                    <form class="d-flex">
                        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>
                </div>
            </div>
        </nav>
        
        <div class="register_form">
            <form action="customerUpdateInfo" method="post" onsubmit="return check();">
                <table>
            <tr><td>Your ID</td><input type="hidden"  name="id" value="<%=customer.getId() %>"required><td><%=customer.getId()%></td></tr>
            <tr><td>First Name:</td><td><input type="text" name="firstname" size="30" value="<%=customer.getFirstName()  %>"required></td></tr>
            <tr><td>Last Name:</td><td><input type="text" name="lastname" size="30" value="<%=customer.getLastName()  %>"required></td></tr>
            <tr><td>Gender:</td>
                <td><select class="select" name="gender">
                        <option value="<%=customer.getGender() %>"required><%=customer.getGender() %></option>
                        <option value="male">male</option>
                        <option value="female">female</option>
                        <option value="other">other</option>
                    </select>
                </td></tr>
            <tr><td>Phone number:</td><td><input id= "phone" type="text" name="phone" size="20"value="<%=customer.getPhoneNumber() %>"required></td></tr>
            <tr><td>Address:</td><td><input type="text" name="address" size="30" value="<%=customer.getAddress()  %>"required></td></tr>
            <tr><td>Email</td><td><input type="text" id="email" name="email" value="<%=customer.geteMail() %>"required></td></tr>
            <tr><td>Password</td><td><input type="password"  id="password" name="password"  value="<%=customer.getPassword() %>" required></td></tr>
            <tr><td><input class="button" type="submit" value="update"></td> <td><a type="cancel" href="customerInfo?id=<%= customer.getId()%>">back</a></td></tr>
        </table>
            </form>
            
        <script>
        function check(){
                    
            var m = document.getElementById("email");
            m=m.value;
            if(m.indexOf("@")<0){
                alert("Invaild email address!")
                return false;
            }
            if(m.indexOf(".")<0){
                    alert("Invaild email address!");
                    return false;
             }
            
            var p = document.getElementById("phone");
            p=p.value;
            var re = /^[0-9]*$/;
            if (!re.test(p))
            {
                alert("Invauld phone number!")
                return false; 
             }
  
        }
        
        </script>
        </div>
    </body>
</html>
