<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html>
	<head>
		<title>Book added</title>
	</head>
	<body>
		<h1>${book.getTitle()} added to database.</h1>
		<h2>${book.getAuthor()}</h2>
		<h3>${book.getEdition()}</h3>
		<h3>${book.getCourse().getName()}</h3>
		<h3>${book.getCourse().getDepartment().getName()}</h3>
		<h3>${book.getCourse().getDepartment().getSchool().getName()}</h3>

	</body>
</html>