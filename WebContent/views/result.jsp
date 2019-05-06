<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${details.title }</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel='stylesheet' href='Style.css'>
</head>
<body class ="resultsBody">
<h1 class="text-center"><strong>${details.title }</strong></h1>
<ul class="border border-light">
<li class="border border-light"><strong>ID:</strong>${details.id }</li>
<li class="border border-light"><strong>Description:</strong>${details.description }</li>
<li class="border border-light"><strong>Release Year:</strong>${details.release_year }</li>
<li class="border border-light"><strong>Rental Duration:</strong>${details.rental_duration }</li>
<li class="border border-light"><strong>Rental Rate:</strong>${details.rental_rate }</li>
<li class="border border-light"><strong>Length:</strong>${details.length }</li>
<li class="border border-light"><strong>Replacement Cost:</strong>${details.replacement_cost }</li>
<li class="border border-light"><strong>Rating:</strong>${details.rating }</li>
<li class="border border-light"><strong>Special Features:</strong>${details.special_features }</li>
<li class="border border-light"><strong>Category:</strong>${details.category }</li>
<li class="border-bottom"><strong>Cast:</strong><ol>
<c:forEach var="actor" items = "${details.actors }">
<li>${actor }</li>

</c:forEach>
</ol></li>
</ul>
<%-- <a href = "selectMod.do?value=change&filmId=${details.id}">Change</a> --%>
<form action="selectMod.do" method="GET">
<input type="hidden" name="value" value="change">
<input type="hidden" name="filmId" value="${details.id }">
<button type="submit" value="Change" class="btn btn-warning">Change</button>
<!-- <input type="submit"value="Change" > -->
</form>
<br>
<%-- <a href = "deleteFilm.do?filmId=${details.id}">Delete</a> --%>
<!-- <a href = "home.do">Home</a> -->
<form action="home.do" method="GET">
<button type="submit" value="Home" class="btn btn-primary">Home</button>
<!-- <input type="submit" value="Home"> -->
</form>
<br>
<form action="deleteFilm.do?filmId=${details.id}" method="POST">
<button type="submit" value="Delete" class="btn btn-danger">Delete</button>
<!-- <input type="submit" value="Delete" > -->
</form>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>