<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="saveuser" method="post">
		<sec:csrfInput />

		Email <input type="text" name="email" />
		Password <input type="text" name="password" /> <input type="submit"
			value="Save" />
	</form>
	<br><br>${cookie["XSRF-TOKEN"].value } 
</body>
</html>