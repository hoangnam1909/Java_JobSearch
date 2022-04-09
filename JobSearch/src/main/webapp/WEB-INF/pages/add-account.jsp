<%--
  Created by IntelliJ IDEA.
  User: Lightning
  Date: 08/04/2022
  Time: 10:25 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center text-success">THÊM TÀI KHOẢN</h1>
<h3 class="text-center text-success">Kiểm tra: ${errMsg}</h3>

<c:url value="/admin/admin-account/add-account" var="action" />

<form:form action="${action}" method="post" modelAttribute="user">
    <div class="form-group">
        <label>Tên đăng nhập ${username}</label>
        <form:input path="username" class="form-control" />
    </div>
    <div class="form-group">
        <label>Mật khẩu ${password}</label>
        <form:input path="password" class="form-control" type="password" />
    </div>
    <div class="form-group">
        <label>Nhập lại mật khẩu ${confirmPassword}</label>
        <form:input path="confirmPassword" class="form-control" type="password" />
    </div>
    <div class="form-group">
        <label>Email ${email}</label>
        <form:input path="email" class="form-control" />
    </div>
    <div class="form-group">
        <label>Số điện thoại ${phone}</label>
        <form:input path="phone" class="form-control" />
    </div>
    <div class="form-group">
        <label>UserType ${userType}</label>
        <form:input path="userType" class="form-control" />
    </div>
    <div class="form-group">
        <button type="submit" class="btn btn-primary">Đăng nhập</button>
    </div>
</form:form>
