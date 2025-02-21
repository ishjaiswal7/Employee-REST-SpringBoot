package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
	private final EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
		Employee createEmployee = this.employeeService.createEmployee(employee);
		return ResponseEntity.ok(createEmployee);
	}
	
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employees = this.employeeService.getAllEmployees();
		return ResponseEntity.ok(employees);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeesById(@PathVariable long id) {
		Employee employee = this.employeeService.getEmployeeById(id);
		if (employee != null) {
			return ResponseEntity.ok(employee);
		}
		return ResponseEntity.notFound().build();	
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployees(@PathVariable long id,@Valid @RequestBody Employee employeeDetails) {
		Employee updateEmployee = employeeService.updateEmployee(id, employeeDetails);
		if (updateEmployee != null) {
			return ResponseEntity.ok(updateEmployee);
		}
		return ResponseEntity.notFound().build();	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable long id) {
		employeeService.deleteEmployee(id);
		return ResponseEntity.noContent().build();
	}
}
