package com.example.EmployeeManagementSystem.projection;

import java.util.List;

public interface DepartmentNameProjection {

    String getName();

    List<EmployeeNameEmailProjection> getEmployees();
}
