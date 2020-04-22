<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Product</title>
</head>
<body>

<h3>Create Product</h3>
<p>
    <a href="/productList">Back to customer list</a>
</p>
<form method="POST" action="${pageContext.request.contextPath}/createProduct">
    <table border="0">
        <tr>
            <td>Product Name</td>
            <td><input type="text" name="name" value="${product.name}" /></td>
        </tr>
        <tr>
            <td>Category</td>
            <td><input type="text" name="category_name" value="${product.category_name}" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit" />
                <a href="productList">Cancel</a>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
