<!-- @author Sævar Ingi Sigurðsson <sis108@hi.is> -->
<!-- .jsp skrá containing HTML for a website with URL "../demo/hver" (see DemoController) -->
<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>

<html lang="en">

	<head>
   	 	<title>Leitarniðurstöður</title>
	</head>
	<body>
		<c:choose>
			<c:when test="${not empty books}">
				<table class="books">
					<thead>
						<tr>
							<th>Title</th>
							<th>Author</th>
							<th>Ed.</th>
							<th>Course</th>
							<th>Dept.</th>
							<th>School</th>
							<th>Contact info.</th>
						</tr>
					</thead>
					<c:forEach var = "book" items="${books}">
						<tr>
							<td>${book.getTitle()}</td>
							<td>${book.getAuthor()}</td>
							<td>${book.getEdition()}</td>
							<td>${book.getCourse().getName()}</td>
							<td>${book.getCourse().getDepartment().getName()}</td>
							<td>${book.getCourse().getDepartment().getSchool().getName()}</td>
							<td>${book.getUserContact()}</td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<h3>No books found.</h3>	
			</c:otherwise>
		</c:choose>
	</body>

</html>