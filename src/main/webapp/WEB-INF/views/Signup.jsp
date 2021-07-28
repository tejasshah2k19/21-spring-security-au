<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Signup</h2>
	<form method="post" action="saveuser">
	<input name="_csrf" type="hidden" value="${cookie['XSRF-TOKEN'].value}" />
	
		Username: <input type="text" name="username" /><br> Password: <input
			type="password" name="password" /><br> <input type="submit"
			value="Signup" />

	</form>
</body>
</html>