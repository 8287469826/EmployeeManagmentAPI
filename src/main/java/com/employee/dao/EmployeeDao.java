package com.employee.dao;

import com.employee.entity.Employee;
import com.employee.exception.EmployeeDaoException;


public interface EmployeeDao {

	Employee save(Employee employee) throws EmployeeDaoException;

	Employee getEmployee(int employeeId) throws EmployeeDaoException;

	Employee deleteEmployee(int employeeId) throws EmployeeDaoException;
	
	Employee updateEmployee(Employee employee) throws EmployeeDaoException;

}
