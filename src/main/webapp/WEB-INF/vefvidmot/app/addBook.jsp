<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BooksMart</title>
</head>
<body>
	<div id="header">
		<%@ include file="header.jsp"%>
	</div>

	<div class="ab-background">
	<div id="content">
		<div class="addBook-wrapper">	
		<div class="addBook">	
			<div class="addBook-screen">
				<div class="app-title">
					<h1 class="addBook-font">Fill form</h1>
					</div>
						<div>
						
						<div class="addBook-form">
							<form class="addBook-control-group" method="POST" action="/app/book_confirm">
								  <input class="input-addBook" type="text" class="login-field" name="title" maxlength="100" placeholder="Title" required id="login-name">
								  <input class="input-addBook" type="text" name="author" maxlength="100" placeholder="Author" required id=login-name>
								  <input class="input-addBook" type="number" name="edition" min=1 max=99 maxlength="100" placeholder="Edition" required id=login-name>
								  <input class="input-addBook" type="text" name="course" maxlength="100" placeholder="Course" required id=login-name>
								  <input class="input-addBook" type="text" name="department" maxlength="100" placeholder="Department" required id=login-name>
								  <input class="input-addBook" type="text" name="school" maxlength="100" placeholder="School" required id=login-name>
								  <input class="input-addBook" type="submit" value="Confirm">
						   </form>
						</div>
						</div>
			</div>
		</div>
		</div>
	</div>
	</div>
	<div id="footer">
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>