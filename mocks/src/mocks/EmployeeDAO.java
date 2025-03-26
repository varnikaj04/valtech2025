package mocks;

import java.util.List;

public interface EmployeeDAO {
	
	public Employee get(int id);
	
	public List<Employee> getAll();

}
