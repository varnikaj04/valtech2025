package day4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import assignment.Employee;
import assignment.Employee.Gender;

public class EmployeeDAOImpl implements EmployeeDAO {

	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/training", "postgres", "postgres");
	}

	@Override
	public void save(Employee e) {
		try (Connection conn = getConnection()) {
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO EMPLOYEE (NAME, AGE, GENDER,SALARY, EXPERIENCE,LEVEL,ID) VALUES (?,?,?,?,?,?,?)");
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
		ps.setInt(7, (int) e.getId());
	}

	@Override
	public void update(Employee e) {
		try (Connection conn = getConnection()) {
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE EMPLOYEE SET NAME = ?, AGE = ? , GENDER = ?,SALARY = ?, EXPERIENCE = ?,LEVEL = ? WHERE ID = ?");
			setValuesToPrepareStatement(e, ps);
			int rowsAffected = ps.executeUpdate();
			System.out.println("Rows Updated = " + rowsAffected);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public void delete(int id) {
		try(Connection conn = getConnection()){
			PreparedStatement ps = conn.prepareStatement(
					"DELETE FROM EMPLOYEE WHERE ID = ?");
			ps.setInt(1, id);
			int rowsAffected = ps.executeUpdate();
			System.out.println("Rows deleted = " + rowsAffected);
		}catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}

	@Override
	public Employee get(int id) {
		try (Connection conn = getConnection()) {
			PreparedStatement ps = conn.prepareStatement(
					"SELECT ID, NAME, AGE, SALARY, GENDER, LEVEL, EXPERIENCE FROM EMPLOYEE WHERE ID = ?");
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
				.gender(Gender.valueOf(rs.getString(5))).level(rs.getInt(6)).exp(rs.getInt(7)).build();
	}

	@Override
	public List<Employee> getAll() {
		List<Employee> emps = new ArrayList<Employee>();
		try(Connection conn = getConnection()){
			PreparedStatement ps = conn.prepareStatement(
					"SELECT ID, NAME, AGE, SALARY, GENDER, LEVEL, EXPERIENCE FROM EMPLOYEE");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				emps.add(populateEmployee(rs));
			}
		}catch(Exception ex) {
			throw new RuntimeException(ex);
		}
		return emps;
	}

}
