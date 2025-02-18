<%@page import="dao.Employee"%>
<%@page import="java.util.List"%>
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

<form action="employees" method="get">
	<label for="search">Search:</label>
	<input type="text" id="search" name="search" placeholder="Search for employees"/>
	
	<label for="searchBy">Search By:</label>
	<select id="searchBy" name="searchBy">
		<option value="name">Name</option>
		<option value="salary">Salary</option>
		<option value="greaterThanSal">Greater than Salary</option>
		<option value="lessThanSal">Less than Salary</option>
		<option value="age">Age</option>
		<option value="greaterThanAge">Greater than Age</option>
		<option value="lessThanAge">Less than Age</option>
		<option value="experience">Experience</option>
		<option value="greaterThanExp">Greater than Experience</option>
		<option value="lessThanExp">Less than Experience</option>
		<option value="level">Level</option>
		<option value="greaterThanLevel">Greater than Level</option>
		<option value="lessThanLevel">Less than Level</option>
	</select>
	
	<input type="submit" value="Search"/>
</form>


	<table>
		<tr>
			<th><a href= "employees?operation=sorting&sortorder=${sortorder == 'asc' ? 'desc' : 'asc'}&sortBy=id">Id </a></th>
			<th><a href= "employees?operation=sorting&sortorder=${sortorder == 'asc' ? 'desc' : 'asc'}&sortBy=name">Name</a></th>
			<th><a href= "employees?operation=sorting&sortorder=${sortorder == 'asc' ? 'desc' : 'asc'}&sortBy=age">Age</a></th>
			<th><a href= "employees?operation=sorting&sortorder=${sortorder == 'asc' ? 'desc' : 'asc'}&sortBy=gender">Gender</a></th>
			<th><a href= "employees?operation=sorting&sortorder=${sortorder == 'asc' ? 'desc' : 'asc'}&sortBy=salary">Salary</a></th>
			<th><a href= "employees?operation=sorting&sortorder=${sortorder == 'asc' ? 'desc' : 'asc'}&sortBy=experience">Experience</a></th>
			<th><a href= "employees?operation=sorting&sortorder=${sortorder == 'asc' ? 'desc' : 'asc'}&sortBy=level">Level</a></th>
			<th><a href= "employees?operation=sorting&sortorder=${sortorder == 'asc' ? 'desc' : 'asc'}&sortBy=deptId">Dept Id</a></th>
			<th>Actions</th>
		</tr>
		<c:forEach items="${emps}" var="e">
		<tr>
			<td><c:out value="${e.id}"></c:out></td>
			<td>${e.name}</td>
			<td>${e.age}</td>
			<td>${e.gender}</td>
			<td>${e.salary}</td>
			<td>${e.exp}</td>
			<td>${e.level}</td>
			<td>${e.deptId}</td>
			<td>
				<a href= "employees?operation=Update&id=${e.id}">Update</a>
				<a href= "employees?operation=Delete&id=${e.id}">Delete</a>
			</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="7">
				<a href="employees?operation=new">New Employee </a>
			</td>
		</tr>
	</table>

	<hr></hr>
	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Age</th>
			<th>Gender</th>
			<th>Salary</th>
			<th>Experience</th>
			<th>Level</th>
			<th>Dept Id</th>
		</tr>
		<%
		List<Employee> emps = (List<Employee>) request.getAttribute("emps");
		for (Employee e : emps) {
		%>
		<tr>
			<td><%=e.getId()%></td>
			<td><%=e.getName()%></td>
			<td><%=e.getAge()%></td>
			<td><%=e.getGender()%></td>
			<td><%=e.getSalary()%></td>
			<td><%=e.getExp()%></td>
			<td><%=e.getLevel()%></td>
			<td><%=e.getDeptId() %></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>