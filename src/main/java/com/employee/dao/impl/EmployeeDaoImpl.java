package com.employee.dao.impl;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.employee.dao.EmployeeDao;
import com.employee.entity.Employee;
import com.employee.exception.EmployeeDaoException;

@Repository
@Transactional



/**
 * This class is used to access data for the User entity.
 * Repository annotation allows the component scanning support to find and 
 * configure the DAO without any XML configuration and also provide the Spring 
 * exception translation.
 * Since we've setup setPackagesToScan and transaction manager on
 * DatabaseConfig, any bean method annotated with Transactional will cause
 * Spring to magically call begin() and commit() at the start/end of the
 * method. If exception occurs it will also call rollback().
 */
public class EmployeeDaoImpl implements EmployeeDao {


	// ------------------------
	// PRIVATE FIELDS
	// ------------------------

	// An EntityManager will be automatically injected from entityManagerFactory
	// setup on DatabaseConfig class.

	@PersistenceContext
	private EntityManager entityManager;

	
	/**
	   * save the employee to the database.
	   */
	@Override
	public Employee save(Employee employee) throws EmployeeDaoException {

		
		entityManager.persist(employee);
		return employee;
	}

	/**
	   * get the employee from the database.
	   */
	@Override
	public Employee getEmployee(int employeeId) throws EmployeeDaoException {
		Employee employee;
		
		try {
			
		 employee=entityManager.find(Employee.class, employeeId);
		
		}catch(Exception e) {
			throw new EmployeeDaoException(e.getMessage());
		}

		return employee;
	}

	
	/**
	   * Delete the employee from the database.
	   */
	@Override
	public Employee deleteEmployee(int employeeId) throws EmployeeDaoException {
		
		Employee employee=entityManager.find(Employee.class, employeeId);
		
		if (entityManager.contains(employee))
		      entityManager.remove(employee);
		    else
		      entityManager.remove(entityManager.merge(employee));
		    return employee;
	}

	/**
	   * update the employee in the database.
	   */
	@Override
	public Employee updateEmployee(Employee employee)
			throws EmployeeDaoException {
		entityManager.merge(employee);
	    return employee;
	}

}
