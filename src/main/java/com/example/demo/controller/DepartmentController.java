package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Slf4j
@RestController
public class DepartmentController {

    private final Logger  logger= LoggerFactory.getLogger(DepartmentController.class);

    @Value("${app.name}")
    private String appName;

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public ResponseEntity<?> saveDepartment(@Valid @RequestBody Department department) {
        logger.info("Inside Save Department, Department is saved.");

        HttpHeaders headers = new HttpHeaders();
        headers.add("HeaderName","New Header");

        Department response =  departmentService.saveDepartment(department);

        return new ResponseEntity<>(
                response,
                headers,
                HttpStatus.valueOf("OK"));
    }
    @GetMapping("/departments")
    public ResponseEntity<?> getDepartment(){

        logger.info("Inside Get Department, All Department is Get.");

        List<Department> response = departmentService.getDepartment();

        HttpHeaders headers = new HttpHeaders();
        headers.add("HeaderName","New Header");

        return new ResponseEntity<>(
                response,
                headers,
                HttpStatus.valueOf("OK"));
    }

    @GetMapping("/departments/{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId){
        return departmentService.getDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){

        log.info("Deleting Department from department table id = "+departmentId);
        departmentService.deleteDepartmentById(departmentId);
        return "Department Deleted with id = "+departmentId;

    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(
            @PathVariable("id") Long departmentId,
            @RequestBody Department department
    ){
        return departmentService.updateDepartment(departmentId,department);

    }

    @GetMapping("/get-app-name")
    public String getAppName(){
        return appName;
    }

}
