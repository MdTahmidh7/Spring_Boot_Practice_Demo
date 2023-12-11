package com.example.demo.service;

import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.mapper.EmployeeMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static EmployeeMapper mapper = new EmployeeMapperImpl();

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeDTO> getAllEmployee() {

        List<EmployeeDTO> employeeDTOList = new ArrayList<>();

        List<Employee> employeeList = employeeRepository.findAll();
        employeeList.forEach(employee -> {
            employeeDTOList.add(mapper.entityToDto(employee));
        });
        return employeeDTOList;
    }

    public EmployeeDTO getEmployee(int id) {
        Employee employee = employeeRepository.findById(id).get();
        return mapper.entityToDto(employee);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {

        Optional<Employee> employeeOptional = employeeRepository.findById(employee.getId());
        if (employeeOptional.isEmpty()) {
            throw new RuntimeException("Employee not found by id = " + employee.getId());
        }
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isEmpty()) {
            throw new RuntimeException("Employee not found by id = " + id);
        }
        employeeRepository.deleteById(id);
    }

    @Override
    public List<EmployeeDTO> findByFirstName(String name) {

        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        List<Employee> employeeList = employeeRepository.findByFirstNameContain(name);

        employeeList.forEach(employee -> {
            employeeDTOList.add(mapper.entityToDto(employee));
        });
        return employeeDTOList;
    }
}
