package com.example.EmployeeManagementSystem.repository.seondary;

import com.example.EmployeeManagementSystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecondaryEmployeeRepository extends JpaRepository<Employee, Long> {
    // Define repository methods specific to the secondary data source
}
