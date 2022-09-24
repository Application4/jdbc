package com.javatechie.dao;

import com.javatechie.entity.Employee;

import java.util.List;

public interface EmployeeRepository {

    int save(Employee employee);

    int update(Employee employee);

    int deleteById(int id);

    List<Employee> findAll();

    List<Employee> findAllBeanPropertyMapper();

    List<Employee> findByNameAndDept(String name, String dept);

    Employee findById(int id);

    String getNameById(int id);
}
