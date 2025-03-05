package assignment;

import java.util.Objects;

public class Employee implements Comparable<Employee> {

	private long id;
	private String name;
	private int age;
	private float salary;
	private int level;
	private int exp;
	private Gender gender;

	public enum Gender {
		FEMALE, MALE, OTHER;
	}

	public Employee() {}

	public Employee(long id, String name, int age, float salary, int level, int exp, Gender gender) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.level = level;
		this.exp = exp;
		this.gender = gender;
	}

	public static EmployeeBuilder builder() {
		return new EmployeeBuilder(new Employee());
	}

	@Override
	public int hashCode() {
		return (toString() + "Employee").hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return age == other.age && exp == other.exp && gender == other.gender && id == other.id && level == other.level
				&& Objects.equals(name, other.name)
				&& Float.floatToIntBits(salary) == Float.floatToIntBits(other.salary);
	}

	@Override
	public String toString() {
		return new StringBuilder().append("Id = ").append(id).append(" Name = ").append(name).append(" Age = ")
				.append(age).append(" Salary = ").append(salary).append(" Level = ").append(level).append(" Exp = ")
				.append(exp).append(" Gender = ").append(gender).toString();
	}

	@Override
	public int compareTo(Employee emp) {
		int compareEmpByLevel = Integer.compare(this.level, emp.level);
		if (compareEmpByLevel != 0) {
			return compareEmpByLevel;
		}
		int compareEmpByExp = Integer.compare(this.exp, emp.exp);
		if (compareEmpByExp != 0) {
			return compareEmpByExp;
		}
		int compareEmpByGender = this.gender.compareTo(emp.gender);
		if (compareEmpByGender != 0) {
			return compareEmpByGender;
		}
		int compareEmpBySalary = Float.compare(this.salary, emp.salary);
		if (compareEmpBySalary != 0) {
			return compareEmpBySalary;
		}

		return 0;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public static class EmployeeBuilder {
		private Employee employee;

		public EmployeeBuilder(Employee employee) {
			this.employee = employee;
		}

		public Employee build() {
			return employee;
		}

		public EmployeeBuilder id(long id) {
			employee.setId(id);
			return this;
		}

		public EmployeeBuilder name(String name) {
			employee.setName(name);
			return this;
		}

		public EmployeeBuilder age(int age) {
			employee.setAge(age);
			return this;
		}

		public EmployeeBuilder salary(float salary) {
			employee.setSalary(salary);
			return this;
		}

		public EmployeeBuilder level(int level) {
			employee.setLevel(level);
			return this;
		}

		public EmployeeBuilder exp(int exp) {
			employee.setExp(exp);
			return this;
		}

		public EmployeeBuilder gender(Gender gender) {
			employee.setGender(gender);
			return this;
		}
	}


}
