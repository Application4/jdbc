package com.javatechie.dao.impl;

import com.javatechie.dao.EmployeeRepository;
import com.javatechie.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Employee employee) {
        return jdbcTemplate.update(
                "insert into EMPLOYEES_DATA (name, dept, email, doj) values(?,?,?,?)",
                employee.getName(), employee.getDept(), employee.getEmail(), employee.getDoj());
    }

    @Override
    public List<Employee> findAll() {
        return jdbcTemplate.query("select * from EMPLOYEES_DATA", new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                return Employee.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .dept(rs.getString("dept"))
                        .email(rs.getString("email"))
                        .doj(rs.getDate("doj"))
                        .build();
            }
        });
    }

    @Override
    public List<Employee> findAllBeanPropertyMapper() {
        return jdbcTemplate.query("select * from EMPLOYEES_DATA",
                new BeanPropertyRowMapper(Employee.class));
    }

    @Override
    public Employee findById(int id) {
        return jdbcTemplate.queryForObject(
                "select * from EMPLOYEES_DATA where id = ?",
                new BeanPropertyRowMapper<Employee>(Employee.class),
                id);
    }

    @Override
    public String getNameById(int id) {
        return jdbcTemplate.queryForObject(
                "select name from EMPLOYEES_DATA where id = ?",
                String.class,
                id);
    }

    @Override
    public List<Employee> findByNameAndDept(String name, String dept) {
        return jdbcTemplate.query("select * from EMPLOYEES_DATA where name=? and dept =? ",
                (rs, rowNum) -> Employee.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .dept(rs.getString("dept"))
                        .email(rs.getString("email"))
                        .doj(rs.getDate("doj"))
                        .build(), name, dept);
    }

    @Override
    public int update(Employee employee) {
        return jdbcTemplate.update(
                "UPDATE EMPLOYEES_DATA SET name = ? ,  dept = ? , email= ? , doj= ?  WHERE id = ?",
                employee.getName(), employee.getDept(), employee.getEmail(), employee.getDoj(), employee.getId());


    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM EMPLOYEES_DATA WHERE id =?", id);
    }





}
