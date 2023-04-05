package com.vinay.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinay.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	
	Optional<Employee> findByEmail(String email);

}
