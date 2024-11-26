package com.ikeraguero.springboot.demo.dao;

import com.ikeraguero.springboot.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
