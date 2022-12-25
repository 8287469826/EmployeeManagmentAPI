package com.employee.service.impl;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dao.EmployeeDao;
import com.employee.dto.EmployeeDetailsDTO;
import com.employee.entity.Employee;
import com.employee.exception.EmployeeDaoException;
import com.employee.mapper.EmployeeMapper;
import com.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeMapper mapper;

	@Autowired
	EmployeeDao employeeDao;

	@Autowired
	EmployeeDetailsDTO employeeDetailsDTO;

	@Autowired
	Employee employee;

	@Override
	public EmployeeDetailsDTO save(EmployeeDetailsDTO employeeDetailsDTO)
			throws org.hibernate.service.spi.ServiceException {


		Employee employee = mapper.getEmployeeFromEmployeeDTO(employeeDetailsDTO);

		try {
			employee = employeeDao.save(employee);
			employeeDetailsDTO= mapper.getEmployeeDTOFromEmployee(employee);
		} catch ( EmployeeDaoException e) {
			throw new ServiceException(e.getMessage());
		}
		return employeeDetailsDTO;
	}

	@Override
	public EmployeeDetailsDTO getEmployee(int employeeId)
			throws org.hibernate.service.spi.ServiceException {
		try {
			employee = employeeDao.getEmployee(employeeId);
			employeeDetailsDTO= mapper.getEmployeeDTOFromEmployee(employee);
		} catch ( EmployeeDaoException e) {
			throw new ServiceException(e.getMessage());
		}
		return employeeDetailsDTO;

	}

	@Override
	public EmployeeDetailsDTO deleteEmployee(int employeeId)
			throws org.hibernate.service.spi.ServiceException {

		try {
			employee = employeeDao.deleteEmployee(employeeId);
			employeeDetailsDTO= mapper.getEmployeeDTOFromEmployee(employee);
		} catch ( EmployeeDaoException e) {
			throw new ServiceException(e.getMessage());
		}
		return employeeDetailsDTO;
	}

	@Override
	public EmployeeDetailsDTO updateEmployee(
			EmployeeDetailsDTO employeeDetailsDTO)
					throws org.hibernate.service.spi.ServiceException {
		Employee employee = mapper.getEmployeeFromEmployeeDTO(employeeDetailsDTO);

		try {
			employee = employeeDao.updateEmployee(employee);
			employeeDetailsDTO= mapper.getEmployeeDTOFromEmployee(employee);
		} catch ( EmployeeDaoException e) {
			throw new ServiceException(e.getMessage());
		}
		return employeeDetailsDTO;
	}

	





}
