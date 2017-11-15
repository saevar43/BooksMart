<!-- @author Sævar Ingi Sigurðsson <sis108@hi.is> -->
<!-- .jsp skrá sem containing HTML for website with URL "../demo/spyrjaNotanda" (see DemoController) -->
<!DOCTYPE html>
<html lang="en">

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<title>Booksmart</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href="https://fonts.googleapis.com/css?family=Lato|Merriweather"
	rel="stylesheet">
<link rel="stylesheet" href="../../css/styles.css" />
</head>

<body>
	<div class="fp-background">
		<div id="header">
			<%@ include file="header.jsp"%>
		</div>
		<div id="content">
			<div class="main--frontpage">
			<div class="header--text">
				<img class="fp-logo" src="../../css/bm-logo-white.png" />
				<h1>BooksMart</h1>
			</div>
			<div>
				<form id="searchform-main" method="GET" action="/app/results"
					role="form" class="search-bar">
					<input class="input-field placeholder-white" name="title" type="text"
						placeholder="Search for books...">
					<div class="input-btn-wrapper">
						<button form="searchform-main" class="input-btn" type="submit">
							<img src="../../css/searchImgNew.png" width=19.2 height=19.2 />
						</button>
					</div>
				</form>
			</div>
			</div>
		</div>
		<div id="footer">
			<%@ include file="footer.jsp"%>
		</div>
	</div>
</body>

</html>












