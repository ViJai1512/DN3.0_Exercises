package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByDepartmentName(String departmentName);

    List<Employee> findByNameContaining(String keyword);

    List<Employee> findByEmailEndingWith(String domain);

    List<Employee> findAllByOrderByNameAsc();

    // Execute named query to find employees by department ID
    @Query(name = "Employee.findByDepartmentId")
    List<Employee> findByDepartmentId(@Param("departmentId") Long departmentId);

    // Execute named query to find employees by email domain
    @Query(name = "Employee.findByEmailDomain")
    List<Employee> findByEmailDomain(@Param("domain") String domain);
}
