package servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import dao.Employee;
import dao.Employee.Gender;
import jakarta.servlet.ServletContext;

public class DeptDAOImpl implements DeptDAO {

	private Map<Integer, Dept> depts;
	
	ServletContext sc;
	
	
	
	public DeptDAOImpl() {}

	public DeptDAOImpl(ServletContext sc) {
//		depts = new HashMap<Integer, Dept>();
		this.sc = sc;
		
	}

//	static {
//		try {
//			Class.forName("org.postgresql.Driver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//
//	}
	
	

	private Connection getConnection(ServletContext sc) throws SQLException {
		String url = (String)sc.getAttribute("url");
		String username = (String)sc.getAttribute("username");
		String password = (String)sc.getAttribute("password");
		return DriverManager.getConnection(url,username,password);
//		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/training", "postgres", "postgres");
	}

	@Override
	public void save(Dept d) {
		try (Connection conn = getConnection(this.sc)) {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO DEPT (NAME, LOCATION, ID) VALUES (?,?,?)");
			setValuesToPrepareStatement(d, ps);
			int rowsAffected = ps.executeUpdate();
			System.out.println("Rows inserted = " + rowsAffected);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	private void setValuesToPrepareStatement(Dept d, PreparedStatement ps) throws SQLException {
//		ps.setInt(1, d.getId());
		ps.setString(1, d.getName());
		ps.setString(2, d.getLocation());
		ps.setInt(3, d.getId());

	}

	@Override
	public void update(Dept d) {
		try (Connection conn = getConnection(this.sc)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE DEPT SET NAME = ? , LOCATION = ? WHERE ID = ?");
			setValuesToPrepareStatement(d, ps);
			int rowsAffected = ps.executeUpdate();
			System.out.println("Rows Updated = " + rowsAffected);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public void delete(int id) {
		try (Connection conn = getConnection(this.sc)) {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM DEPT WHERE ID = ?");
			ps.setInt(1, id);
			int rowsAffected = ps.executeUpdate();
			System.out.println("Rows deleted = " + rowsAffected);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public Dept getDept(int id) {
		try (Connection conn = getConnection(this.sc)) {
			PreparedStatement ps = conn.prepareStatement("SELECT ID, NAME, LOCATION FROM DEPT WHERE ID = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				// if returns true we have another row, false then we r at end of results
				Dept d = populateDept(rs);
				return d;
			} else {
				new RuntimeException("No dept with Id " + id + " found.");
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		return null;
	}

	private Dept populateDept(ResultSet rs) throws SQLException {
		return Dept.builder().id(rs.getInt(1)).name(rs.getString(2)).location(rs.getString(3)).build();
	}

	@Override
	public Set<Dept> getAll() {
		Set<Dept> dpts = new HashSet<Dept>();
		try (Connection conn = getConnection(this.sc)) {
			PreparedStatement ps = conn.prepareStatement("SELECT ID, NAME, LOCATION FROM DEPT");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				dpts.add(populateDept(rs));
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		return dpts;
	}

	@Override
	public Dept first() {
		try (Connection conn = getConnection(this.sc)) {
			DeptDAO dao = new DeptDAOImpl(sc);
			PreparedStatement ps = conn
					.prepareStatement("SELECT ID, NAME, LOCATION FROM DEPT WHERE ID = (SELECT MIN(ID) FROM DEPT)");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				// if returns true we have another row, false then we r at end of results
				Dept d = populateDept(rs);
				return d;
			} else {
				new RuntimeException("No dept with id found.");
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		return null;

//		return depts.get(depts.keySet().stream().min((a,b) -> (a - b)).get());
	}

	@Override
	public Dept last() {
		try (Connection conn = getConnection(this.sc)) {
			DeptDAO dao = new DeptDAOImpl(sc);
			PreparedStatement ps = conn
					.prepareStatement("SELECT ID, NAME, LOCATION FROM DEPT WHERE ID = (SELECT MAX(ID) FROM DEPT)");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				// if returns true we have another row, false then we r at end of results
				Dept d = populateDept(rs);
				return d;
			} else {
				new RuntimeException("No dept with id found.");
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		return null;
//		return depts.get(depts.keySet().stream().max((a, b) -> (a - b)).get());
	}

	@Override
	public Dept next(int id) {
		try (Connection conn = getConnection(this.sc)) {
			DeptDAO dao = new DeptDAOImpl(sc);
			PreparedStatement ps = conn.prepareStatement(
					"SELECT ID, NAME, LOCATION FROM DEPT WHERE ID = (SELECT MIN(ID) FROM DEPT WHERE ID > ?)");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				// if returns true we have another row, false then we r at end of results
				Dept d = populateDept(rs);
				return d;
			} else {
				return dao.first();
//				new RuntimeException("No dept with id" + id + "found.");
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
//		return null;
//		if (id == depts.size())
//			return depts.get(depts.size());
//		return depts.get(id + 1);
	}

	@Override
	public Dept previous(int id) {
		try (Connection conn = getConnection(this.sc)) {
			DeptDAO dao = new DeptDAOImpl(sc);
			PreparedStatement ps = conn.prepareStatement(
					"SELECT ID, NAME, LOCATION FROM DEPT WHERE ID = (SELECT MAX(ID) FROM DEPT WHERE ID < ?)");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				// if returns true we have another row, false then we r at end of results
				Dept d = populateDept(rs);
				return d;
			} else {
				return dao.last();
			}
//				new RuntimeException("No dept with id found.");
			}
		 catch (Exception ex) {
			throw new RuntimeException(ex);
		}
//		return null;
//		if (id == 1)
//			return getDept(1);
//		return depts.get(id - 1);
	}

}
