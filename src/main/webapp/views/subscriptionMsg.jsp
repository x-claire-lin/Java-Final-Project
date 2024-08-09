<%@page import="model.SubscriptionMsg" %>
<%@page import="java.util.ArrayList" %>
<%@page import="model.DonationView" %>
<%@page import="businesslayer.ProductService" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Products" %>
<%List<Products> messages = (ArrayList<Products>) request.getAttribute("productsList");%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>
<jsp:include page="header.jsp">
    <jsp:param name="pageTitle" value="Retailer Inventory Management"/>
</jsp:include>
<head>
    <title>Donation food </title>
</head>
<body>
<jsp:include page="topbar.jsp"/>
<h2>Subscription Messages</h2>

<table border="1">
    <thead>
    <tr>
        <th>product ID</th>
        <th>product Name</th>
        <th>discount price</th>
        <th>discount amount</th>
        <th>expire date</th>
        <th>salePrice</th>
        <th>inventoryAmount</th>
    </tr>
    </thead>
    <tbody>

    <%for (Products message : messages) {%>
    <tr>
        <td><%= message.getProductID()%>
        </td>
        <td><%= message.getProductName() %>
        </td>
        <td><%= message.getDiscountPrice() %>
        </td>
        <td><%= message.getDiscountAmount() %>
        </td>
        <td><%= message.getExpiryDate() %>
        </td>
        <td><%= message.getSalePrice() %>
        </td>
        <td><%= message.getInventoryAmount() %>
        </td>
    </tr>
    <% }%>
    </tbody>
</table>


<form id="redirectForm" action="../SubscriptionMsgsDeleteServlet" method="post">
    <input type="hidden" name="id" id="idInput">
</form>

<script>
    function submitForm(id) {

        alert("You deleted message ID is " + id + "!");

        document.getElementById("idInput").value = id;

        document.getElementById("redirectForm").submit();

    }
</script>

</body>
</html>