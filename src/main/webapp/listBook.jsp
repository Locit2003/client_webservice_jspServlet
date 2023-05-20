<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Load City</title>
</head>
<body>
	<h1>LIST Book</h1>
	<h3 style="color:green">${success}</h3>
	<h3 style="color:red">${err}</h3>
	
	<form action="SearchBook" method="get">
		<b>Book Name: </b>
		<input type="text" name="name"/>
		<input type="submit" value="Search"/>
	</form><br/>
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
		<c:forEach items="${list}" var="b">
			<tr>
				<td>${b.id}</td>
				<td>${b.name}</td>
				<td>${b.image}</td>
				<td>${b.price}</td>
				<td>${b.sale_price}</td>
				<td>${b.description}</td>
				<td>${b.author}</td>
				<td>
					<a href="DetailBook?id=${b.id}">detail</a>
				</td>
				<td>
					<a href="DeleteBook?id=${b.id}" onclick="return confirm('Sure?')">delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<a href="PreInsertBook">Add New Book</a>
</body>
</html>