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
<h1>Welome to SDMDB</h1>
<h3>What would you like to do today?</h3>
<form action = "search.do" method = GET>
<input type = "text" name = "keyword"><input type = "submit" value = "Search Films">
</form><br>
<form action = "modify.do" method = GET>
<input type = "submit" value = "Modify a Film">
</form>
<c:if test="${not empty details }">
<ul>
<c:forEach var = "film" items="${details }">
<li><a href = "findFilm.do?filmId=${film.id}">${film.title }</a></li>
</c:forEach>
</ul>
</c:if>
</body>
</html>