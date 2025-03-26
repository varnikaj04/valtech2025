<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="order" method="post">

		<table>
			<tr>
				<td>Customer Id</td>
				<td><input name="cid" type="text" /></td>
			</tr>
			<tr>
				<td>Item Id</td>
				<td><input name="id" type="text" /></td>
			</tr>
			<tr>
				<td>Quantity</td>
				<td><input name="quantity" type="text" /></td>
			</tr>
			<tr>
				<td colspan="2"><input name="action" value="Add" type="submit" />
					<input name="action" value="Cancel" type="submit" /></td>
			</tr>

		</table>

	</form>

</body>
</html>