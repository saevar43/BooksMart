<!-- @author Sævar Ingi Sigurðsson <sis108@hi.is> -->
<!-- .jsp skrá sem containing HTML for website with URL "../demo/spyrjaNotanda" (see DemoController) -->
<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

	<head>
    		<title>Hver er bókin?</title>
	</head>
	<body>

		<h1>Leitaðu að bók</h1>

		<form method="GET" action="/app/results">
			Titill: <input name="title" type="text" placeholder="Titill"></input><br>
			Höfundur: <input name="author" type="text" placeholder="Höfundur"></input><br>
			Útgáfa: <input name="edition" type="text" placeholder="Útgáfa"></input><br>
			Fag: <input name="course" type="text" placeholder="Fag"></input><br>
			Námsbraut: <input name="department" type="text" placeholder="Námsbraut"></input><br>
			Skóli: <input name="school" type="text" placeholder="Skóli"></input><br>
			<input type="submit" value="Search">
		</form>
		<form method="GET" action="/app/all_books"><input type="submit" value="All books"/></form>

	</body>

</html>