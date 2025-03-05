package dao;

import org.junit.jupiter.api.Test;

class EmployeeDAOImplTest {

	@Test
	void test() {
		EmployeeDAO dao = new EmployeeDAOImpl();
		
//		System.out.println(dao.getEmployeeByDeptId(2));
		
//		dao.sortEmpById("asc");
//		System.out.println(dao.sortEmpByExperience("desc"));
		
//		System.out.println(dao.getAll());
		
		System.out.println(dao.getEmpByAge("age", 22));
//		System.out.println(dao.getEmpByExperience("lessThanExperience", 4));
//		System.out.println(dao.getEmpByName("varni"));
//		System.out.println(dao.getEmpByLevel("lessThanLevel", 4));
		System.out.println(dao.getEmpBySalary("lessThanSalary", 20000));
	}

}
