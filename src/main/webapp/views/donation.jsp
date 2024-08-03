
<%-- 
    Document   : donations
    Created on : Apr 5, 2024, 8:18:56 a.m.
    Author     : Dunxing Yu
--%>
<%@page import="java.util.ArrayList" %>
<%@page import="model.DonationView" %>
<%@page import="businesslayer.ProductsBusinessLogic" %>
<% ProductsBusinessLogic d = new ProductsBusinessLogic();
ArrayList<DonationView> donations = (ArrayList<DonationView>) request.getAttribute("donations");%>
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
        <h2>Donation food List</h2>
         <div><a href="index.jsp">Back</a></div>

        <table border="1">
            <thead>
                <tr>
                    <th>Company ID</th>
                    <th>Donation Company</th>
                    <th>Product ID</th>
                    <th>Product Name</th>
                    <th>Donation Amount</th>
                    <th>Accept Amount</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                
                <%for (DonationView donation : donations) {%>
                <tr>
                    <td><%= donation.getUserID()%></td>
                    <td><%= donation.getDonationCompany() %></td>
                    <td><%= donation.getProductID()%></td>
                    <td><%= donation.getProductName() %></td>
                    <td><%= donation.getDonationAmount() %></td>
                    <td><input type="number" id="quantity_<%= donation.getProductID() %>" min="0"  step="0.001"></td>
                    <td><button onclick="submitForm('<%= donation.getProductID() %>', '<%= donation.getDonationAmount() %>')">Accept</button></td>
                </tr>
                <% }%>
            </tbody>
        </table>

        <!-- Hidden form  for pass data to Servlet -->
    <form id="redirectForm" action="<%= request.getContextPath() %>/DonationViewUpdate" method="post">
        <input type="hidden" name="id" id="idInput">
        <input type="hidden" name="amount" id="amountinput">
    </form>

    <script>
        function submitForm(id, amount) {
             //alert(id + amount);         
            var quantity = parseFloat(amount)-parseFloat(document.getElementById("quantity_"+id).value);
            if  (quantity >= 0){
                alert("You accept:"+parseFloat(document.getElementById("quantity_"+id).value) + " item.");
                //set form data
                document.getElementById("idInput").value = id;
                document.getElementById("amountinput").value = quantity;
                //submit form
                document.getElementById("redirectForm").submit();
            }
            else{
                alert("The accept amount can not exceed the donation amount or be less than 0.");
                return;
            }
        }
    </script>   
     
    </body>
</html>