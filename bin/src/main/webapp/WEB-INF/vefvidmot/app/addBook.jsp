<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Nýskrá bók</title>
	</head>
	<body>
		<h1>Nýskrá bók</h1>
		
		<form method="POST" action="/app/book_confirm">
			Titill: <input name="title" type="text" placeholder="Title" required/><br>
			Höfundur: <input name="author" type="text" placeholder="Author" required/><br>
			Útgáfa: <input name="edition" type="text" placeholder="Edition" required/><br>
			Fag: <input name="course" type="text" placeholder="Course" required/><br>
			Námsbraut: <input name="department" type="text" placeholder="Department" required/><br>
			Skóli: <input name="school" type="text" placeholder="School" required/><br>
			Email: <input name="email" type="text" placeholder="john@doe.is" required/><br>
			<input type="submit" value="Confirm"/>
		</form>
	
	</body>
</html>