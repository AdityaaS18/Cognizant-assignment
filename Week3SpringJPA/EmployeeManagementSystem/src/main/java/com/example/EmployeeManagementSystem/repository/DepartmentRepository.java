package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import com.example.EmployeeManagementSystem.projection.DepartmentNameProjection;

import java.util.List;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

	// Custom query to find departments with more than a certain number of employees
    @Query("SELECT d FROM Department d WHERE SIZE(d.employees) > :number")
    List<Department> findDepartmentsWithMoreThanXEmployees(@Param("number") int number);
    
    @Query(name = "Department.findByEmployeeEmail")
    Department findDepartmentByEmployeeEmail(@Param("email") String email);
    // Derived query method to find a department by name
    Department findByName(String name);
    
    // Find department by an employee's email
    Department findByEmployeesEmail(String email);
    
    // Fetch department name and its employees (name and email)
    DepartmentNameProjection findByNames(String name);
}
