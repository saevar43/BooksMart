<!-- @author Kári Geir Gunnarsson <kgg5@hi.is> -->
<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Your books</title>
</head>
<body>
	<div id="header">
		<%@ include file="header.jsp"%>
	</div>
	
	<div class="ip-background">
	<div class="inventory-wrapper">
	<div class="results-sidebar">
			<form id="searchform-side" class="side-search-bar" method="GET" action="/app/searchMyBooks" role="form">
				<input class="side-input-field placeholder-white" name="title" type="text" placeholder="Search your books..."/>
			<div class="side-input-btn-wrapper">
				<button form="searchform-side" class="side-input-btn" type="submit">
					<img src="../../css/searchImg.png" width=19.2 height=19.2/>
				</button>
			</div> 
			</form>
			<img class="fp-logo-3" src="../../css/bm-logo-white.png" />
		</div>
		
			
	<div class="results">
		<c:choose>
			<c:when test="${not empty userBooks}">
				<table class="results-table">
					<thead>
						<tr class="results-table-head">
							<th>Title</th>
							<th>Ed.</th>
 							<th>Author</th>
 							<th>Course</th>
 							<th>Department</th>
 							<th>School</th>
 							<th>Book sold?</th>
						</tr>
					</thead>
					<c:forEach var="book" items="${userBooks}">
						<tr class="results-table-row">
							<td>${book.getTitle()}</td>
							<td>${book.getEdition()}</td>
							<td>${book.getAuthor()}</td>
							<td>${book.getCourse().getName()}</td>
							<td>${book.getCourse().getDepartment().getName()}</td>
							<td>${book.getCourse().getDepartment().getSchool().getName()}</td>
							<td>
 								<form class="table-delete" method=GET action="/app/deletion" >
 									<input name="username" type="hidden" value="${user}"/>
 									<input name="book_id" type="hidden" value="${book.getId()}" readonly/>
 									<input type="submit" value="Delete book"/>
 								</form>
 							</td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<h3 class="no-results-msg">No books found.</h3>
			</c:otherwise>
		</c:choose> 
		</div>
	</div>
	</div>
	<div id="footer">
		<%@ include file="footer.jsp"%>
	</div>
</body>

</html>