package com.spring.first.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.first.demo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
