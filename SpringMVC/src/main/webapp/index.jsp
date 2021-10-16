<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
 <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet"/>
<script src="${pageContext.request.contextPath}/resources/js/sample.js"></script> 
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<a href="/SpringMVC/student/">Add Student</a>	<a href="/SpringMVC/student/show"> Show Students</a>
<a href="/SpringMVC/employee/">Employee</a> <a href="/SpringMVC/employee/show"> Show Employees</a>
<a href="student/">Employee</a> <a href="employee/show"> Show Employees</a>
<a href="/SpringMVC/uploadSingleFile.jsp">Upload File</a>
<a href="/SpringMVC/uploadMultipleFiles">Upload multiple File</a><a href="/SpringMVC/uploadMultipleFiles">Upload multiple File</a>

<a href="/SpringMVC/webchat/view">Web Chat</a>
</body>
</html>