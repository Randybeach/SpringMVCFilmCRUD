<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SDMDB</title>
</head>
<body>
<h1>Welcome to SDMDB</h1>
<h3>What would you like to do today?</h3>
<form action = "findFilm.do" method = GET>
<strong>Search films by ID:</strong><input type = "text" name = "id"><input type = "submit" value = "Search Films">
</form><br>
<form action = "search.do" method = GET>
<strong>Search films by keyword:</strong><input type = "text" name = "keyword"><input type = "submit" value = "Search Films">
</form><br>
<form action = "modify.do" method = GET>
<strong>Change an existing film:</strong><input type = "submit" value = "Modify a Film">
</form>
<c:choose>
<c:when test="${details.size() gt 0 }">
<ul>
<c:forEach var = "film" items="${details }">
<li><a href = "findFilm.do?id=${film.id}">${film.title }</a></li>
</c:forEach>
</ul>
</c:when>
<c:when test="${not empty deleted }">
Deleted
<ul>
<li>${deleted.title }</li>
</ul>
</c:when>
</c:choose>
</body>
</html>