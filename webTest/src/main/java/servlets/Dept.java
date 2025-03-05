package servlets;

import java.util.Objects;


public class Dept implements Comparable<Dept> {

	private int id;
	private String name;
	private String location;

	public Dept() {}

	public Dept(int id, String name, String location) {
		this.id = id;
		this.name = name;
		this.location = location;
	}

	public static DeptBuilder builder() {
		return new DeptBuilder(new Dept());
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(id, location, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dept other = (Dept) obj;
		return id == other.id && Objects.equals(location, other.location) && Objects.equals(name, other.name);
	}
	

	@Override
	public String toString() {
		return "Dept [id=" + id + ", name=" + name + ", location=" + location + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public static class DeptBuilder {
		private Dept dept;

		public DeptBuilder(Dept dept) {
			this.dept = dept;
		}

		public Dept build() {
			return dept;
		}

		public DeptBuilder id(int id) {
			dept.setId(id);
			return this;
		}

		public DeptBuilder name(String name) {
			dept.setName(name);
			return this;
		}

		public DeptBuilder location(String location) {
			dept.setLocation(location);
			return this;
		}
	}

	@Override
	public int compareTo(Dept o) {
		return 0;
	}

}
