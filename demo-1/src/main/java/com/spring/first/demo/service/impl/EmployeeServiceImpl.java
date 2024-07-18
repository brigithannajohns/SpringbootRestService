package com.spring.first.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.first.demo.exception.ResourceNotFoundException;
import com.spring.first.demo.model.Employee;
import com.spring.first.demo.repository.EmployeeRepository;
import com.spring.first.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    
	private EmployeeRepository repo;
	
	public EmployeeServiceImpl(EmployeeRepository repo) {
		super();
		this.repo=repo;
		// TODO Auto-generated constructor stub
	}

	@Override
	
	public Employee saveEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return repo.save(emp);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		java.util.Optional<Employee> employee=repo.findById(id);
		if(employee.isPresent()) {
		  return employee.get();
		}
		else {
			throw new ResourceNotFoundException("Employee", "id", id);
		}
}

	@Override
	public Employee updateEmployee(Employee emp, long id) {
		Employee existingEmployee = repo.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Employee", "id", id));
		existingEmployee.setFname(emp.getFname());
		existingEmployee.setLname(emp.getLname());
		existingEmployee.setEmail(emp.getEmail());
		return existingEmployee;
	}

	@Override
	public void deleteEmployee(long id) {

		repo.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Employee", "id", id));
		repo.deleteById(id);
	}
}
