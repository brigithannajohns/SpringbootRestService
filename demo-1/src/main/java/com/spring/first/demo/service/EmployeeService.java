package com.spring.first.demo.service;



import java.util.List;

import com.spring.first.demo.model.Employee;


public interface EmployeeService {
Employee saveEmployee(Employee emp);

List<Employee> getAllEmployees();

Employee getEmployeeById(long id);
Employee updateEmployee(Employee emp, long id);
void deleteEmployee(long id);
}
