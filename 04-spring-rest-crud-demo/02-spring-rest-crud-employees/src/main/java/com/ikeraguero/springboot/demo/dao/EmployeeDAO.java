package com.ikeraguero.springboot.demo.dao;

import com.ikeraguero.springboot.demo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee employee);

    void deleteById(int theId);

}
