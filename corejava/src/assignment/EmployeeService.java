package assignment;

import java.util.List;
import java.util.stream.Collectors;

import assignment.Employee.Gender;

public class EmployeeService {

	public double getTotalSalaryByLevel(List<Employee> emp, int level) {
		List<Employee> emps = emp.stream().filter(employee -> employee.getLevel() == level)
				.collect(Collectors.toList());
		double getTotalSalaryByLevel = emp.stream().mapToDouble(Employee::getSalary).sum();
		return getTotalSalaryByLevel;
	}

	public double getTotalSalaryByGender(List<Employee> emp, Gender gender) {
		List<Employee> emp1 = emp.stream().filter(employee -> employee.getGender() == gender)
				.collect(Collectors.toList());
		double getTotalSalaryByGender = emp1.stream().mapToDouble(Employee::getSalary).sum();
		return getTotalSalaryByGender;
	}

	public double getTotalSalaryByNameContains(List<Employee> emp, String name) {
		List<Employee> emp2 = emp.stream().filter(employee -> employee.getName().toLowerCase().contains(name))
				.collect(Collectors.toList());
		double getTotalSalaryByNameContains = emp2.stream().mapToDouble(Employee::getSalary).sum();
		return getTotalSalaryByNameContains;
	}

	public double getTotalSalaryByLevelAndGender(List<Employee> emp, int level, Gender gender) {
		List<Employee> emp3 = emp.stream()
				.filter(employee -> employee.getLevel() == 2 && employee.getGender() == gender)
				.collect(Collectors.toList());
		double getTotalSalaryByLevelAndGender = emp3.stream().mapToDouble(Employee::getSalary).sum();
		return getTotalSalaryByLevelAndGender;
	}

}
