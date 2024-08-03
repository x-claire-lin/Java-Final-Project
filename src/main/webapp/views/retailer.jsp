<%@page import="java.util.List"%>
<%@page import="model.Products"%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="header.jsp">
    <jsp:param name="pageTitle" value="Retailer Inventory Management" />
</jsp:include>
<head>
    <title>Retailer Inventory Management</title>
    <script type="text/javascript">
        // Basic client-side validation before form submission
        function validateForm() {
            // Example validation: Ensure salePrice is not empty and is a number
            var salePrice = document.forms["productForm"]["salePrice"].value;
            if (isNaN(salePrice) || salePrice == "") {
                alert("Sale Price must be a number.");
                return false;
            }
            // Add other validations as needed
            return true;
        }
    </script>

     <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet" type="text/css" />
    <style>
        .red-background {
            background-color: red;
        }
    </style>
</head>
<body>
<jsp:include page="topbar.jsp"/>


<h2>Inventory Management</h2>


<table border="1">
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Sale Price</th>
            <th>Discount Price</th>
            <th>Inventory Amount</th>
            <th>Discount Amount</th>
            <th>Donation Amount</th>
            <th>Product Type</th>
            <th>Surplus Flag</th>
            <th>Expiry Date</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
    <%
        List<Products> productList = (List<Products>) request.getAttribute("products");
        if (productList != null && !productList.isEmpty()) {
            for (Products product : productList) {
    %>
    <tr>
        <td><%= product.getProductID() %></td>
        <td><%= product.getProductName() %></td>
        <td><%= product.getSalePrice() %></td>
        <td><%= product.getDiscountPrice() %></td>
        <td class="time-cell-3"><%= product.getInventoryAmount() %></td>
        <td><%= product.getDiscountAmount() %></td>
        <td><%= product.getDonationAmount() %></td>
        <td><%= product.getProductType() %></td>
        <td><%= product.getSurplusFlag() %></td>
        <td class="time-cell-2"><%= product.getExpiryDate() %></td>
        <td>
            <a href="UpdateProductServlet?productID=<%= product.getProductID() %>">Update</a>
        </td>
    </tr>
    <%
            }
        } else {
    %>
    <tr>
        <td colspan="11">No products found.</td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>

<h3>Add New Product</h3>
<form name="productForm" action="../ProductManagementServlet" onsubmit="return validateForm()" method="POST">
    <!-- Assuming the userID is stored in the session -->
    <% Integer userID = (Integer) session.getAttribute("userID"); %>
    <% if (userID != null) { %>
        <input type="hidden" name="userID" value="<%= userID %>">
    <% } %>
    Name: <input type="text" name="productName" required><br>
    Sale Price: <input type="number" step="0.01" name="salePrice" required><br>
    Discount Price: <input type="number" step="0.01" name="discountPrice"><br>
    Inventory Amount: <input type="number" name="inventoryAmount" required><br>
    Discount Amount: <input type="number" name="discountAmount"><br>
    Donation Amount: <input type="number" name="donationAmount"><br>
    Product Type: 
    <select name="productType" required>
        <option value="bread">Bread</option>
        <option value="meat">Meat</option>
        <option value="fruit">Fruit</option>
        <option value="vegi">Vegi</option>
        <option value="dairy">Dairy</option>
    </select><br>
    Surplus Flag: <input type="text" name="surplusFlag"><br>
    Expiry Date: <input type="date" name="expiryDate" required><br>
    <input type="submit" value="Add Product">

</form>
    <!--<a href="/surplusProducts.jsp">Go to Surplus Products</a><br>-->
<!--    <a href="/LogoutServlet">Log Out</a>-->
<script>
    function addDays(date, days) {
        const copy = new Date(Number(date));
        copy.setDate(date.getDate() + days);
        return copy;
    }

    document.querySelectorAll('.time-cell-3').forEach(cell => {
        const inventory = cell.textContent;

        if (inventory >= 100) {
            cell.classList.add('red-background');
        }
    });

    const today = new Date();
    const daysToAdd = 7; // 加几天

    document.querySelectorAll('.time-cell-2').forEach(cell => {
        const cellDate = new Date(cell.textContent);
        const futureDate = addDays(today, daysToAdd);

        if (cellDate <= futureDate) {
            cell.classList.add('red-background');
        }
    });
</script>
</body>
</html>
