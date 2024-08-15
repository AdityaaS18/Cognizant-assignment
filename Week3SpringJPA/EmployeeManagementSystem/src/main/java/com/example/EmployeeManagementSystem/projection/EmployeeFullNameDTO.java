package com.example.EmployeeManagementSystem.projection;

import org.springframework.beans.factory.annotation.Value;

public class EmployeeFullNameDTO {

    private final String fullName;

    public EmployeeFullNameDTO(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    // Using @Value to combine first and last names
    @Value("#{target.firstName + ' ' + target.lastName}")
    private String getFullName(String firstName, String lastName) {
        return firstName + " " + lastName;
    }
}
