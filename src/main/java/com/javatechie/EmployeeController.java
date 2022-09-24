package com.javatechie;

import com.javatechie.entity.Employee;
import com.javatechie.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;


    @PostMapping
    public String addEmployee(@RequestBody Employee employee) {
        return service.addEmployee(employee);
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return service.getEmployees();
    }

    @GetMapping("/2nd")
    public List<Employee> getEmployees2ndApproach() {
        return service.getEmployees2ndApproach();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable int id) {
        return service.findById(id);
    }

    @GetMapping("/name/{id}")
    public String getNameById(@PathVariable int id) {
        return service.getNameById(id);
    }

    @GetMapping("/{name}/{dept}")
    public List<Employee> getEmployeeByNameAndDept(@PathVariable String name, @PathVariable String dept) {
        return service.getEmployeeByNameAndDept(name, dept);
    }

    @PutMapping
    public int updateEmployee(@RequestBody Employee employee) {
        return service.updateEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public int deleteEmployee(@PathVariable int id) {
        return service.deleteEmployee(id);
    }
}
