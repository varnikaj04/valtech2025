<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="depts" method="post">
		<table>
			<tr>
				<td>Id</td>
				<td><input type="text" name="id" ${readonly} value="${depts.id}"/></td>

			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" value="${depts.name}" /></td>
			</tr>
			<tr>
				<td>Location</td>
				<td><input type="text" name="location" value="${depts.location}" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" name="operation" value='${mode}' /> 
					<input type="submit" name="operation" value="Cancel" />
				</td>
			</tr>

		</table>
	</form>



</body>
</html>