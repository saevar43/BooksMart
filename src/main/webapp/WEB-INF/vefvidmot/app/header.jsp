<!DOCTYPE html>
<html lang="en">

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="false"%>
<%@ page import="is.hi.booksmart.model.User"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
HttpSession session = request.getSession(false);
User loggedInUser = session != null ? (User) session.getAttribute("myUser") : null;
%>

<head>
<title>Booksmart</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href="https://fonts.googleapis.com/css?family=Lato|Merriweather"
	rel="stylesheet">
<link rel="stylesheet" href="../../css/styles.css"/>

<div id="header">
	<nav class="menu">
		<div class="menuleft">
			<a href="/app/">
			<img class="fp-logo-2" src="../../css/bm-logo-topleft.png"></a>
		</div>
		<div class="menuright">
			<% if (loggedInUser == null) { %>
			<a class="menubutton" href="./create_user">Register</a> <a
				class="menubutton" href="./login">Sign in</a>
			<% } else { %>
			<div class="dropdown">
				<button class="dropbtn">My Profile</button>
				<div class="dropdown-content">
					<a class="menubutton" href="./add_book">Sell a book</a> <a
						class="menubutton" href="./userInventory">My books</a>        
				</div>
			</div>
				<a class="menubutton" href="./logout">Sign out</a>
			<% } %>
		</div>
	</nav>
</div>