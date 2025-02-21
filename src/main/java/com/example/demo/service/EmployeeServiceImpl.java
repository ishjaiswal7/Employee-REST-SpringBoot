package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.BadRequestException;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        if (employee.getName() == null || employee.getName().isEmpty()) {
        	throw new BadRequestException("Username cannot be empty");
        }
        
        if (employee.getEmail() == null || !employee.getEmail().contains("@")) {
        	throw new BadRequestException("Invalid email format");
        }
    	
    	return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
    	Employee foundEmployee = employeeRepository.findById(id).orElse(null);
        
    	if(foundEmployee == null) {
    		throw new ResourceNotFoundException(
    				"Employee with id " +id+ " not found.");
    	}
    	return foundEmployee;
    }

    @Override
    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee existingEmployee = optionalEmployee.get();
            existingEmployee.setName(employeeDetails.getName());
            existingEmployee.setEmail(employeeDetails.getEmail());
            return employeeRepository.save(existingEmployee);
        }
        return null;
    }

    @Override
    public void deleteEmployee(Long id) {
    	Employee foundEmployee = employeeRepository.findById(id).orElse(null);
        
    	if(foundEmployee == null) {
    		throw new ResourceNotFoundException(
    				"Employee with id " +id+ " not found.");
    	}    	
        employeeRepository.deleteById(id);
    }
}
