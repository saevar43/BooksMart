<!DOCTYPE html>
<!-- @Kári Geir Gunnarsson <kgg5@hi.is> -->

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html lang="en">

<head>
<title>Access forbidden (403)</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href="https://fonts.googleapis.com/css?family=Lato|Merriweather"
	rel="stylesheet">
<link rel="stylesheet" href="../../css/stylesFrontpage.css" />
</head>

<body>
	<div id="header">
		<%@ include file="header.jsp"%>
	</div>
	<div class="forbidden-background">
		
		<div class="layout--forbidden">
			<div class="dialog--forbidden">
				<h1 class="h1--forbidden">You need to be logged in to view this
					content.</h1>
			</div>
		</div>
		
	</div>
	<div id="footer">
		<%@ include file="footer.jsp"%>
	</div>

</body>
</html>