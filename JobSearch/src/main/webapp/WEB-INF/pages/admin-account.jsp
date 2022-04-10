<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ul class="nav nav-tabs">
    <li class="nav-item">
        <a class="nav-link" href="<c:url value="/admin/admin-account/add-account"/>">Thêm</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="<c:url value="/admin/admin-account/edit-account"/>">Sửa</a>
    </li>
</ul>

<table class="table table-striped">
    <thead>
        <tr>
            <th>Firstname</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Role</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${users}" var="u">
            <tr>
                <td>${u.username}</td>
                <td>${u.phone}</td>
                <td>${u.email}</td>
                <td>${u.userType}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
