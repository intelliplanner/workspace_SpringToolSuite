<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Person Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>${headerMsg}</h1> 

<form:form method="post" action="/SpringMVC/employee/save" modelAttribute="employee" >
<form:errors path="*" />
		<table>
			<tr>
				<td></td>
				<td><form:hidden path="id" /></td>
			</tr>
			<tr>
				<td>First Name:</td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td>Phone :</td>
				<td><form:input path="phoneNo" /></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>Address :</td>
				<td><form:input path="address" /></td>
			</tr>
			<tr>
				<td>Salary :</td>
				<td><form:input path="salary" /></td>
			</tr>
			<tr>
				<td>Job Id :</td>
				<td><form:input path="jobId" /></td>
			</tr>
		
			<tr>
				<td>Manager Id :</td>
				<td><form:input path="departmentId" /></td>
			</tr>
			<tr>
				<td>Hire Date :</td>
				<td><form:input path="hireDate" /></td>
			</tr>
			<tr>
				<td>Department Id :</td>
				<td><form:input path="managerId" /></td>
			</tr>
			
			
			<tr>
				<td></td>
				<td><input type="submit" value="Save" /></td>
			</tr>
		</table>
	</form:form>
<a href="/SpringMVC">Home</a>	<a href="show">Show Employees</a>
</body>
</html>