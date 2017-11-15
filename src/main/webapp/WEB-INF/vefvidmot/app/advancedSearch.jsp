<!-- @author Sævar Ingi Sigurðsson <sis108@hi.is> -->
<!-- .jsp skrá sem containing HTML for website with URL "../demo/spyrjaNotanda" (see DemoController) -->
<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<head>
<title>BooksMart</title>
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
	<div class="as-background">
	<div id="content">
		<div class="adv-search-wrapper">
		<div class="header--AdvSearch">
			<h1 class="adv-search-title">Advanced search</h1>
		</div>
		<div>
			<form id="searchform-main" method="GET" action="/app/test" role="form" class="search-bar">
				<input class="input-field placeholder-white" name="title" type="text" placeholder="Title..."> 
				<input class="input-field placeholder-white" name="edition" type="number" min=1 max=99 placeholder="Ed.">
				<input class="input-field placeholder-white" name="author" type="text" placeholder="Author..."> 
<!-- 				<input class="input-field" type="submit" value="Search"><br> -->
				
				<div class="input-btn-wrapper">
          					<button form="searchform-main" class="input-btn" type="submit">
          						<img src="../../css/searchImgNew.png" width=19.2 height=19.2/>
          					</button>
          				</div>
			
			</form>
		</div>
		</div>
	</div>
	</div>
	<div id="footer">
		<%@ include file = "footer.jsp" %>
	</div>
</body>

</html>