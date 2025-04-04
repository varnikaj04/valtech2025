package assignment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import assignment.Employee.Gender;

class EmployeeTest {
	
	EmployeeService es = new EmployeeService();
	

	@Test
	void enterData() {
		
		List<Employee> employees = new ArrayList<>();

		employees.add(Employee.builder().id(1).name("Varnika").age(23).salary(30000).level(1).exp(2)
				.gender(Gender.FEMALE).build());
		employees.add(Employee.builder().id(2).name("Vinamra").age(25).salary(40000).level(2).exp(4).gender(Gender.MALE)
				.build());
		employees.add(Employee.builder().id(3).name("Sakshi").age(22).salary(20000).level(1).exp(1)
				.gender(Gender.FEMALE).build());
		employees.add(Employee.builder().id(4).name("Yash").age(26).salary(30000).level(3).exp(2).gender(Gender.MALE)
				.build());
		employees.add(Employee.builder().id(5).name("Hemant").age(20).salary(10000).level(1).exp(1).gender(Gender.MALE)
				.build());
		employees.add(Employee.builder().id(6).name("Mradul").age(24).salary(50000).level(4).exp(3).gender(Gender.OTHER)
				.build());
		employees.add(Employee.builder().id(7).name("Arya").age(20).salary(20000).level(1).exp(1).gender(Gender.MALE)
				.build());
		employees.add(Employee.builder().id(8).name("Megha").age(21).salary(20000).level(2).exp(2).gender(Gender.FEMALE)
				.build());
		employees.add(Employee.builder().id(9).name("Rushabh").age(26).salary(50000).level(3).exp(3).gender(Gender.MALE)
				.build());
		employees.add(Employee.builder().id(10).name("Khatri").age(25).salary(50000).level(4).exp(4).gender(Gender.MALE)
				.build());

		Collections.sort(employees);

		for (Employee e : employees) {
			System.out.println(e);
		}

		
		
		assertEquals(320000, es.getTotalSalaryByLevel(employees, 1));
		
		assertEquals(70000, es.getTotalSalaryByGender(employees, Gender.FEMALE));

		assertEquals(60000, es.getTotalSalaryByNameContains(employees, "t"));

		assertEquals(20000, es.getTotalSalaryByLevelAndGender(employees, 2, Gender.FEMALE));

		
		Map<Gender, List<Employee>> groupEmployeeByGender = employees.stream().collect(Collectors.groupingBy(Employee::getGender));
		groupEmployeeByGender.forEach((gender, empList) -> {
			System.out.println("Gender: " + gender);
			empList.forEach(e -> System.out
					.println(e.getId() + e.getName() + e.getAge() + e.getSalary() + e.getLevel() + e.getExp()));
		});
	}
	
	
	 @Test
	void testHashCode() {
		Employee emp1 = new Employee(20, "Abhi", 24, 30000, 5, 3, Employee.Gender.MALE);
		int hash = emp1.hashCode();
		System.out.println(emp1);
		Employee emp2 = new Employee(22, "Abhi", 24, 30000, 5, 3, Employee.Gender.MALE);
		System.out.println(emp2);
		assertNotEquals(hash, emp2.hashCode());
	}
	 @Test
		void testEquals() {
			Employee e1 = new Employee(15,"Raj",19,20000,1,1,Gender.MALE);
			Employee e2 = new Employee(15,"Raj",19,20000,1,1,Gender.MALE);
			Employee e3 = new Employee(21,"Raj",19,20000,1,1,Gender.MALE);
			
			assertFalse(e1.equals(e3));
			assertTrue(e1.equals(e2));
		}


}
