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
    <title>Update Product</title>
</head>
<body>
<jsp:include page="topbar.jsp"/>
<h3>Update Product</h3>
<form name="productForm" action="../UpdateProductSubmitServlet" onsubmit="return validateForm()" method="POST">
    <input type="hidden" name="productID" value="<%=product.getProductID() %>">
    Name: <input type="text" value="<%=product.getProductName() %>" name="productName" required><br>
    Sale Price: <input type="number" step="0.01" value="<%=product.getSalePrice() %>" name="salePrice" required><br>
    Discount Price: <input type="number" step="0.01" value="<%=product.getDiscountPrice() %>" name="discountPrice"><br>
    Inventory Amount: <input type="number" value="<%=product.getInventoryAmount() %>" name="inventoryAmount" required><br>
    Discount Amount: <input type="number" value="<%=product.getDiscountAmount() %>" name="discountAmount"><br>
    Donation Amount: <input type="number" value="<%=product.getDonationAmount() %>" name="donationAmount"><br>
    Product Type:
    <select name="productType" required>
        <option value="bread" <%= "bread".equals(product.getProductType()) ? "selected" : "" %>>Bread</option>
        <option value="meat" <%= "meat".equals(product.getProductType()) ? "selected" : "" %>>Meat</option>
        <option value="fruit" <%= "fruit".equals(product.getProductType()) ? "selected" : "" %>>Fruit</option>
        <option value="vegi" <%= "vegi".equals(product.getProductType()) ? "selected" : "" %>>Vegi</option>
        <option value="dairy" <%= "dairy".equals(product.getProductType()) ? "selected" : "" %>>Dairy</option>
    </select><br>
    Surplus Flag: <input type="text" value="<%=product.getSurplusFlag() %>" name="surplusFlag"><br>
    Expiry Date: <input type="date" value="<%=product.getExpiryDate() %>" name="expiryDate" required><br>
    <input type="submit" value="Update Product">
</form>
<a href="../index.jsp">Log Out</a>
</body>
</html>
