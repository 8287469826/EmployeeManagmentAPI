package com.employee.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employee.dto.EmployeeDetailsDTO;
import com.employee.entity.Employee;

@Component
public class EmployeeMapper {
	
	@Autowired
	Employee employee;
	
	@Autowired
	EmployeeDetailsDTO  employeeDetailsDTO;

	public Employee getEmployeeFromEmployeeDTO(
			EmployeeDetailsDTO employeeDetailsDTO) {
		employee.setEmployeeId(employeeDetailsDTO.getEmployeeId());
		employee.setEmployeeName(employeeDetailsDTO.getEmployeeName());
		employee.setAge(employeeDetailsDTO.getAge());
		employee.setContact(employeeDetailsDTO.getContact());
		return employee;
	}

	public EmployeeDetailsDTO getEmployeeDTOFromEmployee(
			Employee employee) {
		employeeDetailsDTO.setEmployeeId(employee.getEmployeeId());
		employeeDetailsDTO.setEmployeeName(employee.getEmployeeName());
		employeeDetailsDTO.setAge(employee.getAge());
		employeeDetailsDTO.setContact(employee.getContact());
		
		return employeeDetailsDTO;
	}
	

	

	

}
