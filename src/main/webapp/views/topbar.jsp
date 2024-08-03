<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String username = (String) session.getAttribute("username");%>
<% String home = (String) session.getAttribute("home");%>

<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none">
                <a href="$/home" class="navbar-brand">Food waste Reduction Platform</a>
            </h1>
            <ul class="navbar-list clearfix">
                <li>
                    <a class="on" href="<%=home%>">Home</a>
                </li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">

                <li>
                    <a href="UserInfoServlet"><%= username %></a>
                    <a href="LogoutServlet">Exit</a>
                </li>
            </ul>
        </div>
    </div>
</div>