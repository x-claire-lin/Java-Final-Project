<%@page import="java.util.List"%>
<%@page import="model.Products"%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Products product = (Products) request.getAttribute("productsById");
%>
<html>
<jsp:include page="header.jsp">
    <jsp:param name="pageTitle" value="Retailer Inventory Management" />
</jsp:include>
<head>

</head>
<body>
<jsp:include page="topbar.jsp"/>
<h3>Update Product</h3>
<form name="productForm" action="${pageContext.request.contextPath}/UpdateProductSubmitServlet" onsubmit="return validateForm()" method="POST">
    <!-- Assuming the userID is stored in the session -->
     <input type="hidden" name="productID" value="<%=product.getProductID() %>">
    Name: <input type="text" value="<%=product.getProductName() %>" name="productName" required><br>
    Sale Price: <input type="number" step="0.01" value="<%=product.getSalePrice() %>" name="salePrice" required><br>
    Discount Price: <input type="number" step="0.01" value="<%=product.getDiscountPrice() %>" name="discountPrice"><br>
    Inventory Amount: <input type="number" value="<%=product.getInventoryAmount() %>" name="inventoryAmount" required><br>
    Discount Amount: <input type="number" value="<%=product.getDiscountAmount() %>" name="discountAmount"><br>
    Donation Amount: <input type="number" value="<%=product.getDonationAmount() %>" name="donationAmount"><br>
    Product Type:
    <select name="productType" value="<%=product.getProductType() %>" required>
        <option value="bread">Bread</option>
        <option value="meat">Meat</option>
        <option value="fruit">Fruit</option>
        <option value="vegi">Vegi</option>
        <option value="dairy">Dairy</option>
    </select><br>
    Surplus Flag: <input type="text" value="<%=product.getSurplusFlag() %>" name="surplusFlag"><br>
    Expiry Date: <input type="date" value="<%=product.getExpiryDate() %>" name="expiryDate" required><br>
    <input type="submit" value="update Product">

</form>
    <!--<a href="/surplusProducts.jsp">Go to Surplus Products</a><br>-->
    <a href="/index.jsp">Log Out</a>
</body>
</html>
