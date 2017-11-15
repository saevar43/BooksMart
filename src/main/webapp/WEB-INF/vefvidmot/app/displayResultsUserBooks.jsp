<!-- @author Sævar Ingi Sigurðsson <sis108@hi.is> -->
<!-- .jsp skrá containing HTML for a website with URL "../demo/hver" (see DemoController) -->
<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BooksMart</title>
</head>
<body>
	<div id="header">
		<%@ include file="header.jsp"%>
	</div>
	<div class="sp-background">
	<div class="results-wrapper">
		
		<div class="results-sidebar">
			<form id="searchform-side" class="side-search-bar" method="GET" action="/app/results" role="form">
				<input class="side-input-field placeholder-white" name="title" type="text" placeholder="Search for books..."/>
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
				<c:when test="${not empty books}">
<!-- 				<div class="scrollit"></div> -->
					<table class="results-table">
						<thead>
							<tr class="results-table-head">
								<th>Title</th>
								<th>Author</th>
								<th>Ed.</th>
								<th>Course</th>
								<th>Dept.</th>
								<th>School</th>
								<th>Contact info.</th>
							</tr>
						</thead>
						<c:forEach var="book" items="${books}">
							<tr class="results-table-row">
								<td>${book.getTitle()}</td>
								<td>${book.getAuthor()}</td>
								<td>${book.getEdition()}</td>
								<td>${book.getCourse().getName()}</td>
								<td>${book.getCourse().getDepartment().getName()}</td>
								<td>${book.getCourse().getDepartment().getSchool().getName()}</td>
								<td>
									<div class="email-wrapper">
										<input id="${book.getId()}" class="contact-email" type="text" value="${book.getUserContact()}" readonly />
										<div class="btn-wrapper">
											<button class="btn-copy-email" onclick="copyEmail(${book.getId()})">
												<img src="../../css/copy.png" width=13.6 height=13.6/>
											</button>
										</div>
									</div>
								</td>
							</tr>
						</c:forEach>
					</table>
				</c:when>
				<c:otherwise>
					<h2 class="no-results-msg">No books found.</h2>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	</div>
	
	<script>
			function copyEmail(id) {
  				var copyText = document.getElementById(id);
  				copyText.select();
  				document.execCommand("Copy");
  				alert("Copied the text: " + copyText.value);
			}
		</script>
	<div id="footer">
		<%@ include file="footer.jsp"%>
	</div>
</body>

</html>