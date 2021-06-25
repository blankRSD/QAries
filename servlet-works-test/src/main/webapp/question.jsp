<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="sap"%>
<!DOCTYPE html>
<html>

<body>

<% 	%>
	
	<h2>Hello ${sessionScope.name}</h2>
	<form action="home-page" method="post">
	<button>Show Questions</button>
	</form>
	
	
</body>
</html>