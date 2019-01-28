<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Basic MVC Home</title>

    <!-- <link rel="stylesheet"  type="text/css"
  href="${pageContext.request.contextPath}/style/common_style.css" > -->
    <link rel="stylesheet" type="text/css" href='<spring:url value="/style/common_style.css" />'/>
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

    <h2>Add an employee</h2>
    <c:if test="${param.successMessage ne null}">
        <span class="success-message">
            The employee <c:out value="${theEmployee.firstName}"/>&nbsp;
            <c:out value="${theEmployee.lastName}"/> was added successfully.
        </span>
    </c:if>
    <spring:url value="/employee/review" var="employeeFormUrl"/>
    <form:form action="${pageScope.employeeFormUrl}" modelAttribute="employee" method="post">
        <div class="form-group">
            <label for="first-name">First Name</label>
            <form:input type="text" cssClass="form-control" id="first-name" path="firstName"/>
        </div>
        <div class="form-group">
            <label for="last-name">Last Name</label>
            <form:input type="text" cssClass="form-control" id="last-name" path="lastName"/>
        </div>
        <div class="form-group">
            <label for="employee-id">Employee Id</label>
            <form:input type="text" cssClass="form-control" id="employee-id" path="employeeId"/>
            <form:errors cssClass="error-message" path="employeeId"/>
        </div>
        <div class="form-group">
            <label for="employee-type" class="radio">Employee type</label>
            <form:radiobuttons id="employee-type" path="employeeType" items="${employeeTypes}"/>
        </div>
        <div class="form-group">
            <label for="employee-id" class="check-box">Employee Roles</label>
            <form:checkboxes id="employee-id" path="roles" items="${employeeRoles}"/>
        </div>
        <div class="form-group">
            <label for="hire-date">Hire Date</label>
            <form:input type="text" cssClass="form-control" id="hire-date" path="hireDate"
                        placeHolder="mm-dd-yyyy format"/>
        </div>
        <div class="form-group">
            <label for="address-line1">Address Line 1</label>
            <form:input type="text" cssClass="form-control" id="address-line1" path="address.addressLine1"/>
        </div>
        <div class="form-group">
            <label for="address-line2">Address Line 2</label>
            <form:input type="text" cssClass="form-control" id="address-line2" path="address.addressLine2"/>
        </div>
        <div class="form-group">
            <label for="city">City</label>
            <form:input type="text" cssClass="form-control" id="city" path="address.city"/>
        </div>
        <div class="form-group">
            <label for="state">State</label>
            <form:input type="text" cssClass="form-control" id="state" path="address.state"/>
        </div>
        <div class="form-group">
            <label for="zipCode">Zip Code</label>
            <form:input type="text" cssClass="form-control" id="zipCode" path="address.zip"/>
        </div>
        <button type="submit" class="btn btn-default">Add Employee</button>
    </form:form>

    <spring:url value="/fileUpload/upload" var="fileUploadUrl"/>
    <form:form action="${fileUploadUrl}" enctype="multipart/form-data">
        <div class="form-group">
            <label for="fileUpload">Upload a file here</label>
            <input type="file" name="file" id="fileUpload"/>
        </div>
        <button type="submit" class="btn btn-default">Upload file</button>
    </form:form>

</div>
</body>
</html>