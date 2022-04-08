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

<h1 class="text-center text-success">THÊM TÀI KHOẢN ${username} ${password} ${confirmPassword}</h1>
<h3 class="text-center text-success">Kiểm tra: ${errMsg}</h3>

<c:url value="/admin/admin-account/add-account" var="action" />

<form:form action="${action}" method="post" modelAttribute="user">
    <div class="form-group">
        <label>Tên đăng nhập</label>
        <form:input path="username" class="form-control" />
    </div>
    <div class="form-group">
        <label>Mật khẩu</label>
        <form:input path="password" class="form-control" />
    </div>
    <div class="form-group">
        <label>Nhập lại mật khẩu</label>
        <form:input path="confirmPassword" class="form-control" />
    </div>
    <button type="submit" class="btn btn-primary">Đăng nhập</button>
</form:form>


