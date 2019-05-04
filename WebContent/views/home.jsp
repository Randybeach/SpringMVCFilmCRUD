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
<input type = "submit" value = "Search">
</form><br>
<form action = "modify.do" method = GET>
<input type = "submit" value = "Modify">
</form>
</body>
</html>