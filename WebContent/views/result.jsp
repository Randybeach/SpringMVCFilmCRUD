<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1><strong>${details.title }</strong></h1>
<ul>
<li><strong>ID:</strong>${details.id }</li>
<li><strong>Description:</strong>${details.description }</li>
<li><strong>Release Year:</strong>${details.release_year }</li>
<li><strong>Rental Duration:</strong>${details.rental_duration }</li>
<li><strong>Rental Rate:</strong>${details.rental_rate }</li>
<li><strong>Length:</strong>${details.length }</li>
<li><strong>Replacement Cost:</strong>${details.replacement_cost }</li>
<li><strong>Rating:</strong>${details.rating }</li>
<li><strong>Special Features:</strong>${details.special_features }</li>
<li><strong>Cast:</strong><ol>
<c:forEach var="actor" items = "${details.actors }">
<li>${actor }</li>

</c:forEach>
</ol></li>
</ul>
<%-- <a href = "selectMod.do?value=change&filmId=${details.id}">Change</a> --%>
<form action="selectMod.do?value=change&filmId=${details.id}" method="GET">
<input type="submit" value="Change">
</form>
<br><br>
<%-- <a href = "deleteFilm.do?filmId=${details.id}">Delete</a> --%>
<form action="deleteFilm.do?filmId=${details.id}" method="POST">
<input type="submit" value="Delete">
</form>
<br><br>
<!-- <a href = "home.do">Home</a> -->
<form action="home.do" method="GET">
<input type="submit" value="Home">
</form>
</body>
</html>