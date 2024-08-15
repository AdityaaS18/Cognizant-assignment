package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.EmployeeManagementSystem.projection.EmployeeNameEmailProjection;
import com.example.EmployeeManagementSystem.projection.EmployeeNameEmailDTO;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	// Custom query to find employees with salary greater than a certain amount
    @Query("SELECT e FROM Employee e WHERE e.salary > :salary")
    List<Employee> findEmployeesWithSalaryGreaterThan(@Param("salary") Double salary);
    
    @Query(name = "Employee.findByDepartmentName")
    List<Employee> findEmployeesByDepartmentName(@Param("name") String departmentName);
    
    // Custom query to use class-based projection
    @Query("SELECT new com.example.EmployeeManagementSystem.projection.EmployeeNameEmailDTO(e.name, e.email) FROM Employee e")
    List<EmployeeNameEmailDTO> findEmployeeNameAndEmail();
    
    // Derived query method to find employees by department name
    List<Employee> findByDepartmentName(String departmentName);

    // Derived query method to find employees by name
    List<Employee> findByName(String name);
    
    // Find employees by email
    List<Employee> findByEmail(String email);
    
    // Method for pagination
    Page<Employee> findAll(Pageable pageable);

    // Method for finding by department name with pagination
    Page<Employee> findByDepartmentName(String departmentName, Pageable pageable);
    
    // Fetch only name and email
    List<EmployeeNameEmailProjection> findAllBy();
    
}
