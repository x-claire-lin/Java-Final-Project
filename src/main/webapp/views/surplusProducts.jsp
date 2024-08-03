<%-- 
    Document   : SurplusProducts
    Created on : Apr. 8, 2024, 6:24:11 p.m.
    Author     : cuini
--%>
<%@page import="java.util.List"%>
<%@page import="model.Products"%>
<%@page import="dataaccesslayer.SurplusProductIdentifier"%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Surplus Products</title>
    <style>
        .red-background {
            background-color: red;
        }
    </style>
</head>
<body>
    <h2>Surplus Products</h2>
    
    <button onclick="sendNotification()">Send Notification</button>


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
            </tr>
        </thead>
        <tbody>
            <% 
            SurplusProductIdentifier surplusProductIdentifier = new SurplusProductIdentifier();
            List<Products> surplusProducts = surplusProductIdentifier.filterIdentifySurplusProducts();
            
            if (surplusProducts != null && !surplusProducts.isEmpty()) {
                for (Products product : surplusProducts) {
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
                <td class="time-cell"><%= product.getExpiryDate() %></td>
            </tr>
            <% 
                }
            } else {
            %>
            <tr>
                <td colspan="10">No surplus products found.</td>
            </tr>
              
            <% } %>
        </tbody>
    </table>

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
        const daysToAdd = 7; 

        document.querySelectorAll('.time-cell').forEach(cell => {
            const cellDate = new Date(cell.textContent);
            const futureDate = addDays(today, daysToAdd);

            if (cellDate <= futureDate) {
                cell.classList.add('red-background');
            }
        });
         function sendNotification() {
            // Your code to send notification goes here
            alert("Notification sent successfully!");
        }
    </script>
</body>
</html>
