
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="sidebar-wrap">
    <div class="sidebar-title">
        <h1>Menu</h1>
    </div>
    <div class="sidebar-content">
        <ul class="sidebar-list">
            <li>
                <a href="#"><i class="icon-font">&#xe003;</i>Reduction Platform</a>
                <ul class="sub-menu">
                    <c:if test="${sessionScope.role  == 'Retailers'}">
                        <li>
                            <a href="${pageContext.request.contextPath}/inventory"><i class="icon-font">&#xe005;</i>Inventory</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/surplus"><i class="icon-font">&#xe005;</i>Food Surplus</a>
                        </li>
                    </c:if>

                    <c:if test="${sessionScope.role  == 'Charitable Organizations'}">
                        <li>
                            <a href="${pageContext.request.contextPath}/receive"><i class="icon-font">&#xe005;</i>Receive Food</a>
                        </li>
                    </c:if>

                    <c:if test="${sessionScope.role == 'Consumers'}">
                        <li>
                            <a href="${pageContext.request.contextPath}/purchase"><i class="icon-font">&#xe005;</i>Purchase</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/subscription"><i class="icon-font">&#xe006;</i>Subscription</a>
                        </li>
                    </c:if>

                </ul>
            </li>
            <li>
                <a href="#"><i class="icon-font">&#xe018;</i>System</a>
                <ul class="sub-menu">
                    <li>
                        <a href="${pageContext.request.contextPath}/AdminServlet"><i class="icon-font">&#xe017;</i>UserInfo</a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</div>
