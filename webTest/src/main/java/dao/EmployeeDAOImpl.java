package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import dao.Employee.Gender;
import jakarta.servlet.ServletContext;

public class EmployeeDAOImpl implements EmployeeDAO {

//	static {
//		try {
//			Class.forName("org.postgresql.Driver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//
//	}
	
	ServletContext sc;

	public EmployeeDAOImpl() {}

	public EmployeeDAOImpl(ServletContext sc) {
		this.sc = sc;
		
	}

	private Connection getConnection(ServletContext sc) throws SQLException {
		String url = (String)sc.getAttribute("url");
		String username = (String)sc.getAttribute("username");
		String password = (String)sc.getAttribute("password");
		return DriverManager.getConnection(url,username,password);
//		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/training", "postgres", "postgres");
	}

	@Override
	public void save(Employee e) {
		try (Connection conn = getConnection(this.sc)) {
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO EMPLOYEE (NAME, AGE, GENDER,SALARY, EXPERIENCE,LEVEL,DEPTID,ID) VALUES (?,?,?,?,?,?,?,?)");
			setValuesToPrepareStatement(e, ps);
			int rowsAffected = ps.executeUpdate();
			System.out.println("Rows inserted = " + rowsAffected);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	private void setValuesToPrepareStatement(Employee e, PreparedStatement ps) throws SQLException {
		ps.setString(1, e.getName());
		ps.setInt(2, e.getAge());
		ps.setString(3, e.getGender().name());
		ps.setFloat(4, e.getSalary());
		ps.setInt(5, e.getExp());
		ps.setInt(6, e.getLevel());
		ps.setInt(7, e.getDeptId());
		ps.setInt(8, (int) e.getId());
	}

	@Override
	public void update(Employee e) {
		try (Connection conn = getConnection(this.sc)) {
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE EMPLOYEE SET NAME = ?, AGE = ? , GENDER = ?,SALARY = ?, EXPERIENCE = ?,LEVEL = ?, DEPTID = ? WHERE ID = ?");
			setValuesToPrepareStatement(e, ps);
			int rowsAffected = ps.executeUpdate();
			System.out.println("Rows Updated = " + rowsAffected);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public void delete(int id) {
		try (Connection conn = getConnection(this.sc)) {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM EMPLOYEE WHERE ID = ?");
			ps.setInt(1, id);
			int rowsAffected = ps.executeUpdate();
			System.out.println("Rows deleted = " + rowsAffected);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public Employee get(int id) {
		try (Connection conn = getConnection(this.sc)) {
			PreparedStatement ps = conn.prepareStatement(
					"SELECT ID, NAME, AGE, SALARY, GENDER, LEVEL, EXPERIENCE, DEPTID FROM EMPLOYEE WHERE ID = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				// if returns true we have another row, false then we r at end of results
				Employee e = populateEmployee(rs);
				return e;
			} else {
				new RuntimeException("No employee with Id " + id + " found.");
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		return null;
	}

	private Employee populateEmployee(ResultSet rs) throws SQLException {
		return Employee.builder().id(rs.getInt(1)).name(rs.getString(2)).age(rs.getInt(3)).salary(rs.getFloat(4))
				.gender(Gender.valueOf(rs.getString(5))).level(rs.getInt(6)).exp(rs.getInt(7)).deptId(rs.getInt(8))
				.build();
	}

	@Override
	public List<Employee> getAll() {
		List<Employee> emps = new ArrayList<Employee>();
		try (Connection conn = getConnection(this.sc)) {
			PreparedStatement ps = conn
					.prepareStatement("SELECT ID, NAME, AGE, SALARY, GENDER, LEVEL, EXPERIENCE, DEPTID FROM EMPLOYEE");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				emps.add(populateEmployee(rs));
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		return emps;
	}
	
	@Override
	public List<Employee> getEmployeeByDeptId(int deptId){
		List<Employee> employeeList = new ArrayList<Employee>();
		try (Connection conn = getConnection(this.sc)) {
			PreparedStatement ps = conn.prepareStatement(
					"SELECT ID, NAME, AGE, SALARY, GENDER, LEVEL, EXPERIENCE, DEPTID FROM EMPLOYEE WHERE DEPTID = ?");
			ps.setInt(1, deptId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				employeeList.add(populateEmployee(rs));
			}
		} catch (SQLException ex) {
			throw new RuntimeException("Database error by fetching employees by dept ID ",ex);
		}
		return employeeList;
	}

	@Override
	public List<Employee> sortEmpById(String sortOrder) {
		List<Employee> emp_list = getAll();
		if("asc".equals(sortOrder)) {
			return emp_list.stream().sorted(Comparator.comparing(Employee::getId)).collect(Collectors.toList());
		} else {
			return emp_list.stream().sorted(Comparator.comparing(Employee::getId).reversed()).collect(Collectors.toList());

		}
	}

	@Override
	public List<Employee> sortEmpByName(String sortOrder) {
		List<Employee> emp_list = getAll();
		if("asc".equals(sortOrder)) {
			return emp_list.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
		} else {
			return emp_list.stream().sorted(Comparator.comparing(Employee::getName).reversed()).collect(Collectors.toList());

		}
	}

	@Override
	public List<Employee> sortEmpByAge(String sortOrder) {
		List<Employee> emp_list = getAll();
		if("asc".equals(sortOrder)) {
			return emp_list.stream().sorted(Comparator.comparing(Employee::getAge)).collect(Collectors.toList());
		} else {
			return emp_list.stream().sorted(Comparator.comparing(Employee::getAge).reversed()).collect(Collectors.toList());

		}
	}

	@Override
	public List<Employee> sortEmpByGender(String sortOrder) {
		List<Employee> emp_list = getAll();
		if("asc".equals(sortOrder)) {
			return emp_list.stream().sorted(Comparator.comparing(Employee::getGender)).collect(Collectors.toList());
		} else {
			return emp_list.stream().sorted(Comparator.comparing(Employee::getGender).reversed()).collect(Collectors.toList());

		}
	}

	@Override
	public List<Employee> sortEmpBySalary(String sortOrder) {
		List<Employee> emp_list = getAll();
		if("asc".equals(sortOrder)) {
			return emp_list.stream().sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList());
		} else {
			return emp_list.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).collect(Collectors.toList());

		}
	}

	@Override
	public List<Employee> sortEmpByExperience(String sortOrder) {
		List<Employee> emp_list = getAll();
		if("asc".equals(sortOrder)) {
			return emp_list.stream().sorted(Comparator.comparing(Employee::getExp)).collect(Collectors.toList());
		} else {
			return emp_list.stream().sorted(Comparator.comparing(Employee::getExp).reversed()).collect(Collectors.toList());

		}
	}

	@Override
	public List<Employee> sortEmpByLevel(String sortOrder) {
		List<Employee> emp_list = getAll();
		if("asc".equals(sortOrder)) {
			return emp_list.stream().sorted(Comparator.comparing(Employee::getLevel)).collect(Collectors.toList());
		} else {
			return emp_list.stream().sorted(Comparator.comparing(Employee::getLevel).reversed()).collect(Collectors.toList());

		}
	}

	@Override
	public List<Employee> sortEmpByDeptId(String sortOrder) {
		List<Employee> emp_list = getAll();
		if("asc".equals(sortOrder)) {
			return emp_list.stream().sorted(Comparator.comparing(Employee::getDeptId)).collect(Collectors.toList());
		} else {
			return emp_list.stream().sorted(Comparator.comparing(Employee::getDeptId).reversed()).collect(Collectors.toList());

		}
	}

	@Override
	public List<Employee> getEmpByName(String name) {
		List<Employee> emp = getAll();
		return emp.stream().filter(e -> e.getName().contains(name)).collect(Collectors.toList());
	}

	@Override
	public List<Employee> getEmpByAge(String byAge, int age) {
		List<Employee> emp = getAll();
		if ("age".equals(byAge)) {
			return emp.stream().filter(a -> a.getAge() == age).collect(Collectors.toList());
		}
		else if("greaterThanAge".equals(byAge)) {
			return emp.stream().filter(a -> a.getAge() > age).collect(Collectors.toList());
		}
		else
			return emp.stream().filter(a -> a.getAge() < age).collect(Collectors.toList());
	}

	@Override
	public List<Employee> getEmpByLevel(String byLevel, int level) {
		List<Employee> emp = getAll();
		if ("level".equals(byLevel)) {
			return emp.stream().filter(a -> a.getLevel() == level).collect(Collectors.toList());
		}
		else if("greaterThanLevel".equals(byLevel)) {
			return emp.stream().filter(a -> a.getLevel() > level).collect(Collectors.toList());
		}
		else
			return emp.stream().filter(a -> a.getLevel() < level).collect(Collectors.toList());
	}

	@Override
	public List<Employee> getEmpByExperience(String byExp, int exp) {
		List<Employee> emp = getAll();
		if ("experience".equals(byExp)) {
			return emp.stream().filter(a -> a.getExp() == exp).collect(Collectors.toList());
		}
		else if("greaterThanExp".equals(byExp)) {
			return emp.stream().filter(a -> a.getExp() > exp).collect(Collectors.toList());
		}
		else
			return emp.stream().filter(a -> a.getExp() < exp).collect(Collectors.toList());
	}

	@Override
	public List<Employee> getEmpBySalary(String bySalary, int sal) {
		List<Employee> emp = getAll();
		if ("salary".equals(bySalary)) {
			return emp.stream().filter(a -> a.getSalary() == sal).collect(Collectors.toList());
		}
		else if("greaterThanSal".equals(bySalary)) {
			return emp.stream().filter(a -> a.getSalary() > sal).collect(Collectors.toList());
		}
		else
			return emp.stream().filter(a -> a.getSalary() < sal).collect(Collectors.toList());
	}

}
