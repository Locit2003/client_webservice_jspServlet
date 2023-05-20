<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert City</title>
</head>
<body>
	<h1>INSERT CITY</h1>
	<h3 style="color:red">${err }</h3>
	
	<form action="InsertCity" method="post">
		<table>
			<tr>
				<td>Book Name:</td>
				<td><input type="text" name="name"/></td>
			</tr>
			<tr>
				<td>Category:</td>
				<td><input type="text" name="category_id"/></td>
			</tr>
			
			<tr>
				<td>Image</td>
				<td><input type="text" name="image"/></td>
			</tr>
			<tr>
				<td>price:</td>
				<td><input type="text" name="price"/></td>
			</tr>
			<tr>
				<td>price sale:</td>
				<td><input type="text" name="sale_price"/></td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><input type="text" name="description"/></td>
			</tr>
			<tr>
				<td>Author:</td>
				<td><input type="text" name="author"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="insert"/>
				<input type="reset" value="clear"/></td>
			</tr>
		</table>
	</form>
</body>
</html>