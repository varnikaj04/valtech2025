package spring.tx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import spring.tx.Employee.Gender;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Autowired
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	private Connection getConnection() throws SQLException {
//		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/training", "postgres", "postgres");
		return dataSource.getConnection();
	}

	@Override
	public void save(Employee e) {
		new JdbcTemplate(dataSource).update(
				"INSERT INTO EMPLOYEE (NAME, AGE, GENDER,SALARY, EXPERIENCE,LEVEL,ID) VALUES (?,?,?,?,?,?,?)",
				e.getName(), e.getAge(), e.getGender().name(), e.getLevel(), e.getExp(), e.getSalary(), e.getId());

//		try (Connection conn = getConnection()) {
//			PreparedStatement ps = conn.prepareStatement(
//					"INSERT INTO EMPLOYEE (NAME, AGE, GENDER,SALARY, EXPERIENCE,LEVEL,ID) VALUES (?,?,?,?,?,?,?)");
//			setValuesToPrepareStatement(e, ps);
//			int rowsAffected = ps.executeUpdate();
//			System.out.println("Rows inserted = " + rowsAffected);
//		} catch (Exception ex) {
//			throw new RuntimeException(ex);
//		}
	}
//
//	private void setValuesToPrepareStatement(Employee e, PreparedStatement ps) throws SQLException {
//		ps.setString(1, e.getName());
//		ps.setInt(2, e.getAge());
//		ps.setString(3, e.getGender().name());
//		ps.setFloat(4, e.getSalary());
//		ps.setInt(5, e.getExp());
//		ps.setInt(6, e.getLevel());
//		ps.setInt(7, (int) e.getId());
//	}

	@Override
	public void update(Employee e) {
		new JdbcTemplate(dataSource).update(
				"UPDATE EMPLOYEE SET NAME = ?, AGE = ? , GENDER = ?,SALARY = ?, EXPERIENCE = ?,LEVEL = ? WHERE ID = ?",
				e.getName(), e.getAge(), e.getGender().name(), e.getLevel(), e.getExp(), e.getSalary(), e.getId());
//		try (Connection conn = getConnection()) {
//			PreparedStatement ps = conn.prepareStatement(
//					"UPDATE EMPLOYEE SET NAME = ?, AGE = ? , GENDER = ?,SALARY = ?, EXPERIENCE = ?,LEVEL = ? WHERE ID = ?");
//			setValuesToPrepareStatement(e, ps);
//			int rowsAffected = ps.executeUpdate();
//			System.out.println("Rows Updated = " + rowsAffected);
//		} catch (Exception ex) {
//			throw new RuntimeException(ex);
//		}
	}

	@Override
	public void delete(int id) {
		new JdbcTemplate(dataSource).update("DELETE FROM EMPLOYEE WHERE ID = ?", id);

//		try (Connection conn = getConnection()) {
//			PreparedStatement ps = conn.prepareStatement("DELETE FROM EMPLOYEE WHERE ID = ?");
//			ps.setInt(1, id);
//			int rowsAffected = ps.executeUpdate();
//			System.out.println("Rows deleted = " + rowsAffected);
//		} catch (Exception ex) {
//			throw new RuntimeException(ex);
//		}
	}

	@Override
	public Employee get(int id) {
		return new JdbcTemplate(dataSource).queryForObject(
				"SELECT ID, NAME, AGE, SALARY, GENDER, LEVEL, EXPERIENCE FROM EMPLOYEE WHERE ID = ?",
				new Object[] { id }, new EmployeeRowMapper());
//		try (Connection conn = getConnection()) {
//			PreparedStatement ps = conn.prepareStatement(
//					"SELECT ID, NAME, AGE, SALARY, GENDER, LEVEL, EXPERIENCE FROM EMPLOYEE WHERE ID = ?");
//			ps.setInt(1, id);
//			ResultSet rs = ps.executeQuery();
//			if (rs.next()) {
//				// if returns true we have another row, false then we r at end of results
//				Employee e = populateEmployee(rs);
//				return e;
//			} else {
//				new RuntimeException("No employee with Id " + id + " found.");
//			}
//		} catch (Exception ex) {
//			throw new RuntimeException(ex);
//		}
//		return null;
	}

	private static class EmployeeRowMapper implements RowMapper<Employee> {

		@Override
		public Employee mapRow(ResultSet rs, int index) throws SQLException {
			return Employee.builder().id(rs.getInt(1)).name(rs.getString(2)).age(rs.getInt(3)).salary(rs.getFloat(4))
					.gender(Gender.valueOf(rs.getString(5))).level(rs.getInt(6)).exp(rs.getInt(7)).build();
		}

	}

//	private Employee populateEmployee(ResultSet rs) throws SQLException {
//		return Employee.builder().id(rs.getInt(1)).name(rs.getString(2)).age(rs.getInt(3)).salary(rs.getFloat(4))
//				.gender(Gender.valueOf(rs.getString(5))).level(rs.getInt(6)).exp(rs.getInt(7)).build();
//	}

	@Override
	public List<Employee> getAll() {
		return new JdbcTemplate(dataSource).query(
				"SELECT ID, NAME, AGE, SALARY, GENDER, LEVEL, EXPERIENCE FROM EMPLOYEE", new EmployeeRowMapper());
//		List<Employee> emps = new ArrayList<Employee>();
//		try (Connection conn = getConnection()) {
//			PreparedStatement ps = conn
//					.prepareStatement("SELECT ID, NAME, AGE, SALARY, GENDER, LEVEL, EXPERIENCE FROM EMPLOYEE");
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				emps.add(populateEmployee(rs));
//			}
//		} catch (Exception ex) {
//			throw new RuntimeException(ex);
//		}
//		return emps;
	}

}
