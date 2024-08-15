package com.example.EmployeeManagementSystem.repository.primary;

import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.projections.EmployeeNameEmailProjection;
import com.example.EmployeeManagementSystem.projections.EmployeeDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PrimaryEmployeeRepository extends JpaRepository<Employee, Long> {
    // Method using interface-based projection
    List<EmployeeNameEmailProjection> findByDepartmentId(Long departmentId);

    // Example with @Query for class-based projection
    @Query("SELECT new com.example.EmployeeManagementSystem.projections.EmployeeDetail(e.name, e.email) FROM Employee e WHERE e.department.id = :departmentId")
    List<EmployeeDetail> findEmployeeDTOsByDepartmentId(@Param("departmentId") Long departmentId);
}
