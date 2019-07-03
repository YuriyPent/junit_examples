package junithamcrest;

import java.util.List;

public class Employee {

	private Long empId;
	private String empName;
	private String gender;
	private List<String> awards;

	public Employee(Long empId, String empName, String gender, List<String> awards) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.gender = gender;
		this.awards = awards;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<String> getAwards() {
		return awards;
	}

	public void setAwards(List<String> awards) {
		this.awards = awards;
	}

}
