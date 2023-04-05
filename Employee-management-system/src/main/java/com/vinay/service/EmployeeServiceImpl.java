package com.vinay.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinay.dto.EmployeeDto;
import com.vinay.exception.ResourceNotFoundException;
import com.vinay.model.Employee;
import com.vinay.repository.EmployeeRepository;



@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public EmployeeDto addEmployee(EmployeeDto employeeDto) {
		Employee employee = modelMapper.map(employeeDto, Employee.class);
		 Employee savedEmployee = employeeRepository.save(employee);
		return modelMapper.map(savedEmployee, EmployeeDto.class);
	}

	@Override
	public EmployeeDto updateEmployee(EmployeeDto employeeDto, Integer empId) {
		Employee emp = employeeRepository.findById(empId).orElseThrow(()-> new ResourceNotFoundException("Employee", "Employee id", ""+empId));
		Employee employee = modelMapper.map(employeeDto, Employee.class);
		employee.setEmail(emp.getEmail());
		Employee savedEmployee = employeeRepository.save(employee);
		return modelMapper.map(savedEmployee, EmployeeDto.class);
	}

	@Override
	public String deleteEmployee(Integer empId) {
		Employee emp = employeeRepository.findById(empId).orElseThrow(()-> new ResourceNotFoundException("Employee", "Employee id", ""+empId));
		employeeRepository.delete(emp);
		return "Employee data deleted successfully!!";
	}

	@Override
	public EmployeeDto getEmployeeByID(Integer empId) {
		Employee emp = employeeRepository.findById(empId).orElseThrow(()-> new ResourceNotFoundException("Employee", "Employee id", ""+empId));
		return modelMapper.map(emp, EmployeeDto.class);
	}

	@Override
	public EmployeeDto getEmployeeByEmail(String email) {
		Employee emp = employeeRepository.findByEmail(email).orElseThrow(()-> new ResourceNotFoundException("Employee", "Employee email", email));
		return modelMapper.map(emp, EmployeeDto.class);
	}

	@Override
	public List<EmployeeDto> getAllEmployee() {
		List<Employee> allEmployee = employeeRepository.findAll();
		List<EmployeeDto> employeeDto = allEmployee.stream().map(emp-> modelMapper.map(emp, EmployeeDto.class)).collect(Collectors.toList());
		return employeeDto;
	}

	

}
