<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<h1>${headerMsg}</h1> 

<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>First Name</th><th>Last Name</th><th>Address</th><th>pHONE</th><th>Address</th><th>Address</th><th>Address</th><th>Address</th><th>HireDate</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="emp" items="${list}">   
   <tr>  
   <td>${emp.id}</td>  
   <td>${emp.firstName}</td>  
   <td>${emp.lastName}</td>  
   <td>${emp.address}</td>
   <td>${emp.phoneNo}</td>  
    <td>${emp.jobId}</td> 
   <td>${emp.salary}</td> 
   <td>${emp.managerId}</td> 
   <td>${emp.departmentId}</td>
   <td>${emp.hireDate}</td>
   
   <td><a href="getEmployee/${emp.id}">Edit</a></td>  
   <td><a href="deleteEmployee/${emp.id}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="/SpringMVC">Home</a><a href="/SpringMVC/employee/">Add New Employee</a>  