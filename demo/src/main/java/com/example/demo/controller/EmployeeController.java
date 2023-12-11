package com.example.demo.controller;


import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all-employee")
    public List<EmployeeDTO> getAllEmployee(){
    return employeeService.getAllEmployee();
    }
    @GetMapping("/employee/{id}")
    public EmployeeDTO getAllEmployee(@PathVariable("id") int id){
        return employeeService.getEmployee(id);
    }

    @PostMapping("/employee")
    public Employee saveEmployee(@Valid @RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }


    @PutMapping("/update-employee")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }


    @DeleteMapping("/delete-employee/{id}")
    public String deleteEmployee(@PathVariable("id") int id){
        try {
            employeeService.deleteEmployee(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "Employee deleted with ID = "+id;
    }


    @GetMapping("/find-by-first-name/{name}")
    public List<EmployeeDTO> findByName(@PathVariable("name") String name){
        return employeeService.findByName(name);
    }
}
