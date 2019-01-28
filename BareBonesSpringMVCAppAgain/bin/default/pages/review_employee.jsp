<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Basic MVC Home</title>

    <!-- <link rel="stylesheet"  type="text/css"
  href="${pageContext.request.contextPath}/style/common_style.css" > -->
    <%--<link rel="stylesheet" type="text/css" href='<spring:url value="/style/common_style.css" />' />--%>
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

    <div class="container">
        <div class="row">
            <h2>Please review the employee details</h2>

            <div class="form-group">
                <label>First Name</label> <span>${employee.firstName}</span>
            </div>

            <div class="form-group">
                <label>Last Name</label> <span>${employee.lastName}</span>
            </div>

            <div class="form-group">
                <label>Employee ID</label> <span>${employee.employeeId}</span>
            </div>
            <div class="form-group">
                <label>Employee Type</label> <span>${employee.employeeType}</span>
            </div>
            <div class="form-group">
                <label>Employee Roles</label>
                <c:forEach items="${employee.roles}" var="role" begin="0" varStatus="index">
                    <span>${role}</span> <c:if test="${not index.last}">,</c:if>
                </c:forEach>
            </div>
            <div class="form-group">
                <label>Hire Date</label> <span>${employee.hireDate}</span>
            </div>
            <div class="form-group">
                <label>Address Line1</label> <span>${employee.address.addressLine1}</span>
            </div>
            <div class="form-group">
                <label>Address Line2</label> <span>${employee.address.addressLine2}</span>
            </div>
            <div class="form-group">
                <label>City</label> <span>${employee.address.city}</span>
            </div>
            <div class="form-group">
                <label>State</label> <span>${employee.address.state}</span>
            </div>
            <div class="form-group">
                <label>Zip Code</label> <span>${employee.address.zip}</span>
            </div>

            <a href="<spring:url value="/employee/add"/>" class="btn btn-default">Edit</a>
            <a href="<spring:url value="/employee/save"/>"
               class="btn btn-default">Save</a>
        </div>
    </div>

</div>
</body>
</html>