package com.example.EmployeeManagementSystem.repository.primary;

import com.example.EmployeeManagementSystem.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrimaryDepartmentRepository extends JpaRepository<Department, Long> {
    Department findByName(String name);
}

