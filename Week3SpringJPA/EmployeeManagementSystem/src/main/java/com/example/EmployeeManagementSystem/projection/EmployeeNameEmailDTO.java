package com.example.EmployeeManagementSystem.projection;

public class EmployeeNameEmailDTO {

    private final String name;
    private final String email;

    public EmployeeNameEmailDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
