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

	<form action="customer" method="post">
		<table>
			<tr>
				<td><input name="cid" type="text" value="0" hidden="true" /></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input name="cname" type="text" /></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><input name="age" type="text" /></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input name="address" type="text" /></td>
			</tr>
			<tr>
				<td>Permanent Address</td>
				<td><input name="permaddress" type="text" /></td>
			</tr>
			<tr>
				<td>Status</td>
				<td><input name="cusStatus" type="text" /></td>
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
			<th>Age</th>
			<th>Address</th>
			<th>Permanent Address</th>
			<th>Customer Status</th>
		</tr>
		<c:forEach items="${customer }" var="c">
			<tr>
				<td>${c.cid}</td>
				<td>${c.cname}</td>
				<td>${c.age}</td>
				<td>${c.address}</td>
				<td>${c.permaddress}</td>
				<td>${c.cusStatus}</td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>