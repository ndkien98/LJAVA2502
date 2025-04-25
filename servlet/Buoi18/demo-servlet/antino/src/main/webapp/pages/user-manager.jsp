<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee List</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
<div class="container my-4">

    <h1 class="text-center mb-4">Manager Employee</h1>

    <!-- Bảng danh sách nhân viên -->
    <table class="table table-bordered table-hover mt-4">
        <thead class="table-dark">
        <tr>
            <th>Employee ID</th>
            <th>Username</th>
            <th>Fullname</th>
            <th>age</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${userModels}">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.fullName}</td>
                <td>${user.age}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
