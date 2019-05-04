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
	<h1>
		<strong>Modify a Film</strong>
	</h1>
	Would you like to
	<br>
	<form action="selectMod.do" method=GET>
		<ul>
			<li>Change Film:<input type="radio" value="change" name="value">
				Film ID:<input type="text" name="filmId"></li>
			<li>Delete Film:<input type="radio" value="delete" name="value"></li>
			<li>Add Film:<input type="radio" value="add" name="value"></li>
		</ul>
		<br> <input type="submit">
	</form>
	<c:if test="${value == 'change' }">
		<h2>What fields would you like to change?</h2>
		<form action="changeFilm.do" method=POST>
			Title:<input type="text" name="title" value="${details.title }"><br>
			Description:<input type="text" name="description"
				value="${details.description }"><br> Release Year:<input
				type="text" name="release_year" value="${details.release_year }"><br>
			Rental Duration:<input type="text" name="rental_duration"
				value="${details.rental_duration }"><br> Rental Rate:<input
				type="text" name="rental_rate" value="${details.rental_rate }"><br>
			Length:<input type="text" name="length" value="${details.length }"><br>
			Replacement Cost:<input type="text" name="replacement_cost"
				value="${details.replacement_cost }"><br> Rating:<input
				type="text" name="rating" value="${details.rating }"><br>
			Special Features:<input type="text" name="special_features"
				value="${details.special_features }"><br> <input
				type="submit">
		</form>
	</c:if>
	<c:if test="${value == 'delete'}">
		<form action="deleteFilm.do" method=POST>
			<h3>What film would you like to remove</h3>
			Film Id:<input type="text" name="id"><br> <input
				type="submit">
		</form>
	</c:if>
	<c:if test="${value == 'add'}">
		<h2>Your new film</h2>
		<form action="changeFilm.do" method=POST>
			Title:<input type="text" name="title"><br> Description:<input
				type="text" name="description"><br> Release Year:<input
				type="text" name="release_year"><br> Rental Duration:<input
				type="text" name="rental_duration"><br> Rental Rate:<input
				type="text" name="rental_rate"><br> Length:<input
				type="text" name="length""><br> Replacement Cost:<input
				type="text" name="replacement_cost"><br> Rating:<input
				type="text" name="rating"><br> Special Features:<input
				type="text" name="special_features"><br> <input
				type="submit">
		</form>
	</c:if>
</body>
</html>