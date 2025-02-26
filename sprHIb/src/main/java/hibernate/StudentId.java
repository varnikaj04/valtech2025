package hibernate;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class StudentId implements Serializable{

	private int rollNo;
	private int year;
	
	public StudentId() {}
	
	public StudentId(int rollNo, int year) {
		this.rollNo = rollNo;
		this.year = year;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(rollNo, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentId other = (StudentId) obj;
		return rollNo == other.rollNo && year == other.year;
	}

	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	
	
}
