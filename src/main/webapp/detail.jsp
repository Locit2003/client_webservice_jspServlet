<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail City</title>
</head>
<body>
	<h1>DETAIL CITY</h1>

	<table border="1">
		<tr>
			<th>Book Id</th>
			<th>Book Name</th>
			<th>Image</th>
			<th>Price</th>
			<th>Price sale</th>
			<th>Description</th>
			<th>Author</th>
		</tr>
		<tr>
			<td>${b.id}</td>
			<td>${b.name}</td>
			<td>${b.image}</td>
			<td>${b.price}</td>
			<td>${b.sale_price}</td>
			<td>${b.description}</td>
			<td>${b.author}</td>
			<td><a href="PreUpdateBook?id=${b.id}">update</a></td>
			<td><a href="DeleteBook?id=${b.id}"
				onclick="return confirm('Sure?')">delete</a></td>
		</tr>
	</table>

</body>
</html>