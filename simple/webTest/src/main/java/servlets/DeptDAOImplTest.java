package servlets;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DeptDAOImplTest {
	
	@Test
	void testInsert() {
		DeptDAO dao = new DeptDAOImpl();
//		dao.save(new Dept(3,"ACC","AMD"));
//		Dept d = new Dept(3, "ACC", "BLR");
//		dao.update(d);
//		d = dao.getDept(3);
//		assertTrue(dao.getAll().size() > 1);
//		dao.previous(2);
		dao.delete(5);
		
	}
	

}
