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

    <link rel="stylesheet" type="text/css" href='<spring:url value="/style/modal_prompt.css" />'/>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <script
            src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
            crossorigin="anonymous"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <script type="text/javascript" language="JavaScript">
        $(document).ready(function () {
            $(".table-striped").find("tr").click(function (event) {

                if ($("#data").hasClass("display-none")) {
                    var employeeId = $(event.target).parent("tr").attr("id");

                    console.log(employeeId);

                    console.log($(event.target));

                    $.getJSON("/BareBonesSpringMVCApp/employee/find/" + employeeId)
                        .done(function (data) {
                            console.log(data);

                            $("#data").removeClass("display-none");


                            $("#data").find("#1").html(data.firstName);
                            $("#data").find("#2").html(data.lastName);
                            $("#data").find("#3").html(data.employeeId);
                            $("#data").find("#4").html(data.employeeType);
                        })
                } else {
                    $("#data").addClass("display-none");
                }

            });
        });
    </script>
</head>
<body>
<%--<%@include file="common/modal_prompt.jsp" %>--%>
<%@include file="/pages/common/header.jsp" %>
<div class="container">

    <h2>View All Employees</h2>
    <table class="table table-striped">
        <thead>
        <tr>
            <td>Employee Id</td>
            <td>First Name</td>
            <td>Last Name</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${allEmployees}" var="employee">
            <tr id="${employee.employeeId}">
                <td><c:out value="${employee.employeeId}"/></td>
                <td><c:out value="${employee.firstName}"/></td>
                <td><c:out value="${employee.lastName}"/></td>

                <table class="table-no-border display-none" id="data">
                    <tr>
                        <th>First Name</th>
                        <td id="1"></td>
                        <th>Last Name</th>
                        <td id="2"></td>
                    </tr>
                    <tr>
                        <th>Employee Id</th>
                        <td id="3"></td>
                        <th>Employee Type</th>
                        <td id="4"></td>
                    </tr>
                </table>

            </tr>
        </c:forEach>
        </tbody>

    </table>

</div>
</body>
</html>