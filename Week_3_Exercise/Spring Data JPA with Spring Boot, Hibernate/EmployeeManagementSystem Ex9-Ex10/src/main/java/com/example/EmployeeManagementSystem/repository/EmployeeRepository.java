package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.projections.EmployeeDetail;
import com.example.EmployeeManagementSystem.projections.EmployeeDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT new com.example.EmployeeManagementSystem.projections.EmployeeDetail(e.name, e.email) FROM Employee e WHERE e.department.id = :departmentId")
    List<EmployeeDetail> findEmployeeDTOsByDepartmentId(@Param("departmentId") Long departmentId);
}
