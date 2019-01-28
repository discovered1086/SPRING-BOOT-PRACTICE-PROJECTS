<%-- 
    Document   : header
    Created on : Apr 26, 2015, 11:35:15 PM
    Author     : Kingshuk
--%>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="<spring:url value="/"/>">Spring MVC Test</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="<spring:url value="/"/>">Home</a></li>
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">Manage Employees
                    <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="#">View Employees</a></li>
                    <li><a href="<spring:url value="/employee/add" />">Add Employee</a></li>
                    <li><a href="<spring:url value="/employee/getEmployees" />">Find Employee</a></li>
                </ul>
            </li>
        </ul>
    </div>
</nav>

