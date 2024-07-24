package com.example.demo;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.mapper.EmployeeMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {



	private static EmployeeMapper mapper = new EmployeeMapperImpl();

	public static void main(String[] args) {


		SpringApplication.run(DemoApplication.class, args);

		Employee employee = Employee.builder()
				.id(1)
				.firstName("jjj")
				.lastName("kkk")
				.build();


		EmployeeDTO employeeDTO = mapper.entityToDto(employee);
		System.out.println(employeeDTO.toString());
	}

}
