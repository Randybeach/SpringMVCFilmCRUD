<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modify Films</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel='stylesheet' href='Style.css'>
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
			<li>Add Film:<input type="radio" value="add" name="value"
				checked="checked"></li>
		</ul>
		<br>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
		<br>
	<c:if test="${empty value }">
	<form action="home.do" method="GET">
		<button type="submit" value="Home" class="btn btn-primary">Home</button>
		<!-- <input type="submit" value="Home"> -->
	</form>
	</c:if>
	<c:if test="${value == 'change' }">
		<h2>What fields would you like to change?</h2>
		<form:form action="changeFilm.do" method="POST" modelAttribute="film">
			ID:<form:input path="id" value="${details.id }" readonly="true" />
			<br>
			Title:<form:input path="title" value="${details.title }" />
			<br>
			Description:<form:input path="description"
				value="${details.description }" />
			<br> 
			Release Year:<form:input path="release_year"
				value="${details.release_year }" />
			<form:errors path="release_year" />
			<br>
			Rental Duration:<form:input path="rental_duration"
				value="${details.rental_duration }" />
			<br> 
			Rental Rate:<form:input path="rental_rate"
				value="${details.rental_rate }" />
			<br>
			Length:<form:input path="length" value="${details.length }" />
			<br>
			Replacement Cost:<form:input path="replacement_cost"
				value="${details.replacement_cost }" />
			<br>
			Language:   <form:select path="language_id">
				<option value="1">English</option>
				<option value="2">Italian</option>
				<option value="3">Japanese</option>
				<option value="4">Mandarin</option>
				<option value="5">French</option>
				<option value="6">German</option>
			</form:select>
			<br>
			Rating:     <form:select path="rating">
				<option value="G">G</option>
				<option value="PG">PG</option>
				<option value="PG13">PG-13</option>
				<option value="R">R</option>
				<option value="NC17">NC-17</option>
			</form:select>
			<br>
			Categories:  <form:select path="categoryId">
				<option value="1">Action</option>
				<option value="2">Animation</option>
				<option value="3">Children</option>
				<option value="4">Classics</option>
				<option value="5">Comedy</option>
				<option value="6">Documentary</option>
				<option value="7">Drama</option>
				<option value="8">Family</option>
				<option value="9">Foreign</option>
				<option value="10">Games</option>
				<option value="11">Horror</option>
				<option value="12">Music</option>
				<option value="13">New</option>
				<option value="14">Sci-Fi</option>
				<option value="15">Sports</option>
				<option value="16">Travel</option>
			</form:select>
			<br>
			Special Features:<br>
			<form:checkbox path="special_features" value="Trailers" />Trailers<br>
			<form:checkbox path="special_features" value="Commentaries" />Commentary<br>
			<form:checkbox path="special_features" value="Behind the Scenes" />Behind the Scenes<br>
			<form:checkbox path="special_features" value="Deleted Scenes" />Deleted Scenes<br>
			<button type="submit" class="btn btn-primary">Submit</button>
			<!-- <input type="submit"> -->

		</form:form>
		<br>
	</c:if>
	<c:if test="${value == 'delete'}">
		<form action="deleteFilm.do" method="POST">
			<h3>What film would you like to remove</h3>
			Film Id:<input type="text" name="filmId"><br>
			<button type="submit" class="btn btn-danger">Delete</button>
			<!-- <input type="submit"> -->
		</form>
		<br>
	</c:if>
	<c:if test="${value == 'add'}">
		<h2>Your new film</h2>
		<form:form action="addFilm.do" method="POST" modelAttribute="film">
			Title:<form:input path="title" />
			<br>
			Description:<form:input path="description" />
			<br> 
			Release Year:<form:input path="release_year" />
			<form:errors path="release_year" />
			<br> 
			Rental Duration:<form:input path="rental_duration" />
			<br> 
			Rental Rate:<form:input path="rental_rate" />
			<br> 
			Length:<form:input path="length" />
			<br> 
			Replacement Cost:<form:input path="replacement_cost" />
			<br> 
			Language:<form:select path="language_id">
				<option value="1">English</option>
				<option value="2">Italian</option>
				<option value="3">Japanese</option>
				<option value="4">Mandarin</option>
				<option value="5">French</option>
				<option value="6">German</option>
			</form:select>
			<br>
			Rating:<form:select path="rating">
				<option value="G">G</option>
				<option value="PG">PG</option>
				<option value="PG13">PG-13</option>
				<option value="R">R</option>
				<option value="NC17">NC-17</option>
			</form:select>
			<br>
			Categories:  <form:select path="categoryId">
				<option value="1">Action</option>
				<option value="2">Animation</option>
				<option value="3">Children</option>
				<option value="4">Classics</option>
				<option value="5">Comedy</option>
				<option value="6">Documentary</option>
				<option value="7">Drama</option>
				<option value="8">Family</option>
				<option value="9">Foreign</option>
				<option value="10">Games</option>
				<option value="11">Horror</option>
				<option value="12">Music</option>
				<option value="13">New</option>
				<option value="14">Sci-Fi</option>
				<option value="15">Sports</option>
				<option value="16">Travel</option>
			</form:select>
			<br>
			Special Features:<br>
			<form:checkbox path="special_features" value="Trailers" />Trailers<br>
			<form:checkbox path="special_features" value="Commentaries" />Commentary<br>
			<form:checkbox path="special_features" value="Behind the Scenes" />Behind the Scenes<br>
			<form:checkbox path="special_features" value="Deleted Scenes" />Deleted Scenes<br>
			<button type="submit" class="btn btn-primary">Submit</button>
			<!-- <input type="submit"> -->
			<form:checkbox path="special_features" value="none" style="opacity:0"
				checked="checked" />
			<br>
		</form:form>
		<br>
	</c:if>
		<c:if test="${not empty value }">
	<form action="home.do" method="GET">
		<button type="submit" value="Home" class="btn btn-primary">Home</button>
		<!-- <input type="submit" value="Home"> -->
	</form>
	</c:if>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>

</body>
</html>