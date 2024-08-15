package com.example.EmployeeManagementSystem.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "employees")
@NamedQueries({
        @NamedQuery(name = "Employee.findByDepartmentId",
                query = "SELECT e FROM Employee e WHERE e.department.id = :departmentId"),
        @NamedQuery(name = "Employee.findByEmailDomain",
                query = "SELECT e FROM Employee e WHERE e.email LIKE CONCAT('%', :domain)")
})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;
}
