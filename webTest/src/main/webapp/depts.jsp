<%@page import="java.util.List"
import = "dao.Employee"%>
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
	Counters = ${counters} Current Depts = ${current}
	<form action="depts" method="post">
		<table>
			<tr>
				<td>Id</td>
				<td>${dept.id}</td>
			</tr>
			<tr>	
				<td>Name</td>
				<td>${dept.name}</td>
			</tr>
			<tr>
				<td>Location</td>
				<td>${dept.location}</td>
			</tr>	
			<tr>
				<td colspan="7">
				<a href="depts?operation=Update&id=${dept.id}">Update</a>
				<a href="depts?operation=Delete&id=${dept.id}">Delete</a>
				</td>
				
				<td colspan="7"><a href="depts?operation=new">New Department</a></td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="submit" name="operation" value="First" /> 
				<input type="submit" name="operation" value="Previous" /> 
				<input type="submit" name="operation" value="Next" /> 
				<input type="submit" name="operation" value="Last" />
				</td>
			</tr>
		</table>
		
		<h1>Employees in ${dept.name}</h1>
		<table>
			<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Age</th>
			<th>Gender</th>
			<th>Salary</th>
			<th>Experience</th>
			<th>Level</th>
			<th>Dept ID</th>
			</tr>
			
			<% 
			List<Employee> emps = (List<Employee>)session.getAttribute("employees");
			for(Employee emp: emps){
			%>
				<tr>
				<td><%=emp.getId() %></td>
				<td><%=emp.getName() %></td>
				<td><%=emp.getAge() %></td>
				<td><%=emp.getGender() %></td>
				<td><%=emp.getSalary() %></td>
				<td><%=emp.getExp() %></td>
				<td><%=emp.getLevel() %></td>
				<td><%=emp.getDeptId() %></td>
				</tr>
				
			<%} %>
			
			
		</table>

	</form>
</body>
</html>