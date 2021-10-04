<%@ page import="com.mycompany.onlinefoodorderingsystem.model.Customer"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <title>Customer Infomation Update</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='main.css'>
</head>
<body>
    <%
    Customer customer = (Customer) session.getAttribute("customer");
    %>
    <form action="CustomerUpdateServlet" method="post" >
        <table>
            <tr><td>Your ID</td><td><%=customer.getId()%></td></tr>
            <tr><td>First Name:</td><td><input type="text" name="firstname" size="30" value="<%=customer.getFirstname()  %>"></td></tr>
            <tr><td>First Name:</td><td><input type="text" name="lasttname" size="30" value="<%=customer.getLastname()  %>"></td></tr>
            <tr><td>Gender:</td>
                <td><select class="select" name="gender">
                        <option value="<%=customer.getGender() %>"><%=customer.getGender() %></option>
                        <option value="male">male</option>
                        <option value="female">female</option>
                        <option value="other">other</option>
                    </select>
                </td></tr>
            <tr><td>Phone number:</td><td><input type="text" name="phone" size="20"value="<%=customer.getPhone() %>"></td></tr>
            <tr><td>Address:</td><td><input type="text" name="lastname" size="30" value="<%=customer.getAddress()  %>"></td></tr>
            <tr><td>Email</td><td><input type="hidden" name="email" value="<%=customer.getEmail() %>"></td></tr>
            <tr><td>Password</td><td><input type="hidden" name="password" value="<%=customer.getPassword() %>"></td></tr>
            <tr><td><input class="button" type="submit" value="update"></td><td><a href="#">back</a></td></tr>
        </table>
    </form>
</body>
</html>