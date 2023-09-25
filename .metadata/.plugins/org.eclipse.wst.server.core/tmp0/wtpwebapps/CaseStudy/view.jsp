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

<h1>Customers List</h1>
    <table border="1">
        <tr>
            <th>CustomerID</th>
            <th>Name</th>
            <th>Wallet Balance</th>
           
        </tr>
        <c:forEach var="customer" items="${list}">
            <tr>
                <td>${customer.customerId}</td>
                <td>${customer.customerName}</td>
                <td>${customer.walletBalance}</td>
                
            </tr>
        </c:forEach>
    </table>

</body>
</html>