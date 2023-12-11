package com.example.demo.Repository;

import com.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByFirstName(String name);

    @Query(value = "select * from employee " +
                   "where first_name ilike %:n% ",nativeQuery = true)
    List<Employee> findByFirstNameContain(@Param("n") String name);
}
