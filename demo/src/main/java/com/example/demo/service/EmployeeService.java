package com.example.demo.service;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<EmployeeDTO> getAllEmployee();
    public EmployeeDTO getEmployee(int id);

    public Employee saveEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    void deleteEmployee(int id);
}
