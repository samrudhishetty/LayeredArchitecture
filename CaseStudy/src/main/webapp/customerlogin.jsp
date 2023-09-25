<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Login</title>
</head>
<body>
    <h2>Customer Login</h2>
    <form action="login" method="post">
        <label for="customerId">Customer ID:</label>
        <input type="text" id="customerId" name="id" required><br><br>
        
        <label for="customerName">Customer Name:</label>
        <input type="text" id="customerName" name="name" required><br><br>
        
        <input type="hidden" name="role" value="customer">
        <input type="submit" value="Login">
    </form>
</body>
</html>
