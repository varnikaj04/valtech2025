package com.valtech.training.employee.controllers;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.valtech.training.employee.vos.EmployeeVO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class EmployeeControllerTest {

	@LocalServerPort
	private Integer port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void addEmployees() {
		List emps = restTemplate.getForObject("http://localhost:" + port + "/api/v1/employees/", List.class);
		if (emps.size() == 0) {
			System.out.println("Adding Employees ... to db ...");
			EmployeeVO manager = restTemplate.postForObject("http://localhost:" + port + "/api/v1/employees/",
					new EmployeeVO(0, "Abc", 75635476, "abc@gmail.com", 0), EmployeeVO.class);
			EmployeeVO manager1 = restTemplate.postForObject("http://localhost:" + port + "/api/v1/employees/",
					new EmployeeVO(0, "Def", 89765564, "def@gmail.com", manager.id()), EmployeeVO.class);
			EmployeeVO emp1 = restTemplate.postForObject("http://localhost:" + port + "/api/v1/employees/",
					new EmployeeVO(0, "Pqr", 33557545, "pqr@gmail.com", manager1.id()), EmployeeVO.class);
			EmployeeVO emp2 = restTemplate.postForObject("http://localhost:" + port + "/api/v1/employees/",
					new EmployeeVO(0, "Xyz", 36646545, "xyz@gmail.com", manager.id()), EmployeeVO.class);
			EmployeeVO emp3 = restTemplate.postForObject("http://localhost:" + port + "/api/v1/employees/",
					new EmployeeVO(0, "Lmn", 66717545, "lmn@gmail.com", manager1.id()), EmployeeVO.class);
		}
	}

}
