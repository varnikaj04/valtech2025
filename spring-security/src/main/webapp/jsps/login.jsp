<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="login" method="post">
		<table>
			<tr>
				<td>Username</td>
				<td><input name="username" type="text" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input name="password" type="password" /></td>
			</tr>
			<tr>
				<td colspan="2"><input name="login" type="submit" value="Login" />
				</td>
			</tr>
		</table>
	</form>

</body>
</html>