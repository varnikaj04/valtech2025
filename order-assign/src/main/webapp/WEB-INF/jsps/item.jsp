<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="item" method="post">
		<table>
			<tr>
				<td><input name="id" type="text" value="0" hidden="true" /></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input name="name" type="text" /></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><input name="description" type="text" /></td>
			</tr>
			<tr>
				<td>Current Quantity</td>
				<td><input name="currentQuan" type="text" /></td>
			</tr>
			<tr>
				<td>Reorder Quantity</td>
				<td><input name="reorderQuan" type="text" /></td>
			</tr>
			<tr>
				<td>Max Quantity</td>
				<td><input name="maxQuan" type="text" /></td>
			</tr>
			<tr>
				<td colspan="2"><input name="action" value="Add" type="submit" />
					<input name="action" value="Cancel" type="submit" /></td>
			</tr>
		</table>
	</form>
	
	<table>

		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Description</th>
			<th>Current Quantity</th>
			<th>Reorder Quantity</th>
			<th>Max Quantity</th>
		</tr>
		<c:forEach items="${item }" var="i">
			<tr>
				<td>${i.id}</td>
				<td>${i.name}</td>
				<td>${i.description}</td>
				<td>${i.currentQuan}</td>
				<td>${i.reorderQuan}</td>
				<td>${i.maxQuan}</td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>