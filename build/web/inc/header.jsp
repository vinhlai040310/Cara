<%-- 
    Document   : header
    Created on : Sep 25, 2024, 9:42:51 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<header id="header">
    <a href="home.jsp"><img src="./assets/img/logo.png" class="logo" alt=""></a>
    <ul id="navbar">
        <li><a class="active" href="HomeServlet">Home</a></li>
        <li>
            <a href="ShopServlet?page=1">Shop</a>
            <ul class="sub-menu">
                <c:forEach var="category" items="${categoryList}">
                    <li class="menu-item">
                        <a href="CategoryServlet?categoryId=${category.id}">${category.name}</a>
                    </li>
                </c:forEach>
            </ul>
        </li>
        <li><a href="blog.jsp">Blog</a></li>
        <li><a href="about.jsp">About</a></li>
        <li><a href="contact.jsp">Contact</a></li>
        <li><a href="cart.jsp"><i class="fa-solid fa-bag-shopping"></i></a></li>
        <li><a href="user.jsp"><i class="fa-solid fa-user"></i></a></li>
        <li>
            <c:if test="${sessionScope.user == null}">
            <a href="LoginServlet">Login</a> 
            </c:if>
            <c:if test="${sessionScope.user != null}">
            <a href="LogoutServlet">Logout</a>
            </c:if>
        </li>
    </ul>
</header>
