package com.employee.dto;


public class EmployeeDetailsDTO extends BaseDomainDTO {

    private long employeeId;
	
	private String employeeName;

	private int age;

	private long Contact;

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	} 

	public long getContact() {
		return Contact;
	}

	public void setContact(long contact) {
		Contact = contact;
	}
	
	

	
	
}
