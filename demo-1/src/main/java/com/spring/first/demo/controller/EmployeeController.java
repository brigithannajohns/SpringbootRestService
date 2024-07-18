package com.spring.first.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.first.demo.model.Employee;
import com.spring.first.demo.service.EmployeeService;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
private EmployeeService service;

public EmployeeController(EmployeeService service) {
	super();
	this.service=service;
}

@PostMapping()
public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
	return new ResponseEntity<Employee>(service.saveEmployee(employee),HttpStatus.CREATED);
}

@GetMapping
public List<Employee> getAllEmployees(){
	return service.getAllEmployees();
}

@GetMapping("{id}")
public ResponseEntity<Employee> getElementById(@PathVariable("id") long eid) {
 return new ResponseEntity<Employee>(service.getEmployeeById(eid),HttpStatus.OK);
}

@PutMapping("{id}")
public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employee){

	 return new ResponseEntity<Employee>(service.updateEmployee(employee,id),HttpStatus.OK);	
}

@DeleteMapping("{id}")
public ResponseEntity<String> deleteEmployee(@PathVariable long id){
	service.deleteEmployee(id);
	 return new ResponseEntity<String>("Employee deleted successfully",HttpStatus.OK);	
}
}