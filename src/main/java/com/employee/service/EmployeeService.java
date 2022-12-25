package com.employee.service;

import org.hibernate.service.spi.ServiceException;

import com.employee.dto.EmployeeDetailsDTO;

public interface EmployeeService {

	EmployeeDetailsDTO save(EmployeeDetailsDTO employeeDetailsDTO) throws ServiceException;

	EmployeeDetailsDTO getEmployee(int employeeId) throws ServiceException;

	EmployeeDetailsDTO deleteEmployee(int employeeId) throws ServiceException;
	
	EmployeeDetailsDTO updateEmployee(EmployeeDetailsDTO employeeDetailsDTO) throws ServiceException;
}
