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


@Service
public class EmployeeServiceImpl implements EmployeeService{

    private static EmployeeMapper mapper = new EmployeeMapperImpl();

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<EmployeeDTO> getAllEmployee() {

        List<EmployeeDTO> employeeDTOList = new ArrayList<>();

        List<Employee> employeeList =  employeeRepository.findAll();
        employeeList.forEach(employee -> {
            employeeDTOList.add(mapper.entityToDto(employee));
        });
        return employeeDTOList;
    }

    public EmployeeDTO getEmployee(int id){
        Employee employee = employeeRepository.findById(id).get();
        return  mapper.entityToDto(employee);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
