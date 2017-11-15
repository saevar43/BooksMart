<!DOCTYPE html>
<!-- @author Kári Geir Gunnarsson <kgg5@hi.is> -->

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html>
	<head>
		<title>User created</title>
	</head>
	<body>
		<h1>${user.getUsername()}</h1>
		<h2>${user.getEmail()}</h2>
		<h3>${user.getPw()}</h3>
	</body>
</html>