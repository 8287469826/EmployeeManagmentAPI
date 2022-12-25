package com.employee.controller;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.BaseDomainDTO;
import com.employee.dto.EmployeeDetailsDTO;
import com.employee.dto.ErrorDTO;
import com.employee.service.EmployeeService;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value="/save",method=RequestMethod.POST)
	public ResponseEntity<BaseDomainDTO> saveEmployee(@RequestBody EmployeeDetailsDTO employeeDetailsDTO) {
		EmployeeDetailsDTO response;

		try {
			System.out.println(employeeDetailsDTO);
			response = employeeService.save(employeeDetailsDTO);
			if (response != null) {
				ResponseEntity<BaseDomainDTO> res = new ResponseEntity<BaseDomainDTO>(response, HttpStatus.CREATED);
				return res;
			} else {
				ErrorDTO error = new ErrorDTO();
				error.setErrorCode(500);
				error.setErrroMessage("Can't Save an Employee");
				ResponseEntity<BaseDomainDTO> res = new ResponseEntity<BaseDomainDTO>(error,
						HttpStatus.INTERNAL_SERVER_ERROR);
				return res;
			}
		} catch (ServiceException e) {
			e.printStackTrace();
			ErrorDTO error = new ErrorDTO();
			error.setErrorCode(500);
			error.setErrroMessage(e.getMessage());
			ResponseEntity<BaseDomainDTO> res = new ResponseEntity<BaseDomainDTO>(error,
					HttpStatus.INTERNAL_SERVER_ERROR);
			return res;

		}

	}


	@RequestMapping(value="/find/",method=RequestMethod.GET)
	public ResponseEntity<BaseDomainDTO> getEmployee(@RequestParam("employeeId") int employeeId) {

		EmployeeDetailsDTO employeeDetailsDTO;

		try {
			employeeDetailsDTO = employeeService.getEmployee(employeeId);
			if (employeeDetailsDTO != null) {
				ResponseEntity<BaseDomainDTO> res = new ResponseEntity<BaseDomainDTO>(employeeDetailsDTO, HttpStatus.OK);
				return res;
			} else {
				ErrorDTO error = new ErrorDTO();
				error.setErrorCode(500);
				error.setErrroMessage("Can't find employee");
				ResponseEntity<BaseDomainDTO> res = new ResponseEntity<BaseDomainDTO>(error,
						HttpStatus.INTERNAL_SERVER_ERROR);
				return res;
			}
		} catch (ServiceException e) {
			e.printStackTrace();
			ErrorDTO error = new ErrorDTO();
			error.setErrorCode(500);
			error.setErrroMessage(e.getMessage());
			ResponseEntity<BaseDomainDTO> res = new ResponseEntity<BaseDomainDTO>(error,
					HttpStatus.INTERNAL_SERVER_ERROR);
			return res;

		}

	}
	
	
	
	
	@RequestMapping(value="/delete/",method=RequestMethod.DELETE)
	public ResponseEntity<BaseDomainDTO> deleteEmployee(@RequestParam("employeeId") int employeeId) {

		EmployeeDetailsDTO employeeDetailsDTO;

		try {
			employeeDetailsDTO = employeeService.deleteEmployee(employeeId);
			if (employeeDetailsDTO != null) {
				ResponseEntity<BaseDomainDTO> res = new ResponseEntity<BaseDomainDTO>(employeeDetailsDTO, HttpStatus.OK);
				return res;
			} else {
				ErrorDTO error = new ErrorDTO();
				error.setErrorCode(500);
				error.setErrroMessage("Can't delete employee");
				ResponseEntity<BaseDomainDTO> res = new ResponseEntity<BaseDomainDTO>(error,
						HttpStatus.INTERNAL_SERVER_ERROR);
				return res;
			}
		} catch (ServiceException e) {
			e.printStackTrace();
			ErrorDTO error = new ErrorDTO();
			error.setErrorCode(500);
			error.setErrroMessage(e.getMessage());
			ResponseEntity<BaseDomainDTO> res = new ResponseEntity<BaseDomainDTO>(error,
					HttpStatus.INTERNAL_SERVER_ERROR);
			return res;

		}
		
	}

		
		@RequestMapping(value="/update/",method=RequestMethod.PUT)
		public ResponseEntity<BaseDomainDTO> updateEmployee(@RequestBody EmployeeDetailsDTO employeeDetailsDTO) {

			EmployeeDetailsDTO response;
			try {
				response = employeeService.updateEmployee(employeeDetailsDTO);
				if (response != null) {
					ResponseEntity<BaseDomainDTO> res = new ResponseEntity<BaseDomainDTO>(response, HttpStatus.OK);
					return res;
				} else {
					ErrorDTO error = new ErrorDTO();
					error.setErrorCode(500);
					error.setErrroMessage("Can't update employee");
					ResponseEntity<BaseDomainDTO> res = new ResponseEntity<BaseDomainDTO>(error,
							HttpStatus.INTERNAL_SERVER_ERROR);
					return res;
				}
			} catch (ServiceException e) {
				e.printStackTrace();
				ErrorDTO error = new ErrorDTO();
				error.setErrorCode(500);
				error.setErrroMessage(e.getMessage());
				ResponseEntity<BaseDomainDTO> res = new ResponseEntity<BaseDomainDTO>(error,
						HttpStatus.INTERNAL_SERVER_ERROR);
				return res;

			}
	
		
	}
	

}
