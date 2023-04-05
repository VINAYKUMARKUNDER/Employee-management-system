package com.vinay.service;

import java.util.List;

import com.vinay.dto.EmployeeDto;

public interface EmployeeService {

	/**
	 * Add a new employee to the database.
	 *
	 * @param employeeDto the employee to add
	 * @return the added employee with its generated ID
	 */
	EmployeeDto addEmployee(EmployeeDto employeeDto);

	/**
	 * Update an existing employee in the database.
	 *
	 * @param employeeDto the employee data to update
	 * @param empId       the ID of the employee to update
	 * @return the updated employee
	 */
	EmployeeDto updateEmployee(EmployeeDto employeeDto, Integer empId);

	/**
	 * Delete an employee from the database.
	 *
	 * @param empId the ID of the employee to delete
	 * @return a message indicating the result of the operation
	 */
	String deleteEmployee(Integer empId);

	/**
	 * Get an employee by ID.
	 *
	 * @param empId the ID of the employee to retrieve
	 * @return the employee with the specified ID, or null if not found
	 */
	EmployeeDto getEmployeeByID(Integer empId);

	/**
	 * Get an employee by email address.
	 *
	 * @param email the email address of the employee to retrieve
	 * @return the employee with the specified email address, or null if not found
	 */
	EmployeeDto getEmployeeByEmail(String email);

	/**
	 * Get a list of all employees in the database.
	 *
	 * @return a list of all employees
	 */
	List<EmployeeDto> getAllEmployee();
}
