package com.javatechie.service;

import com.javatechie.dao.EmployeeRepository;
import com.javatechie.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public String addEmployee(Employee employee){
        return repository.save(employee)+" RECORD INSERTED !";
    }

    public List<Employee> getEmployees(){
        return repository.findAll();
    }

    public List<Employee> getEmployees2ndApproach(){
        return repository.findAllBeanPropertyMapper();
    }

    public Employee findById(int id){
        return repository.findById(id);
    }
    public String getNameById(int id){
        return repository.getNameById(id);
    }

    public List<Employee> getEmployeeByNameAndDept(String name,String dept){
        return repository.findByNameAndDept(name, dept);
    }

    public int updateEmployee(Employee employee){
        return repository.update(employee);
    }

    public int deleteEmployee(int id){
        return repository.deleteById(id);
    }
}
