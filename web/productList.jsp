<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product List</title>
</head>
<body>

<h3>Product List</h3>

<table border="1" cellpadding="5" cellspacing="1" >
    <tr>
        <td>Id</td>
        <th>Name</th>
        <th>Category</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items='${requestScope["productList"]}' var="product">
        <tr>
            <td>${product.getId()}</td>
            <td>${product.getName()}</td>
            <td>${product.getCategory_name()}</td>
            <td>
                <a href="editProduct?id=${product.getId()}">Edit</a>
            </td>
            <td>
                <a href="deleteProduct?id=${product.getId()}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="createProduct" >Create Product</a>

</body>
</html>
