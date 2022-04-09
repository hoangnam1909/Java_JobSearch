<%-- 
    Document   : admin-account
    Created on : Apr 6, 2022, 10:37:29 PM
    Author     : Lightning
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ul class="nav nav-tabs">
    <li class="nav-item">
        <a class="nav-link" href="<c:url value="/admin/admin-account/add-account"/>">Thêm</a>
    </li>
</ul>

<table class="table table-striped">
    <thead>
        <tr>
            <th>Firstname</th>
            <th>Lastname</th>
            <th>Email</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${users}" var="u">
            <tr>
                <td>${u.username}</td>
                <td>${u.password}</td>
                <td>${u.email}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
