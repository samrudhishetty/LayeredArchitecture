<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Products List</h1>
    <table border="1">
        <tr>
            <th>Product ID</th>
            <th>Name</th>
            <th>Cost</th>
            <th>Quantity</th>
        </tr>
        <c:forEach var="product" items="${list}">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.cost}</td>
                <td>${product.quantity}</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>