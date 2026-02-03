package com.example.RestAPI2.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;

import java.util.Date;

public class EmployeeDTO {

    private Integer id;
    @NotNull(message = "Employee name cannot be null")
    private String name;
    @NotNull
    @Email(message = "Please provide a valid email address")
    private String email;

    @NotNull(message = "Department name cannot be null")
    private String department;

    private Date createdAt;



    @Column(nullable = false)
    @NotBlank(message = "Password cannot be null or blank")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).*", message = "Password must contain at least one digit, one lowercase, and one uppercase letter")
    private String password;
    public EmployeeDTO(){

    }

    public EmployeeDTO(Integer id, String name, String email, String department, Date createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.createdAt = createdAt;

    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
         name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
