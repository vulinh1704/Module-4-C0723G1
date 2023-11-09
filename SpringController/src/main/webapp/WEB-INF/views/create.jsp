<%--
  Created by IntelliJ IDEA.
  User: Linh
  Date: 11/9/2023
  Time: 9:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/customer/showDataForm" method="post">
    <input type="number" name="id" placeholder="id">
    <input type="text" name="name" placeholder="name">
    <button>Submit</button>
</form>
</body>
</html>
