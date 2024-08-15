package com.example.EmployeeManagementSystem.controller;

import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import com.example.EmployeeManagementSystem.projection.EmployeeNameEmailDTO;
import com.example.EmployeeManagementSystem.projection.EmployeeNameEmailProjection;
import com.example.EmployeeManagementSystem.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Create a new employee
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveOrUpdateEmployee(employee);
    }

    // Get all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // Get employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        return employee.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update an employee
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        Optional<Employee> existingEmployee = employeeService.getEmployeeById(id);

        if (existingEmployee.isPresent()) {
            Employee employee = existingEmployee.get();
            employee.setName(employeeDetails.getName());
            employee.setEmail(employeeDetails.getEmail());
            employee.setDepartment(employeeDetails.getDepartment());

            final Employee updatedEmployee = employeeService.saveOrUpdateEmployee(employee);
            return ResponseEntity.ok(updatedEmployee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete an employee
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        if (employeeService.getEmployeeById(id).isPresent()) {
            employeeService.deleteEmployeeById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Get employees by department name
    @GetMapping("/department/{departmentName}")
    public List<Employee> getEmployeesByDepartmentName(@PathVariable String departmentName) {
        return employeeService.getEmployeesByDepartmentName(departmentName);
    }
    
    // Endpoint for paginated employee list
    @GetMapping
    public Page<Employee> getEmployees(@PageableDefault(sort = "name", direction = Sort.Direction.ASC)Pageable pageable) {
        return employeeService.getEmployees(pageable);
    }

    // Endpoint for paginated employees by department name
    @GetMapping("/department")
    public Page<Employee> getEmployeesByDepartment(@RequestParam String departmentName,@PageableDefault(sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {
        return employeeService.getEmployeesByDepartmentName(departmentName, pageable);
    }
    
 // Fetch employees with only name and email using interface-based projection
    @GetMapping("/projection/interface")
    public List<EmployeeNameEmailProjection> getEmployeesProjection() {
        return employeeRepository.findAllBy();
    }

    // Fetch employees with only name and email using class-based projection
    @GetMapping("/projection/class")
    public List<EmployeeNameEmailDTO> getEmployeesClassProjection() {
        return employeeRepository.findEmployeeNameAndEmail();
    }
    
}
