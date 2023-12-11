package com.example.demo.mapper;


import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper
public abstract class EmployeeMapper {


    @Mapping(source = "employee", target = "fullName", qualifiedByName = "getFullName")
    public abstract EmployeeDTO entityToDto(Employee employee);

    @InheritInverseConfiguration(name = "entityToDto")
    abstract Employee dtoToEntity(EmployeeDTO employeeDTO);


    @Named("getFullName")
    public String getFullName(Employee employee){
        return employee.getFirstName()+' '+employee.getLastName();
    }
}
