  
<%@page import="java.util.Base64"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ page session="false"%>
<jsp:include page="/index.jsp" />

<h1>${headerMsg}</h1>   
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>First Name</th><th>Last Name</th><th>Address</th><th>pHONE</th><th>Address</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="student" items="${list}">   
   <tr>  
   <td>${student.id}</td>  
   <td>${student.firstName}</td>  
   <td>${student.lastName}</td>  
   <td>${student.address}</td>
   <td>${student.email}</td>
   <td>${student.phoneNo}</td>
   <td>  <img src="${pageContext.request.contextPath}/resources/images/${student.image1_name}" width="300" height="200"/></td> 
     <%-- <img src="myImage/getStudentPhoto/${student.id}" width="200" height="100"/> --%>
   <td><a href="getStudent/${student.id}">Edit</a></td>  
   <td><a href="deleteStudent/${student.id}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
  <!-- <a href="/SpringMVC">Home</a> <a href="/SpringMVC/student/">Add New Student</a>   -->