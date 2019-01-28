<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Basic MVC Home</title>

    <!-- <link rel="stylesheet"  type="text/css"
  href="${pageContext.request.contextPath}/style/common_style.css" > -->
    <link rel="stylesheet" type="text/css" href='<spring:url value="/style/common_style.css" />' />
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%@include file="/pages/common/header.jsp" %>
<div class="container">

    <h2>Find an employee</h2>
    <a href="<spring:url value="/employee/find/${requestScope.theEmployee.employeeId}" />" >Find an employee</a>

</div>
</body>
</html>