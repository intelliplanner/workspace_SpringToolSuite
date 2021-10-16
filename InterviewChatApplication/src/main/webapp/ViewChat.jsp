<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<script>
	var myVar = setInterval(myTimer, 30000);

	function myTimer() {
		var d = new Date();
		document.getElementById("demo").innerHTML = d.toLocaleTimeString();
		window.location.reload(1);

	}
	function myFunction() {
		window.open("/InterviewChatApplication/add");
	}
</script>
<h1>${headerMsg}</h1>
<h3>Refresh Time</h3>
<p id="demo"></p>

<button onclick="myFunction()">Add New Chat</button>
<br>

<table border="2" width="70%" cellpadding="2">
	<tr>
		<th>Id</th>
		<th>Header</th>
		<th>Author</th>
		<th>Body</th>
		<th>Chat Time</th>
	</tr>
	<c:forEach var="chat" items="${list}">
		<tr>
			<td>${chat.id}</td>
			<td>${chat.header}</td>
			<td>${chat.author}</td>
			<td>${chat.body}</td>
			<td>${chat.updated_on}</td>
		</tr>
	</c:forEach>
</table>