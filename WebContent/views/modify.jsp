<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modify Films</title>
</head>
<body>
<h1><strong>Modify a Film</strong></h1>
Would you like to<br>
<form action = "selectMod.do" method = GET>
<ul>
<li><input type = "radio" value = "change" name = "value"><input type = "text" name = "filmId" >Change Film</li>
<li><input type = "radio" value = "delete" name = "value">Delete Film</li>
<li><input type = "radio" value = "add" name = "value">Add Film</li>
</ul><br>
<input type = "submit">
</form>
<c:if test="${value == 'change' }">
<form action = "changeFilm.do" method = POST>

Title:<input type = "text" name = "title" value = "Academy of Dinos asdfasdfklajshdflkjahshalksjdhfkad" ><br>
<input type = "text" name = ""><br>
<input type = "text" name = ""><br>
<input type = "text" name = ""><br>
<input type = "text" name = ""><br>
<input type = "text" name = ""><br>
<input type = "text" name = ""><br>
</form>
</c:if>
<c:if test="${value == 'delete'}">
delete worked
</c:if>
<c:if test="${value == 'add'}">
</c:if>
</body>
</html>