<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>SDMDB</title>
</head>
<body>
	<div class="tm-nav-section">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<nav class="navbar navbar-expand-md navbar-light">
						<button class="navbar-toggler" type="button"
							data-toggle="collapse" data-target="#tmMainNav"
							aria-controls="tmMainNav" aria-expanded="false"
							aria-label="Toggle navigation">
							<span class="navbar-toggler-icon"></span>
						</button>

						<div class="collapse navbar-collapse" id="tmMainNav">
							<ul class="navbar-nav mx-auto tm-navbar-nav">
								<li class="nav-item active">
									<form action="home.do" method="GET">
										<input type="submit" value="Home">
									</form>
								</li>
								<form action="modify.do" method="GET">
									<input type="submit" value="Modify">
								</form>
								</li>
								<li class="nav-item">
									<form action="rick.do" method="GET" target="_blank">
										<input type="submit" value="Rick">
									</form>
								</li>
								<li class="nav-item">
									<form action="home.do" method="GET">
										<input type="submit" value="Home">
									</form>
								</li>
							</ul>
						</div>
					</nav>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-4 offset-4">
			<h1>Welcome to SDMDB</h1>
		</div>
	</div>
	<div class="container">

		<h3>What would you like to do today?</h3>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-6">
				<form action="findFilm.do" method=GET>
					<strong>Search films by ID:</strong><input type="text" name="id">
					<input type="submit" value="Search Films">
				</form>
			</div>
			<div class="col-6">
				<form action="search.do" method=GET>
					<strong>Search films by keyword:</strong><input type="text"
						name="keyword"> <input type="submit" value="Search Films">
				</form>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-6">

				<form action="modify.do" method=GET>
					<strong>Change an existing film:</strong><input type="submit"
						value="Modify a Film">
				</form>
			</div>
		</div>
		<div class="container">
			<c:choose>
				<c:when test="${details.size() gt 0 }">
					<ul>
						<c:forEach var="film" items="${details }">
							<li><a href="findFilm.do?id=${film.id}">${film.title }</a></li>
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
		</div>
	</div>
	<div>
	
	</div>
</body>
</html>
<style>
body{
background-color: rgba(255, 255, 255, 0.7) !important;
background-image:url(https://thumbs.dreamstime.com/t/old-grunge-film-strip-background-32023216.jpg);
}

</style>