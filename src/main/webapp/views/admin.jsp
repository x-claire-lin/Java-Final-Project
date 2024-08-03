
<%@page import="java.util.List"%>
<%-- 
    Document   : donations
    Created on : Apr 5, 2024, 8:18:56 a.m.
    Author     : Dunxing Yu
--%>
<%@page import="java.util.ArrayList" %>
<%@page import="model.User" %>
<%@page import="businesslayer.ProductsBusinessLogic" %>
<% ProductsBusinessLogic d = new ProductsBusinessLogic();
List<User> users = (List<User>) request.getAttribute("users");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <jsp:include page="header.jsp">
    <jsp:param name="pageTitle" value="Inventory Manager" />
    </jsp:include>
    <head>
        <title>Admin</title>
    </head>
    <body>
    <jsp:include page="topbar.jsp"/>    

        
        
        <h2>User list</h2>
        <div class="container clearfix">
            <div class="main-wrap">
            <table class="search-tab" border="1">
                <thead>
                    <tr>
                        <th>User ID</th>
                        <th>User Name</th>
                        <th>User Email</th>
                        <th>User Phone Number</th>
                        <th>User Password</th>
                        <th>User City</th>
                        <th>User Type</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>

                    <%for (User user : users) {%>
                    <tr>
                        <td><%= user.getUserID()%></td>
                        <td><%= user.getUserName() %></td>
                        <td><%= user.getUserEmail()%></td>                    
                        <td><%= user.getUserPhoneNumber() %></td>
                        <td><%= user.getUserPassword() %></td>
                        <td><%= user.getUserCity() %></td>
                        <td><%= user.getUserType() %></td>
                        <td><button onclick="submitForm('<%= user.getUserID() %>')">Delete</button></td>
                    </tr>
                    <% }%>
                </tbody>
            </table>
            </div>
        </div>

        <form id="redirectForm" action="<%= request.getContextPath() %>/AdminDeleteServlet" method="post">
        <input type="hidden" name="id" id="idInput">
        </form>

    <script>
       function submitForm(id) {
              
            alert("You deleted User ID is "+id+"!");
            //set form data
            document.getElementById("idInput").value = id;
            //submit form
            document.getElementById("redirectForm").submit();
            
        }
    </script>   
     
    </body>
</html>