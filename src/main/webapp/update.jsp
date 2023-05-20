<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update City</title>
</head>
<body>
	<h1>UPDATE CITY</h1>
	<h3 style="color: red">${err }</h3>

	<form action="UpdateCity" method="post">
		<table>
			<tr>
				<td>Book Id:</td>
				<td><input type="text" name="id" value="${b.id}"
					readonly="readonly" /></td>
			</tr>
			<tr>
				<td>Book Name:</td>
				<td><input type="text" name="name" value="${b.name}"/></td>
			</tr>
			<tr>
				<td>Category:</td>
				<td><input type="text" name="category_id" value="${b.category_id}"/></td>
			</tr>
			
			<tr>
				<td>Image</td>
				<td><input type="text" name="image" value="${b.image}"/></td>
			</tr>
			<tr>
				<td>price:</td>
				<td><input type="text" name="price" value="${b.price}"/></td>
			</tr>
			<tr>
				<td>price sale:</td>
				<td><input type="text" name="sale_price" value="${b.sale_price}"/></td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><input type="text" name="description" value="${b.description}"/></td>
			</tr>
			<tr>
				<td>Author:</td>
				<td><input type="text" name="author" value="${b.author}"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="insert" /> <input type="reset"
					value="clear" /></td>
			</tr>
		</table>
	</form>
</body>
</html>