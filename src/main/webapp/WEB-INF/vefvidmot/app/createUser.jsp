<!-- @author Sævar Ingi Sigurðsson <sis108@hi.is> -->
<!-- @author Kári Geir Gunnarsson <kgg5@hi.is> -->
<!-- .jsp skrá sem containing HTML for website with URL "../demo/spyrjaNotanda" (see DemoController) -->
<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<head>
<title>Booksmart</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href="https://fonts.googleapis.com/css?family=Lato|Merriweather" rel="stylesheet">
<link rel="stylesheet" href="../../css/styles.css" />
</head>
<body>
	<div id="header">
		 <%@ include file = "header.jsp" %>
	</div>
	
	<div class="register-background">
	<div id="content">
		<main class="login-wrapper">
		<div class="login">
			<div class="login-screen">
				<div class="app-title">
					<h1 class="signin-register-font">Register</h1>
				</div>
					<div>
					
					<div class="login-form">
						<form class="control-group" method="POST" action="/app/user_confirm">
							<input class="input-login" name="username" type="text" class="login-field" value="" placeholder="username" required id="login-name">
							<label class="login-field-icon fui-user" for="login-name"></label>
							<c:if test="${not empty error}">
							<div class="error-msg">${error}</div>
							</c:if>
							<c:if test="${not empty message}">
							<div class="error-msg">${message}</div>
										</c:if>
							<input class="input-login" name="email" class="login-field" type="email" placeholder="john@doe.is" required id=login-name>			
							<input class="input-login" name="pw" class="login-field" type="password" placeholder="password" required id="login-pass">
							<label class="login-field-btn" for="login-pass">
						
							<input class="input-login" type="submit" value="Confirm" /> </label><input type="hidden"/>
						</form>
					</div>
					</div>
			</div>
			</div>
		</div>
	</div>
	</div>
	<div id="footer">
		<%@ include file = "footer.jsp" %>
	</div>
</body>

</html>

							