package com.vinay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vinay.dto.EmployeeDto;
import com.vinay.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@PostMapping("/register")
	public ResponseEntity<EmployeeDto>  createNewEmployee(@RequestBody EmployeeDto employeeDto){
		return new ResponseEntity<EmployeeDto>(employeeService.addEmployee(employeeDto),HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<EmployeeDto>  updateEmployee(@RequestBody EmployeeDto employeeDto, @PathVariable("id") Integer id){
		return new ResponseEntity<EmployeeDto>(employeeService.updateEmployee(employeeDto, id),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String>  deleteEmployee( @PathVariable("id") Integer id){
		return new ResponseEntity<String>(employeeService.deleteEmployee(id),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDto>  updateEmployee(@PathVariable("id") Integer id){
		return new ResponseEntity<EmployeeDto>(employeeService.getEmployeeByID(id),HttpStatus.OK);
	}
	
	@GetMapping("/email")
	public ResponseEntity<EmployeeDto>  updateEmployee(@RequestParam String email){
		return new ResponseEntity<EmployeeDto>(employeeService.getEmployeeByEmail(email),HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<EmployeeDto>>  getAllEmployee(){
		return new ResponseEntity<List<EmployeeDto>>(employeeService.getAllEmployee(),HttpStatus.OK);
	}

}
