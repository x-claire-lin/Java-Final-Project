<%--
    Document   : Subscriptionjsp
--%>

<%@page import="model.ProductTypes"%>
<%@page import="model.UserSubscription"%>
<%@page import="java.util.ArrayList" %>
<%@page import="javax.servlet.http.HttpSession" %>
<%ArrayList<UserSubscription> subscription = (ArrayList<UserSubscription>) request.getAttribute("subscription");%>
<%ArrayList<ProductTypes> productTypes = (ArrayList<ProductTypes>) request.getAttribute("productTypes");%>
<% String username = (String) session.getAttribute("username");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<jsp:include page="header.jsp">
    <jsp:param name="pageTitle" value="Retailer Inventory Management" />
</jsp:include>
    <head>
        <title>Donation food </title>
    </head>
    <body>
        <jsp:include page="topbar.jsp"/>
        <div><a href="../SubscriptionMsgsServlet">View subscribed messages</a></div>
        <div>
            <a href="LogoutServlet">Logout</a>
            <h2>My Subscription</h2>
            <p><%= username%></p>
            <table border="1">
                <thead>
                    <tr>
                        <th>Subscription ID</th>
                        <th>Product Type</th>
                        <th>Location</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>

                    <%for (UserSubscription s : subscription) {%>
                    <tr>
                        <td><%= s.getSubscriptionID() %></td>
                        <td><%= s.getProductType() %></td>
                        <td><%= s.getUserCity() %></td>
                        <td><button onclick="submitForm('<%= s.getSubscriptionID() %>')">Delete</button></td>

                    </tr>
                    <% }%>
                </tbody>
            </table>
        </div>
        <div>
            <head>
            <title>Donation food </title>
            </head>
        </div>

        <div>
            <h2>Subscription</h2>

            <table border="1">
                <thead>
                    <tr>

                        <th>Product Type</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>

                    <%for (ProductTypes t : productTypes) {%>
                    <tr>

                        <td><%= t.getType() %></td>
                        <td><button onclick="submitFormType('<%= t.getType() %>')">Add</button></td>

                    </tr>
                    <% }%>
                </tbody>
            </table>
        </div>
        <!-- Hidden form  for pass data to Servlet -->
    <form id="redirectForm" action="../SubscriptionDeleteServlet" method="post">
        <input type="hidden" name="id" id="idInput">
    </form>
    <form id="redirectForm1" action="../SubscriptionAddServlet" method="post">
        <input type="hidden" name="productType" id="productType">
        <input type="hidden" name="userID" id="idUser">
        <input type="hidden" name="subscription" id="sub">
    </form>
    <script>
        function submitForm(id) {

            alert("You delted Subscription ID is "+id+"!");
            //set form data
            document.getElementById("idInput").value = id;
            //submit form
            document.getElementById("redirectForm").submit();

        }
        function submitFormType(type) {

            alert("You Add Subscription Type is " + type + "!");
            // set form data
            document.getElementById("productType").value = type;

            // submit form
            document.getElementById("redirectForm1").submit();
        }
        </script>


    </body>
</html>