package servlets;

import java.io.IOException;
import java.util.List;

import dao.Employee;
import dao.Employee.Gender;
import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/employees")

public class EmployeesServlet extends HttpServlet {

	private EmployeeDAO dao;

	@Override
	public void init(ServletConfig config) throws ServletException {
		dao = new EmployeeDAOImpl(config.getServletContext());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String operation = req.getParameter("operation");
		if ("Cancel".equals(operation)) {
			req.setAttribute("emps", dao.getAll());
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
		Employee emp = Employee.builder().id(Integer.parseInt(req.getParameter("id"))).name(req.getParameter("name"))
				.age(Integer.parseInt(req.getParameter("age")))
				.gender(Gender.valueOf(req.getParameter("gender").toUpperCase()))
				.salary(Integer.parseInt(req.getParameter("salary"))).exp(Integer.parseInt(req.getParameter("exp")))
				.level(Integer.parseInt(req.getParameter("level"))).deptId(Integer.parseInt(req.getParameter("deptId"))).build();
		if ("Save".equals(operation)) {
			dao.save(emp);
			req.setAttribute("emps", dao.getAll());
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
		if ("Update".equals(operation)) {
			dao.update(emp);
			req.setAttribute("emps", dao.getAll());
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String operation = req.getParameter("operation");
		String sortOrder = req.getParameter("sortorder");
		String sortBy = req.getParameter("sortBy");
		String search = req.getParameter("search");
		String searchBy = req.getParameter("searchBy");
		

		if ("Update".equals(operation)) {
			int id = Integer.parseInt(req.getParameter("id"));
			Employee e = dao.get(id);
			req.setAttribute("emp", e);
			req.setAttribute("mode", "Update");
			req.setAttribute("readonly", "readonly");
			req.getRequestDispatcher("editEmployee.jsp").forward(req, resp);
			return;
		}

		if ("Delete".equals(operation)) {
			int id = Integer.parseInt(req.getParameter("id"));
			dao.delete(id);
			req.setAttribute("emps", dao.getAll());
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}

		if ("new".equals(operation)) {
			req.setAttribute("mode", "Save");
			req.getRequestDispatcher("editEmployee.jsp").forward(req, resp);
			return;
		}
		
		if("sorting".equals(operation)) {
			if(sortOrder == null) {
				sortOrder = "asc";
			}
			if(sortBy == null) {
				sortBy = "id";
			}
			
			List<Employee> employees = null;
			switch(sortBy) {
			case "id":
				employees = dao.sortEmpById(sortOrder);
				break;
			case "name":
				employees = dao.sortEmpByName(sortOrder);
				break;
			case "age":
				employees = dao.sortEmpByAge(sortOrder);
				break;
			case "gender":
				employees = dao.sortEmpByGender(sortOrder);
				break;
			case "salary":
				employees = dao.sortEmpBySalary(sortOrder);
				break;
			case "experience":
				employees = dao.sortEmpByExperience(sortOrder);
				break;
			case "level":
				employees = dao.sortEmpByLevel(sortOrder);
				break;
			case "deptId":
				employees = dao.sortEmpByDeptId(sortOrder);
				break;
			default:
				employees = dao.sortEmpById(sortOrder);
				break;
			}
			req.setAttribute("emps", employees);
			req.setAttribute("sortorder", sortOrder);
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
		
		
		
		if("name".equals(searchBy)) {
			req.setAttribute("emps", dao.getEmpByName(search));
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
		if("salary".equals(searchBy)) {
			req.setAttribute("emps", dao.getEmpBySalary(searchBy,Integer.parseInt(search)));
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
		if("greaterThanSal".equals(searchBy)) {
			req.setAttribute("emps", dao.getEmpBySalary(searchBy,Integer.parseInt(search)));
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
		if("lessThanSal".equals(searchBy)) {
			req.setAttribute("emps", dao.getEmpBySalary(searchBy,Integer.parseInt(search)));
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
		if("age".equals(searchBy)) {
			req.setAttribute("emps", dao.getEmpByAge(searchBy,Integer.parseInt(search)));
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
		if("lessThanAge".equals(searchBy)) {
			req.setAttribute("emps", dao.getEmpByAge(searchBy,Integer.parseInt(search)));
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
		if("greaterThanAge".equals(searchBy)) {
			req.setAttribute("emps", dao.getEmpByAge(searchBy,Integer.parseInt(search)));
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
		if("experience".equals(searchBy)) {
			req.setAttribute("emps", dao.getEmpByExperience(searchBy,Integer.parseInt(search)));
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
		if("lessThanExp".equals(searchBy)) {
			req.setAttribute("emps", dao.getEmpByExperience(searchBy,Integer.parseInt(search)));
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
		if("greaterThanExp".equals(searchBy)) {
			req.setAttribute("emps", dao.getEmpByExperience(searchBy,Integer.parseInt(search)));
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
		if("level".equals(searchBy)) {
			req.setAttribute("emps", dao.getEmpByLevel(searchBy,Integer.parseInt(search)));
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
		if("lessThanLevel".equals(searchBy)) {
			req.setAttribute("emps", dao.getEmpByLevel(searchBy,Integer.parseInt(search)));
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
		if("greaterThanLevel".equals(searchBy)) {
			req.setAttribute("emps", dao.getEmpByLevel(searchBy,Integer.parseInt(search)));
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
		
		
		req.setAttribute("emps", dao.getAll());
		req.getRequestDispatcher("employees.jsp").forward(req, resp);
	}

}
