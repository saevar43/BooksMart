<!-- @author S�var Ingi Sigur�sson <sis108@hi.is> -->
<!-- .jsp skr� sem containing HTML for website with URL "../demo/spyrjaNotanda" (see DemoController) -->
<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

	<head>
    		<title>Hver er b�kin?</title>
	</head>
	<body>

		<h1>Leita�u a� b�k</h1>

		<form method="GET" action="/app/results">
			Titill: <input name="title" type="text" placeholder="Titill"></input><br>
			H�fundur: <input name="author" type="text" placeholder="H�fundur"></input><br>
			�tg�fa: <input name="edition" type="text" placeholder="�tg�fa"></input><br>
			Fag: <input name="course" type="text" placeholder="Fag"></input><br>
			N�msbraut: <input name="department" type="text" placeholder="N�msbraut"></input><br>
			Sk�li: <input name="school" type="text" placeholder="Sk�li"></input><br>
			<input type="submit" value="Search">
		</form>
		<form method="GET" action="/app/all_books"><input type="submit" value="All books"/></form>

	</body>

</html>