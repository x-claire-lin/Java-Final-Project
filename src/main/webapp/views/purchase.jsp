<%--https://stackoverflow.com/questions/4928271/how-to-install-jstl-it-fails-with-the-absolute-uri-cannot-be-resolved-or-una --%>

<%@page import="model.DiscountView"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.User"%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@page import="businesslayer.AuthorsBusinessLogic"%>
<%@page import="java.util.List" %>
<%@page import="model.Author" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<% AuthorsBusinessLogic authorService = new AuthorsBusinessLogic();
    List<Author> authors = authorService.getAllAuthors(); %>
--%>

<html>
<jsp:include page="header.jsp">
    <jsp:param name="pageTitle" value="Retailer Inventory Management" />
</jsp:include>
    <head>
        <title>Author List</title>
    </head>
    <body>
    <jsp:include page="topbar.jsp"/>
        <h2>Purchase List</h2>
       
        <div class="crumb-wrap">
            <div class="crumb-list">
                <i class="icon-font"></i>
                <a href="${pageContext.request.contextPath}/home">Home</a>
                <span class="crumb-step">&gt;</span>
                <span class="crumb-name">Purchase Management</span>
            </div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="${pageContext.request.contextPath}/purchase" method="post">
                    <table class="search-tab">
                        <tr>
                            <th width="100">Food Name:</th>
                            <td>
                                <input class="common-text" placeholder="Food Name" name="name" id="name" type="text">
                            </td>
                            <td>
                                <button class="btn btn-primary btn2"  name="inquire" id="inquire" value="Query" type="submit">Query</button>
                            </td>
                            <td>
                                <button class="btn btn-primary btn2" type="button" onclick="window.location='${pageContext.request.contextPath}/purchase?method=list'">Manager</button>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form name="myform" id="myform" method="post">               
                <div class="result-content">         
                    <table class="result-tab" width="100%">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>UserName</th>
                                <th>discount</th>

                            </tr>
                        </thead>
                        <tbody>
                            <% List<User> users = (List<User>) request.getAttribute("users");
                            ArrayList<DiscountView> discount = (ArrayList<DiscountView>) request.getAttribute("dis");
                            for (DiscountView user : discount) {%>
                            <tr>
                                <td><%= user.getUserID()%></td>
                                <td><%= user.getProductName()%></td>
                                <td><%= user.getDiscountAmount()%></td>
                                <c:if test="${user.getUserID() == null}">
                                    <td>
                                        <a class="link-update" href="javascript:;" onclick="doBuy(${user.getUserId()}, ${user.getDiscountAmount()})">Buy</a>
                                    </td>
                                </c:if>
                            </tr>
                            <% }%>
                        </tbody>
                    </table>
                </div>
            </form>
        </div>
            <script>
        function doBuy(id, inventoryQuantity){
            let buyQuantity = prompt("Please enter the quantity to purchase.");
            if (buyQuantity !== null) {
                buyQuantity = parseFloat(buyQuantity);
                if (isNaN(buyQuantity) || buyQuantity <= 0 || buyQuantity > inventoryQuantity) {
                    alert("Please enter a valid quantity!");
                    return;
                }
                window.location = "${pageContext.request.contextPath}/purchase?method=purchase&id=" + id + "&quantity=" + buyQuantity;
            }
        }
    </script>
            
        

    </body>
</html>